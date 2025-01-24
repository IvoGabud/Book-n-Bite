package com.booknbite.app.service;

import com.booknbite.app.model.Ocjenjivac;
import com.booknbite.app.model.repository.OcjenjivacRepository;
import com.booknbite.app.model.request.UpdateOcjenjivacRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;
import java.util.Optional;

@Service
public class OcjenjivacServiceImpl implements OcjenjivacService{

    private final OcjenjivacRepository ocjenjivacRepository;

    @Autowired
    public OcjenjivacServiceImpl(OcjenjivacRepository ocjenjivacRepository){
        this.ocjenjivacRepository = ocjenjivacRepository;
    }

    //dohvaca podatke za ocjenjivaca
    @Override
    public Ocjenjivac ocjenjivacPodaci(OAuth2User token) {
        Optional<Ocjenjivac> ocjenjivacOptional = ocjenjivacRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));
        return ocjenjivacOptional.orElse(null);
    }

    //omogucuje uredivanje podataka za ocjenjivaca
    @Override
    public String urediPodatke(OAuth2User token, UpdateOcjenjivacRequest ocjenjivacRequest) {
        Optional<Ocjenjivac> ocjenjivacOptional = ocjenjivacRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));

        Ocjenjivac ocjenjivac;
        if (ocjenjivacOptional.isPresent())
            ocjenjivac = ocjenjivacOptional.get();
        else
            return "Nije moguce azurirati ocjenjivaca jer taj id ne postoji.";

        ocjenjivac.setUsername(ocjenjivacRequest.getUsername());
        ocjenjivac.setFirstName(ocjenjivacRequest.getFirstName());
        ocjenjivac.setLastName(ocjenjivacRequest.getLastName());

        ocjenjivacRepository.save(ocjenjivac);

        return "Ocjenjivac je uspjesno azuriran.";
    }

    //funkcionalnost za uklanjanje korisnika iz grupe
    @Override
    public String izadiIzGrupe(OAuth2User token) {
        Optional<Ocjenjivac> ocjenjivacOptional = ocjenjivacRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));

        Ocjenjivac ocjenjivac;
        if (ocjenjivacOptional.isPresent())
            ocjenjivac = ocjenjivacOptional.get();
        else{
            return "Cannot leave the group.";
        }

        ocjenjivac.setGroupCode("");
        ocjenjivacRepository.save(ocjenjivac);
        return "Uspjesan izlazak iz grupe.";
    }
}