package com.os.WebOS.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Immutable
@Table(name = "view_os_cliente_web")
public class ClienteModel {
    @Id
    @Column(name = "id_os", nullable = false)
    private Long idOs;

    @Column(name = "idcliente", nullable = false)
    private Long idcliente;

    @Column(name = "equipamento", nullable = false)
    private String equipamento;

    @Column(name = "dtEntrada", nullable = false)
    private Date dataEntrada;

    @Column(name = "garantia", nullable = false)
    private String garantia;

    @Column(name = "ultSituacao", nullable = false)
    private String situacao;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<OSModel> ordensServico;
}
