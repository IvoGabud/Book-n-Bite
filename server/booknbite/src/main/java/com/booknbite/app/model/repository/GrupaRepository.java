package com.booknbite.app.model.repository;

import com.booknbite.app.model.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrupaRepository extends JpaRepository<Grupa, Long> {
    Optional<Grupa> findByGroupCode(String groupCode);
}
