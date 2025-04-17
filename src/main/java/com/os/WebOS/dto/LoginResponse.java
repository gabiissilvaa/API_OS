package com.os.WebOS.dto;

import com.os.WebOS.model.OSModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class LoginResponse {
    private Long idOs;
    private String equipamento;
    private Date dataEntrada;
    private String garantia;
    private String situacao;
    private String nome;
    private List<OSModel> ordensServico;

    public LoginResponse(Long idOs, String equipamento, String garantia, String situacao, Date dataEntrada, String nome, List<OSDto> ordensServico) {
        this.idOs = idOs;
        this.equipamento = equipamento;
        this.dataEntrada = dataEntrada;
        this.garantia = garantia;
        this.situacao = situacao;
        this.nome = nome;
        this.ordensServico = new LinkedList<>();
    }
}
