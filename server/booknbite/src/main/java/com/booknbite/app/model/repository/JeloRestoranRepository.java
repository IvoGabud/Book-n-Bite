package com.booknbite.app.model.repository;

import com.booknbite.app.model.JeloRestoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JeloRestoranRepository extends JpaRepository<JeloRestoran, Long> {
}
