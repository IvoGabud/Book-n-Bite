package com.booknbite.app.model.repository;

import com.booknbite.app.model.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestoranRepository extends JpaRepository<Restoran, String> {
    List<Restoran> findAllByIsVerified(Boolean isVerified);
}
