package com.os.WebOS.service;

import com.os.WebOS.dto.AuthRequest;
import com.os.WebOS.dto.LoginResponse;
import com.os.WebOS.dto.OSDto;
import com.os.WebOS.exception.CredenciaisInvalidasException;
import com.os.WebOS.exception.UsuarioNaoEncontradoException;
import com.os.WebOS.model.ClienteModel;
import com.os.WebOS.model.SenhaModel;
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
        if (!validarCpfCnpj(request.getCpfCnpj())) {
            throw new IllegalArgumentException("CPF/CNPJ inválido");
        }

        SenhaModel dadosSenha = senhaRepository.findByCpfCnpj(request.getCpfCnpj())
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Credenciais inválidas"));

        if (!request.getSenha().equals(dadosSenha.getSenhaAcessoOsWeb())) {
            throw new CredenciaisInvalidasException("Senha incorreta");
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
                ordensServico
        );
    }
}
