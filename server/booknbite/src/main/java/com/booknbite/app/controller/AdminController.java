package com.booknbite.app.controller;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.Restoran;
import com.booknbite.app.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    private final AdministratorService administratorService;

    @Autowired
    public AdminController(AdministratorService administratorService){
        this.administratorService = administratorService;
    }

    @GetMapping("/get-reviewers")
    public ResponseEntity<List<Ocjenjivac>> listaOcjenjivaca(){
        return ResponseEntity.ok(administratorService.listaOcjenjivaca());
    }

    @GetMapping("/get-restaurants")
    public ResponseEntity<List<Restoran>> listaRestorana(){
        return ResponseEntity.ok(administratorService.listaRestorana());
    }
}
