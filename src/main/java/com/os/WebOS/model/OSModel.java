package com.os.WebOS.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.util.Date;

@Getter
@Setter
@Entity
@Immutable
@Table(name = "view_os_cliente_web")
public class OSModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_os", nullable = false)
    private Long idOs;

    @Column(name = "idcliente", nullable = false)
    private Long idcliente;

    @Column(name = "nomecliente", nullable = false)
    private String nome;

    @Column(name = "documentocliente", nullable = false)
    private String cpfCnpj;

    @Column(name = "problema_relatado", nullable = false)
    private String problemaRelatado;

    @Column(name = "tecnico_responsavel", nullable = false)
    private String tecnico;

    @Column(name = "garantia", nullable = false)
    private String garantia;

    @Column(name = "equipamento", nullable = false)
    private String equipamento;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "ultSituacao", nullable = false)
    private String situacao;

    @Column(name = "dtEntrada", nullable = false)
    private Date dataEntrada;

    @Column(name = "DATA_ULTIMA_SITUACAO")
    private Date dataUltSituacao;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private ClienteModel cliente;
}
