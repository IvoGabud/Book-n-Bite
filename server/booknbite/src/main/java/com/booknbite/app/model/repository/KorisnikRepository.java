package com.booknbite.app.model.repository;

import com.booknbite.app.model.Ocjenjivac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Ocjenjivac, String> {
}
