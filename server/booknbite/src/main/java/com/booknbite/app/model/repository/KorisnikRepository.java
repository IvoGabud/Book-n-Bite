package com.booknbite.app.model.repository;

import com.booknbite.app.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, String> {
    void removeByKorisnikId(String korisnikId);
}
