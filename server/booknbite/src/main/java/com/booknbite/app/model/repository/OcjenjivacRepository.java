package com.booknbite.app.model.repository;

import com.booknbite.app.model.Ocjenjivac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OcjenjivacRepository extends JpaRepository<Ocjenjivac, String> {
    List<Ocjenjivac> findAllByGroupCode(String groupCode);
}
