package com.os.WebOS.service;

import com.os.WebOS.dto.AuthRequest;
import com.os.WebOS.dto.LoginResponse;
import com.os.WebOS.dto.OSDto;
import com.os.WebOS.exception.UsuarioNaoEncontradoException;
import com.os.WebOS.model.ClienteModel;
import com.os.WebOS.repository.ClienteRepository;
import com.os.WebOS.repository.OSRepository;
import com.os.WebOS.repository.SenhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OSRepository osRepository;

    @Autowired
    private OSService osService;

    @Autowired
    private SenhaRepository senhaRepository;

    private boolean validarCpfCnpj(String documento) {
        return documento != null && !documento.trim().isEmpty();
    }

    public LoginResponse autenticar(AuthRequest request) {
        String cpfCnpj = request.getCpfCnpj();
        String senha = request.getSenha();

        if (!validarCpfCnpj(cpfCnpj)
                || !senhaRepository.findByCpfCnpj(cpfCnpj)
                .map(s -> senha.equals(s.getSenhaAcessoOsWeb()))
                .orElse(false)) {
            throw new IllegalArgumentException("Credenciais inválidas");
        }

        ClienteModel cliente = clienteRepository.findByCpfCnpj(request.getCpfCnpj())
                .orElseThrow(() -> {
                    System.out.println("Cliente não encontrado com CPF/CNPJ: " + request.getCpfCnpj());
                    return new UsuarioNaoEncontradoException("Nenhuma OS encontrada");
                });

        List<OSDto> ordensServico = osService.listarPorCliente(cliente.getIdcliente());

        return new LoginResponse(
                cliente.getIdOs(),
                cliente.getEquipamento(),
                cliente.getGarantia(),
                cliente.getSituacao(),
                cliente.getDataEntrada(),
                cliente.getNome(),
                ordensServico
        );
    }
}
