package com.booknbite.app.model.repository;

import com.booknbite.app.model.Grupa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface GrupaRepository extends JpaRepository<Grupa, Long> {
    Optional<Grupa> findByGrupaKod(String grupaKod);

    @Transactional
    @Modifying
    @Query("DELETE FROM Grupa g WHERE g.createdAt < :expiryTime")
    void deleteExpiredGroups(LocalDateTime expiryTime);
}
