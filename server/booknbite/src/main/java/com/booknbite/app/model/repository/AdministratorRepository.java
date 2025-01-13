package com.booknbite.app.model.repository;

import com.booknbite.app.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, String> {
}
