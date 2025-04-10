package com.os.WebOS.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    @NotBlank(message = "Campo obrigatório!")
    private String cpfCnpj;

    @NotBlank(message = "Campo obrigatório!")
    private String senha;
}
