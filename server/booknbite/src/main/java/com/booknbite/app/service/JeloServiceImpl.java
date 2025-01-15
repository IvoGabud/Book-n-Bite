package com.booknbite.app.service;

import com.booknbite.app.model.Grupa;
import com.booknbite.app.model.repository.GrupaRepository;
import com.booknbite.app.model.repository.JeloRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JeloServiceImpl implements JeloService {

    private final JeloRepository jeloRepository;
    private final GrupaRepository grupaRepository;

    public JeloServiceImpl(JeloRepository jeloRepository, GrupaRepository grupaRepository){
        this.jeloRepository = jeloRepository;
        this.grupaRepository = grupaRepository;
    }

    @Override
    public List<Jelo> getJeloList(String groupCode) {

        Optional<Grupa> grupaOptional = grupaRepository.findByGrupaKod(groupCode);
        Grupa grupa = new Grupa();
        if(grupaOptional.isPresent())
            grupa = grupaOptional.get();

        String kategorija = grupa.getGrupaKategorija();

        List<Jelo> jela;
        Optional<List<Jelo>> jelaOptional = jeloRepository.findAllByKategorija(kategorija);
        if(jelaOptional.isPresent())
            jela = jelaOptional.get();
        else
            return null;

        return jela;
    }
}
