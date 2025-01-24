package com.booknbite.app.service;

import java.time.LocalDateTime;

public interface GrupaService {

    void deleteGrupaByExpiry(LocalDateTime expiryAt);
}
