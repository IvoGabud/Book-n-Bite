package com.booknbite.app.service;


import com.booknbite.app.model.Jelo;

import java.util.List;

public interface JeloService {
    List<Jelo> getJeloList(String groupCode);
}
