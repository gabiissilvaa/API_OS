package com.os.WebOS.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "view_os_cliente_web")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "equipamento", nullable = false)
    private String equipamento;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "ultSituacao", nullable = false)
    private String situacao;

    @Column(name = "dtEntrada", nullable = false)
    private Date dataEntrada;

    @OneToMany(mappedBy = "cliente")
    private List<OSModel> ordensServicos;
}
