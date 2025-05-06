package com.os.WebOS.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "log_acesso_os_web")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "documento", nullable = false, unique = true)
    private String cpfCnpj;

    @Column(name = "dt", nullable = false)
    private LocalDateTime dataAcesso;

    @PrePersist
    protected void onCreate() {
        this.dataAcesso = LocalDateTime.now();
    }
}
