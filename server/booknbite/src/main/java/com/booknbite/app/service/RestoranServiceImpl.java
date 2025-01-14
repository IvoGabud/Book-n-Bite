package com.booknbite.app.service;

import com.booknbite.app.model.JeloRestoran;
import com.booknbite.app.model.Restoran;
import com.booknbite.app.model.repository.JeloRestoranRepository;
import com.booknbite.app.model.repository.RestoranRepository;
import com.booknbite.app.model.request.CreateJeloRestoranRequest;
import com.booknbite.app.model.request.CreateRestoranInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

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
}
