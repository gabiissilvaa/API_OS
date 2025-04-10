package com.os.WebOS.service;

import com.os.WebOS.dto.AuthRequest;
import com.os.WebOS.dto.LoginResponse;
import com.os.WebOS.repository.ClienteRepository;
import com.os.WebOS.repository.OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OSRepository osRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private OSService osService;

}
