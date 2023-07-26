package com.bitala.apiprueba.controllers;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitala.apiprueba.repository.IChecksRepository;

import com.bitala.apiprueba.models.Checks;

@RestController
@RequestMapping("/api")
public class ChecksController {
    @Autowired
    private IChecksRepository checksRepository;
    
}
