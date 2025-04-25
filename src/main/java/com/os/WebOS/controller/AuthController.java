package com.os.WebOS.controller;

import com.os.WebOS.dto.AuthRequest;
import com.os.WebOS.model.SenhaModel;
import com.os.WebOS.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<SenhaModel> login(@RequestBody AuthRequest request) {
        return authService.autenticar(request);
    }
}