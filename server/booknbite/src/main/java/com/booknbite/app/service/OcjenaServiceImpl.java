package com.booknbite.app.service;

import com.booknbite.app.model.Grupa;
import com.booknbite.app.model.Ocjena;
import com.booknbite.app.model.repository.GrupaRepository;
import com.booknbite.app.model.repository.OcjenaRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

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
    public String spremiOcjene(String groupCode, OAuth2User token, Map<String, Integer> ratingRequest) {

        Optional<Grupa> grupaOptional = grupaRepository.findByGrupaKod(groupCode);
        Grupa grupa = new Grupa();
        if(grupaOptional.isPresent())
            grupa = grupaOptional.get();

        for(Map.Entry<String, Integer> entry : ratingRequest.entrySet()){
            Ocjena ocjena = new Ocjena();
            ocjena.setGrupaKod(grupa.getGrupaKod());
            ocjena.setIdOcjenjivac(token.getAttribute("sub"));
            ocjena.setOcjena(entry.getValue());
            ocjena.setIdJela(Long.valueOf(entry.getKey()));
            ocjenaRepository.save(ocjena);
        }

        return "Ocjene su spremljene.";
    }
}
