package com.booknbite.app.service;

import com.booknbite.app.model.Grupa;
import com.booknbite.app.model.Ocjena;
import com.booknbite.app.model.repository.GrupaRepository;
import com.booknbite.app.model.repository.OcjenaRepository;
import com.booknbite.app.model.request.CreateRatingRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OcjenaServiceImpl implements OcjenaService{

    private final GrupaRepository grupaRepository;
    private final OcjenaRepository ocjenaRepository;

    public OcjenaServiceImpl(OcjenaRepository ocjenaRepository, GrupaRepository grupaRepository){
        this.ocjenaRepository = ocjenaRepository;
        this.grupaRepository = grupaRepository;
    }

    @Override
    public String spremiOcjene(String groupCode, OAuth2User token, CreateRatingRequest ratingRequest) {

        Optional<Grupa> grupaOptional = grupaRepository.findByGrupaKod(groupCode);
        Grupa grupa = new Grupa();
        if(grupaOptional.isPresent())
            grupa = grupaOptional.get();

        for(Map.Entry<Long, Integer> entry : ratingRequest.getMap().entrySet()){
            Ocjena ocjena = new Ocjena();
            ocjena.setGrupaKod(grupa.getGrupaKod());
            ocjena.setIdOcjenjivac(token.getAttribute("sub"));
            ocjena.setOcjena(entry.getValue());
            ocjena.setIdJela(entry.getKey());
            ocjenaRepository.save(ocjena);
        }

        return "Ocjene su spremljene.";
    }
}
