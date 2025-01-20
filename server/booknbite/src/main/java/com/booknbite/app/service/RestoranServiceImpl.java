package com.booknbite.app.service;

import com.booknbite.app.model.JeloRestoran;
import com.booknbite.app.model.Restoran;
import com.booknbite.app.model.repository.JeloRestoranRepository;
import com.booknbite.app.model.repository.RestoranRepository;
import com.booknbite.app.model.request.CreateJeloRestoranRequest;
import com.booknbite.app.model.request.CreateRestoranInfo;
import com.booknbite.app.model.request.JeloRestoranDTO;
import com.booknbite.app.model.request.RestoranDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
        restoran.setLngLok(restoranInfo.getLngLok());
        restoran.setLatLok(restoranInfo.getLatLok());
        restoran.setPoveznicaSlike(restoranInfo.getLink());
        restoran.setIsFilled(true);

        restoranRepository.save(restoran);

        return true;
    }

    @Override
    public RestoranDTO dohvatiRestoran(OAuth2User token) {
        Restoran restoran =  restoran(token);
        RestoranDTO restoranDTO = new RestoranDTO();

        restoranDTO.setBrojTelefona(restoran.getBrojTelefona());
        restoranDTO.setCjenovniRang(restoran.getCjenovniRang());
        restoranDTO.setFilled(restoran.getIsFilled());
        restoranDTO.setFirstName(restoran.getFirstName());
        restoranDTO.setLastName(restoran.getLastName());
        restoranDTO.setLatLok(restoran.getLatLok());
        restoranDTO.setLngLok(restoran.getLngLok());
        restoranDTO.setRadnoVrijemeOd(restoran.getRadnoVrijemeOd());
        restoranDTO.setRadnoVrijemeDo(restoran.getRadnoVrijemeDo());
        restoranDTO.setNazivRestoran(restoran.getNazivRestoran());
        restoranDTO.setVerified(restoran.getIsVerified());
        restoranDTO.setPoveznicaSlike(restoran.getPoveznicaSlike());
        restoranDTO.setUsername(restoran.getUsername());
        return restoranDTO;
    }

    @Override
    public String napraviJelo(CreateJeloRestoranRequest jeloRestoranRequest, OAuth2User token) throws IOException {
        JeloRestoran jeloRestoran = new JeloRestoran();

        jeloRestoran.setNaziv(jeloRestoranRequest.getNaziv());
        jeloRestoran.setOpis(jeloRestoranRequest.getOpis());
        jeloRestoran.setCijena(jeloRestoranRequest.getCijena().toString());
        jeloRestoran.setAlergeni(jeloRestoranRequest.getAlergeni());
        jeloRestoran.setKategorija(jeloRestoranRequest.getKategorija());
        jeloRestoran.setSlikaJelaUrl(ImageService.uploadImage(jeloRestoranRequest.getImageSrc()));
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
    public Map<String, List<JeloRestoranDTO>> dohvatiJelaPoKategoriji(OAuth2User token) {
        Map<String, List<JeloRestoranDTO>> map = new HashMap<>();

        Optional<Restoran> restoranOptional = restoranRepository.findById(Objects.requireNonNull(token.getAttribute("sub")));

        Restoran restoran;
        if (restoranOptional.isPresent()) {
            restoran = restoranOptional.get();
        }else
            throw new RuntimeException("Restoran ne postoji!!!");

        List<JeloRestoran> jela = jeloRestoranRepository.findAllByRestoran(restoran);

        List<JeloRestoranDTO> jelaRestoran = new ArrayList<>();
        for (JeloRestoran jelo : jela){
            JeloRestoranDTO jeloRestoran = new JeloRestoranDTO();
            jeloRestoran.setAlergeni(jelo.getAlergeni());
            jeloRestoran.setCijena(jelo.getCijena());
            jeloRestoran.setJeloRestoranId(jelo.getJeloRestoranId());
            jeloRestoran.setKategorija(jelo.getKategorija());
            jeloRestoran.setOpisJela(jelo.getOpis());
            jeloRestoran.setImageSrc(jelo.getSlikaJelaUrl());
            jeloRestoran.setNazivJela(jelo.getNaziv());
            jelaRestoran.add(jeloRestoran);
        }

        for (JeloRestoranDTO jelo : jelaRestoran){
            if (!map.containsKey(jelo.getKategorija())) {
                List<JeloRestoranDTO> listaJela = new ArrayList<>();
                listaJela.add(jelo);
                map.put(jelo.getKategorija(), listaJela);
            }else{
                map.get(jelo.getKategorija()).add(jelo);
            }
        }

        return map;
    }

    @Override
    public RestoranDTO prikaziRestoran(String id) {
        Optional<Restoran> restoranOptional = restoranRepository.findById(id);

        Restoran restoran;
        if(restoranOptional.isPresent())
            restoran = restoranOptional.get();
        else
            return new RestoranDTO();

        RestoranDTO dto = new RestoranDTO();
        dto.setBrojTelefona(restoran.getBrojTelefona());
        dto.setCjenovniRang(restoran.getCjenovniRang());
        dto.setFilled(restoran.getIsFilled());
        dto.setFirstName(restoran.getFirstName());
        dto.setLastName(restoran.getLastName());
        dto.setLatLok(restoran.getLatLok());
        dto.setLngLok(restoran.getLngLok());
        dto.setRadnoVrijemeOd(restoran.getRadnoVrijemeOd());
        dto.setRadnoVrijemeDo(restoran.getRadnoVrijemeDo());
        dto.setNazivRestoran(restoran.getNazivRestoran());
        dto.setVerified(restoran.getIsVerified());
        dto.setPoveznicaSlike(restoran.getPoveznicaSlike());
        dto.setUsername(restoran.getUsername());
        return dto;
    }

    @Override
    public Map<String, List<JeloRestoranDTO>> dohvatiJelaPoKategorijiOcj(String id) {
        Map<String, List<JeloRestoranDTO>> map = new HashMap<>();

        Optional<Restoran> restoranOptional = restoranRepository.findById(id);

        Restoran restoran;
        if (restoranOptional.isPresent()) {
            restoran = restoranOptional.get();
        }else
            throw new RuntimeException("Restoran ne postoji!!!");

        List<JeloRestoran> jela = jeloRestoranRepository.findAllByRestoran(restoran);

        List<JeloRestoranDTO> jelaRestoran = new ArrayList<>();
        for (JeloRestoran jelo : jela){
            JeloRestoranDTO jeloRestoran = new JeloRestoranDTO();
            jeloRestoran.setAlergeni(jelo.getAlergeni());
            jeloRestoran.setCijena(jelo.getCijena());
            jeloRestoran.setJeloRestoranId(jelo.getJeloRestoranId());
            jeloRestoran.setKategorija(jelo.getKategorija());
            jeloRestoran.setOpisJela(jelo.getOpis());
            jeloRestoran.setImageSrc(jelo.getSlikaJelaUrl());
            jeloRestoran.setNazivJela(jelo.getNaziv());
            jelaRestoran.add(jeloRestoran);
        }

        for (JeloRestoranDTO jelo : jelaRestoran){
            if (!map.containsKey(jelo.getKategorija())) {
                List<JeloRestoranDTO> listaJela = new ArrayList<>();
                listaJela.add(jelo);
                map.put(jelo.getKategorija(), listaJela);
            }else{
                map.get(jelo.getKategorija()).add(jelo);
            }
        }

        return map;
    }
}
