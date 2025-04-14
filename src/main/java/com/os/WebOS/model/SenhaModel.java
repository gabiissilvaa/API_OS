package com.os.WebOS.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Setter
@Immutable
@Table(name = "view_cliente_usuario_os_web")
public class SenhaModel {
    @Id

    @Column(name = "cpf_cnpj", nullable = false)
    private String cpfCnpj;

    @Column(name = "senha_acesso_os_web", nullable = false)
    private String senhaAcessoOsWeb;
}
