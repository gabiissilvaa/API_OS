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
    @Column(name = "nomecliente", nullable = false)
    private String nome;

    @Column(name = "idcliente", nullable = false)
    private Long idcliente;

    @Id
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

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<OSModel> ordensServico;
}
