package com.croco.repository.api;

import com.croco.bean.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrocoGeneralRepository extends JpaRepository<DAOUser, Long> {
    DAOUser findByUsername(String username);
}
