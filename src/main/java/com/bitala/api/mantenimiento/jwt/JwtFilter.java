package com.bitala.api.mantenimiento.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Esta clase valida el token junto con el usuario
@Component
public class JwtFilter extends OncePerRequestFilter{

    //Anotación para inyección de dependencias
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomerDetailsService detailsService;

    Claims claims = null;
    private String username = null;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().matches("/api/usuario/login|/api/usuario/forgot-password|/api/usuario")) {
            filterChain.doFilter(request, response);
        }else {
            String authorizationHeader = request.getHeader("Authorization");
            String token = null;

            if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
                //Se corta el string quitandole ("Bearer ") y así solo se obtiene el token
                token = authorizationHeader.substring(7);
                //Se extrae el username del token
                username = jwtUtil.extractUserName(token);
                claims = jwtUtil.extractAllClaims(token);
            }

            //En el caso de que el usuario no este autenticado
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = detailsService.loadUserByUsername(username);
                if (jwtUtil.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =  new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    new WebAuthenticationDetailsSource().buildDetails(request);
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            filterChain.doFilter(request, response);
        }
        throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");
    }

    //Verificando si es admin, es caso verdadero devuelve TRUE
    public Boolean isAdmin(){
        return "admin".equalsIgnoreCase((String) claims.get("rol"));
    }

    //Verificando si es user, es caso verdadero devuelve TRUE
    public Boolean isUser(){
        return "user".equalsIgnoreCase((String) claims.get("rol"));
    }

    public String getCurrtentUser(){
        return username;
    }
}
