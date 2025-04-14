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
    @Column(name = "id_os")
    private Long id;

    @Column(name = "idcliente", nullable = false)
    private Long idcliente;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "problema_relatado", nullable = false)
    private String problemaRelatado;

    @Column(name = "tecnico_responsavel", nullable = false)
    private String tecnico;

    @Column(name = "garantia", nullable = false)
    private String garantia;

    @Column(name = "DATA_ULTIMA_SITUACAO")
    private Date dataUltSituacao;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private ClienteModel cliente;
}
