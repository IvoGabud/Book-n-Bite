package com.booknbite.app.service;

import com.booknbite.app.model.request.JeloRestoranDTO;
import java.util.List;

public interface JeloRestoranService {
    List<JeloRestoranDTO> getJeloRestoranList(String groupCode);
}
