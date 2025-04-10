package com.os.WebOS.dto;

import com.os.WebOS.model.OSModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class LoginResponse {
    private String nome;
    private String equipamento;
    private String marca;
    private String situacao;
    private Date dataEntrada;
    private List<OSDto> ordensServicos;

    public LoginResponse(String nome, String equipamento, String marca, String situacao, Date dataEntrada, List<OSDto> ordensServicos) {
        this.nome = nome;
        this.equipamento = equipamento;
        this.marca = marca;
        this.situacao = situacao;
        this.dataEntrada = dataEntrada;
        this.ordensServicos = ordensServicos;
    }
}
