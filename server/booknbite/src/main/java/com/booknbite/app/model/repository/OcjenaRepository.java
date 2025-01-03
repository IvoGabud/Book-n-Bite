package com.booknbite.app.model.repository;

import com.booknbite.app.model.Ocjena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcjenaRepository extends JpaRepository<Ocjena, Long> {
}
