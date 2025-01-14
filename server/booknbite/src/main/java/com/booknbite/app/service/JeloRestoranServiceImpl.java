package com.booknbite.app.service;

import com.booknbite.app.model.Grupa;
import com.booknbite.app.model.Jelo;
import com.booknbite.app.model.JeloRestoran;
import com.booknbite.app.model.repository.GrupaRepository;
import com.booknbite.app.model.repository.JeloRestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

    @Override
    public List<JeloRestoran> getJeloRestoranList(String groupCode) {
        Optional<Grupa> grupaOptional = grupaRepository.findByGrupaKod(groupCode);
        Grupa grupa = new Grupa();
        if(grupaOptional.isPresent())
            grupa = grupaOptional.get();

        String kategorija = grupa.getGrupaKategorija();

        return jeloRestoranRepository.findAllByKategorija(kategorija);
    }
}
