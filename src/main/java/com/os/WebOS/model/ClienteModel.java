package com.os.WebOS.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "view_os_cliente_web")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomecliente", nullable = false)
    private String nome;

    @Column(name = "documentocliente", nullable = false)
    private String cpfCnpj;

    @Column(name = "equipamento", nullable = false)
    private String equipamento;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "ultSituacao", nullable = false)
    private String situacao;

    @Column(name = "dtEntrada", nullable = false)
    private Date dataEntrada;
}
