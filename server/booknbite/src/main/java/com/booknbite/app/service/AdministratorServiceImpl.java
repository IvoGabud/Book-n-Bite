package com.booknbite.app.service;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.repository.OcjenjivacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorServiceImpl implements AdministratorService{

    private final OcjenjivacRepository ocjenjivacRepository;

    @Autowired
    public AdministratorServiceImpl(OcjenjivacRepository ocjenjivacRepository){
        this.ocjenjivacRepository = ocjenjivacRepository;
    }

    @Override
    public List<Ocjenjivac> listaOcjenjivaca() {
        return ocjenjivacRepository.findAll();
    }
}
