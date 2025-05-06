package com.os.WebOS.service;

import com.os.WebOS.dto.AuthRequest;
import com.os.WebOS.model.SenhaModel;
import com.os.WebOS.model.UsuarioModel;
import com.os.WebOS.repository.SenhaRepository;
import com.os.WebOS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private SenhaRepository senhaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    private boolean validarCpfCnpj(String documento) {
        return documento != null && !documento.trim().isEmpty();
    }

    public ResponseEntity<SenhaModel> autenticar(AuthRequest request) {
        String cpfCnpj = request.getCpfCnpj();
        String senha = request.getSenha();

        if (!validarCpfCnpj(cpfCnpj)) {
            throw new IllegalArgumentException("Credenciais inválidas");
        }

        Optional<SenhaModel> s = senhaRepository.findByCpfCnpjAndSenhaAcessoOsWeb(cpfCnpj, senha);

        if (s.isPresent()){

            UsuarioModel u = new UsuarioModel();
            u.setCpfCnpj(s.get().getCpfCnpj());
            usuarioRepository.save(u);

            return ResponseEntity.ok(s.get());
    }
        return s.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
