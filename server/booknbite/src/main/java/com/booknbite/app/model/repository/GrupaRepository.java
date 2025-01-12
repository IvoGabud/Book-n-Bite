package com.booknbite.app.model.repository;

import com.booknbite.app.model.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrupaRepository extends JpaRepository<Grupa, Long> {
    Optional<Grupa> findByGrupaKod(String grupaKod);
}
