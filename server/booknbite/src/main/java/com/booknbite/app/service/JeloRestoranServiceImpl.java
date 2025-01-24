package com.booknbite.app.service;

import com.booknbite.app.model.Grupa;
import com.booknbite.app.model.JeloRestoran;
import com.booknbite.app.model.repository.GrupaRepository;
import com.booknbite.app.model.repository.JeloRestoranRepository;
import com.booknbite.app.model.request.JeloRestoranDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JeloRestoranServiceImpl implements JeloRestoranService{

    private final JeloRestoranRepository jeloRestoranRepository;
    private final GrupaRepository grupaRepository;

    @Autowired
    public JeloRestoranServiceImpl(JeloRestoranRepository jeloRestoranRepository, GrupaRepository grupaRepository){
        this.jeloRestoranRepository = jeloRestoranRepository;
        this.grupaRepository = grupaRepository;
    }

    //dohvati listu jela za ocjenjivaca da ih ocijeni
    @Override
    public List<JeloRestoranDTO> getJeloRestoranList(String groupCode) {
        Optional<Grupa> grupaOptional = grupaRepository.findByGrupaKod(groupCode);
        Grupa grupa = new Grupa();
        if(grupaOptional.isPresent())
            grupa = grupaOptional.get();

        String kategorija = grupa.getGrupaKategorija();

        List<JeloRestoran> jela = jeloRestoranRepository.findAllByKategorija(kategorija);

        List<JeloRestoranDTO> listaJela = new ArrayList<>();

        for (JeloRestoran jelo : jela){
            JeloRestoranDTO jeloRestoranDTO = new JeloRestoranDTO();
            jeloRestoranDTO.setOpisJela(jelo.getOpis());
            jeloRestoranDTO.setKategorija(jelo.getKategorija());
            jeloRestoranDTO.setCijena(jelo.getCijena());
            jeloRestoranDTO.setAlergeni(jelo.getAlergeni());
            jeloRestoranDTO.setImageSrc(jelo.getSlikaJelaUrl());
            jeloRestoranDTO.setJeloRestoranId(jelo.getJeloRestoranId());
            jeloRestoranDTO.setNazivJela(jelo.getNaziv());
            listaJela.add(jeloRestoranDTO);
        }

        return listaJela;
    }
}
