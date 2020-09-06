package com.croco.service.impl;

import com.croco.bean.DAOUser;
import com.croco.repository.api.CrocoGeneralRepository;
import com.croco.security.service.CrocoUserDetailsService;
import com.croco.service.api.CrocoGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CrocoGeneralServiceImpl implements CrocoGeneralService {

    @Autowired
    CrocoGeneralRepository crocoGeneralRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public DAOUser saveUser(DAOUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return crocoGeneralRepository.save(user);
    }
}
