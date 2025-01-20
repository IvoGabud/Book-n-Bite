package com.booknbite.app.service;

import com.booknbite.app.model.Grupa;
import com.booknbite.app.model.Ocjena;
import com.booknbite.app.model.repository.GrupaRepository;
import com.booknbite.app.model.repository.OcjenaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GrupaServiceImpl implements GrupaService{

    private final GrupaRepository grupaRepository;
    private final OcjenaRepository ocjenaRepository;

    @Autowired
    public GrupaServiceImpl(GrupaRepository grupaRepository, OcjenaRepository ocjenaRepository){
        this.grupaRepository = grupaRepository;
        this.ocjenaRepository = ocjenaRepository;
    }

    @Transactional
    @Override
    public void deleteGrupaByExpiry(LocalDateTime expiryAt) {
        List<Grupa> grupas = grupaRepository.findAll();

        for (Grupa grupa : grupas){
            if(expiryAt.isAfter(grupa.getCreatedAt())){
                List<Ocjena> ocjenas = ocjenaRepository.findAllByGrupaKod(grupa.getGrupaKod());
                ocjenaRepository.deleteAll(ocjenas);
                grupaRepository.delete(grupa);
            }
        }
    }
}
