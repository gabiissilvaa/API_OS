package com.os.WebOS.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OSDto {
    private Long idCliente;
    private String modelo;
    private String problemaRelatado;
    private String tecnico;
    private String garantia;
    private Date dataUltSituacao;

    public OSDto(Long idCliente, String modelo, String problemaRelatado, String tecnico, String garantia, Date dataUltSituacao) {
        this.idCliente = idCliente;
        this.modelo = modelo;
        this.problemaRelatado = problemaRelatado;
        this.tecnico = tecnico;
        this.garantia = garantia;
        this.dataUltSituacao = dataUltSituacao;
    }
}
