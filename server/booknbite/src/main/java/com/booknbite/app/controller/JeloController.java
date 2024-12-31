package com.booknbite.app.controller;

import com.booknbite.app.model.Jelo;
import com.booknbite.app.service.JeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JeloController {

    private final JeloService jeloService;

    @Autowired
    public JeloController(JeloService jeloService){
        this.jeloService = jeloService;
    }

    @GetMapping("/products/{groupCode}")
    public ResponseEntity<List<Jelo>> dohvatiJela(@PathVariable String groupCode){
        return ResponseEntity.ok(jeloService.getJeloList(groupCode));
    }

}
