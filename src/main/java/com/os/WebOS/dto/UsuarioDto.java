package com.os.WebOS.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UsuarioDto {
    private LocalDateTime dataAcesso;
    private String cpfCnpj;
}
