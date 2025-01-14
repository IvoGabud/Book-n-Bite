package com.booknbite.app.service;

import com.booknbite.app.model.JeloRestoran;
import com.booknbite.app.model.Restoran;
import com.booknbite.app.model.repository.JeloRestoranRepository;
import com.booknbite.app.model.repository.RestoranRepository;
import com.booknbite.app.model.request.CreateJeloRestoranRequest;
import com.booknbite.app.model.request.CreateRestoranInfo;
import com.booknbite.app.model.request.JeloRestoranDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RestoranServiceImpl implements RestoranService{

    private final RestoranRepository restoranRepository;
    private final JeloRestoranRepository jeloRestoranRepository;

    @Autowired
    public RestoranServiceImpl(RestoranRepository restoranRepository, JeloRestoranRepository jeloRestoranRepository){
        this.restoranRepository = restoranRepository;
        this.jeloRestoranRepository = jeloRestoranRepository;
    }

    @Override
    public Boolean ispuniFormu(OAuth2User token, CreateRestoranInfo restoranInfo) {
        Optional<Restoran> restoranOptional = restoranRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));

        Restoran restoran;
        if (restoranOptional.isPresent())
            restoran = restoranOptional.get();
        else
            return false;

        restoran.setNazivRestoran(restoranInfo.getNazivRestoran());
        restoran.setRadnoVrijemeOd(restoranInfo.getOdVrijeme());
        restoran.setRadnoVrijemeDo(restoranInfo.getDoVrijeme());
        restoran.setBrojTelefona(restoranInfo.getBrTelefon());
        restoran.setLokacija(restoranInfo.getAdresa());
        restoran.setPoveznicaSlike(restoranInfo.getLink());
        restoran.setIsFilled(true);

        restoranRepository.save(restoran);

        return true;
    }

    @Override
    public Restoran dohvatiRestoran(OAuth2User token) {
        return restoran(token);
    }

    @Override
    public String napraviJelo(CreateJeloRestoranRequest jeloRestoranRequest, OAuth2User token) {
        JeloRestoran jeloRestoran = new JeloRestoran();

        jeloRestoran.setNaziv(jeloRestoranRequest.getNaziv());
        jeloRestoran.setOpis(jeloRestoranRequest.getOpis());
        jeloRestoran.setCijena(jeloRestoranRequest.getCijena());
        jeloRestoran.setAlergeni(jeloRestoranRequest.getAlergeni());
        jeloRestoran.setKategorija(jeloRestoranRequest.getKategorija());
        jeloRestoran.setRestoran(restoran(token));

        jeloRestoranRepository.save(jeloRestoran);

        return "Jelo dodano u bazu.";
    }

    public Restoran restoran(OAuth2User token){
        Optional<Restoran> restoranOptional = restoranRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));

        Restoran restoran;
        if (restoranOptional.isPresent()) {
            restoran = restoranOptional.get();
            return restoran;
        }

        return null;
    }

    @Override
    public Map<String, List<JeloRestoranDAO>> dohvatiJelaPoKategoriji(OAuth2User token) {
        Map<String, List<JeloRestoranDAO>> map = new HashMap<>();

        Optional<Restoran> restoranOptional = restoranRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));

        Restoran restoran;
        if (restoranOptional.isPresent()) {
            restoran = restoranOptional.get();
        }else
            throw new RuntimeException("Restoran ne postoji!!!");

        List<JeloRestoran> jela = jeloRestoranRepository.findAllByRestoran(restoran);

        List<JeloRestoranDAO> jelaRestoran = new ArrayList<>();
        for (JeloRestoran jelo : jela){
            JeloRestoranDAO jeloRestoran = new JeloRestoranDAO();
            jeloRestoran.setAlergeni(jelo.getAlergeni());
            jeloRestoran.setCijena(jelo.getCijena());
            jeloRestoran.setJeloRestoranId(jelo.getJeloRestoranId());
            jeloRestoran.setKategorija(jelo.getKategorija());
            jeloRestoran.setOpis(jelo.getOpis());
            jeloRestoran.setSlikaJelaUrl(jelo.getSlikaJelaUrl());
            jeloRestoran.setNaziv(jelo.getNaziv());
            jelaRestoran.add(jeloRestoran);
        }

        for (JeloRestoranDAO jelo : jelaRestoran){
            if (!map.containsKey(jelo.getKategorija())) {
                List<JeloRestoranDAO> listaJela = new ArrayList<>();
                listaJela.add(jelo);
                map.put(jelo.getKategorija(), listaJela);
            }else{
                map.get(jelo.getKategorija()).add(jelo);
            }
        }

        return map;
    }
}
