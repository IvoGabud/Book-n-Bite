package com.booknbite.app.service;

import com.booknbite.app.model.Grupa;
import com.booknbite.app.model.Ocjena;
import com.booknbite.app.model.repository.GrupaRepository;
import com.booknbite.app.model.repository.OcjenaRepository;
import com.booknbite.app.model.request.CreateRatingRequest;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public String spremiOcjene(String groupCode, Long userId, List<CreateRatingRequest> ratingRequest) {

        Optional<Grupa> grupaOptional = grupaRepository.findByGrupaKod(groupCode);
        Grupa grupa = new Grupa();
        if(grupaOptional.isPresent())
            grupa = grupaOptional.get();

        for(CreateRatingRequest request : ratingRequest){
            Ocjena ocjena = new Ocjena();
            ocjena.setGrupaKod(grupa.getGrupaKod());
            ocjena.setIdOcjenjivac(userId);
            ocjena.setOcjena(request.getRating());
            ocjena.setIdJela(request.getJeloId());
            ocjenaRepository.save(ocjena);
        }

        return "Ocjene su spremljene.";
    }
}
