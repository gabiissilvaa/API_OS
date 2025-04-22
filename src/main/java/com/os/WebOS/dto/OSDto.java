package com.os.WebOS.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OSDto {
    private Long idOs;
    private Long idcliente;
    private String nome;
    private String cpfCnpj;
    private String problemaRelatado;
    private String tecnico;
    private String garantia;
    private String equipamento;
    private String marca;
    private String modelo;
    private String situacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date dataEntrada;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date dataUltSituacao;

    public OSDto(Long idOs, Long idcliente, String nome, String cpfCnpj, String problemaRelatado, String tecnico, String garantia, String equipamento, String marca, String modelo, String situacao, Date dataEntrada, Date dataUltSituacao) {
        this.idOs = idOs;
        this.idcliente = idcliente;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.problemaRelatado = problemaRelatado;
        this.tecnico = tecnico;
        this.garantia = garantia;
        this.equipamento = equipamento;
        this.marca = marca;
        this.modelo = modelo;
        this.situacao = situacao;
        this.dataEntrada = dataEntrada;
        this.dataUltSituacao = dataUltSituacao;
    }
}
