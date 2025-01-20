package com.booknbite.app.security;

import com.booknbite.app.model.repository.GrupaRepository;
import com.booknbite.app.service.GrupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GrupaCleanupTask {

    private final GrupaService grupaService;

    @Autowired
    public GrupaCleanupTask(GrupaService grupaService){
        this.grupaService = grupaService;
    }

    @Scheduled(fixedRate = 60000)
    public void cleanupExpiredGroups() {
        LocalDateTime expiryTime = LocalDateTime.now().minusMinutes(30);
        grupaService.deleteGrupaByExpiry(expiryTime);
        System.out.println("Expired groups deleted at: " + LocalDateTime.now());
    }
}
