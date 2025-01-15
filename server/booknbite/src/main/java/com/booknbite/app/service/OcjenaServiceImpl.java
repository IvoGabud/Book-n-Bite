package com.booknbite.app.service;

import com.booknbite.app.model.*;
import com.booknbite.app.model.repository.GrupaRepository;
import com.booknbite.app.model.repository.JeloRestoranRepository;
import com.booknbite.app.model.repository.OcjenaRepository;
import com.booknbite.app.model.repository.OcjenjivacRepository;
import com.booknbite.app.model.request.RestoranShortDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OcjenaServiceImpl implements OcjenaService{

    private final GrupaRepository grupaRepository;
    private final OcjenaRepository ocjenaRepository;
    private final OcjenjivacRepository ocjenjivacRepository;
    private final JeloRestoranRepository jeloRestoranRepository;

    @Autowired
    public OcjenaServiceImpl(JeloRestoranRepository jeloRestoranRepository, OcjenjivacRepository ocjenjivacRepository, OcjenaRepository ocjenaRepository, GrupaRepository grupaRepository){
        this.ocjenaRepository = ocjenaRepository;
        this.grupaRepository = grupaRepository;
        this.ocjenjivacRepository = ocjenjivacRepository;
        this.jeloRestoranRepository = jeloRestoranRepository;
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
            ocjena.setGrupa(grupa);
            ocjenaRepository.save(ocjena);
        }

        grupa.incrementCount();
        grupaRepository.save(grupa);

        return "Ocjene su spremljene.";
    }

    @Override
    public Boolean provjeriOcjene(String groupCode) {
        List<Ocjenjivac> ocjenjivaci = ocjenjivacRepository.findAllByGroupCode(groupCode);

        Optional<Grupa> grupaOptional = grupaRepository.findByGrupaKod(groupCode);
        Grupa grupa = new Grupa();
        if(grupaOptional.isPresent())
            grupa = grupaOptional.get();

        return ocjenjivaci.size() == grupa.getCount();
    }

    @Override
    public List<RestoranShortDTO> kalkulirajPreporuku(String groupCode) {
        Optional<Grupa> grupaOptional = grupaRepository.findByGrupaKod(groupCode);
        Grupa grupa = new Grupa();
        if(grupaOptional.isPresent())
            grupa = grupaOptional.get();

        List<Ocjena> ocjene = grupa.getOcjene();

        Map<String, Double> map = new HashMap<>();
        Map<String, Integer> counter = new HashMap<>();

        for (Ocjena ocjena : ocjene){
            Optional<JeloRestoran> jeloOptional = jeloRestoranRepository.findById(ocjena.getIdJela());
            JeloRestoran jelo;
            if(jeloOptional.isPresent())
                jelo = jeloOptional.get();
            else
                continue;

            String korIme = jelo.getRestoran().getNazivRestoran();

            if(!map.containsKey(korIme)){
                map.put(korIme, Double.valueOf(ocjena.getOcjena()));
                counter.put(korIme, 1);
            }else{
                Double temp = map.get(korIme);
                temp += ocjena.getOcjena();
                map.put(korIme, temp);
                Integer count = counter.get(korIme);
                count++;
                counter.put(korIme, count);
            }
        }

        List<RestoranShortDTO> list = new ArrayList<>();
        for(Map.Entry<String, Double> entry : map.entrySet()){
            RestoranShortDTO dto = new RestoranShortDTO();
            dto.setNazivRestoran(entry.getKey());
            dto.setOcjena(entry.getValue()/counter.get(entry.getKey()));
            list.add(dto);
        }

        list.sort(Comparator.comparing(RestoranShortDTO::getOcjena).reversed());
        return list;
    }
}
