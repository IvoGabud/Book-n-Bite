package com.booknbite.app.security;

import com.booknbite.app.model.repository.GrupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GrupaCleanupTask {

    private final GrupaRepository grupaRepository;

    @Autowired
    public GrupaCleanupTask(GrupaRepository grupaRepository){
        this.grupaRepository = grupaRepository;
    }

    @Scheduled(fixedRate = 60000)
    public void cleanupExpiredGroups() {
        LocalDateTime expiryTime = LocalDateTime.now().minusMinutes(1);
        grupaRepository.deleteExpiredGroups(expiryTime);
        System.out.println("Expired groups deleted at: " + LocalDateTime.now());
    }
}
