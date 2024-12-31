package com.booknbite.app.model.repository;

import com.booknbite.app.model.Jelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JeloRepository extends JpaRepository<Jelo, Long> {
    Optional<List<Jelo>> findAllByKategorija(String kategorija);
}
