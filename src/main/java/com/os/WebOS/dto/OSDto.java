package com.os.WebOS.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OSDto {
    private Long idOS;
    private String modelo;
    private String problemaRelatado;
    private String tecnico;
    private String garantia;
    private Date dataUltSituacao;

    public OSDto(Long idOS, String modelo, String problemaRelatado, String tecnico, String garantia, Date dataUltSituacao) {
        this.idOS = idOS;
        this.modelo = modelo;
        this.problemaRelatado = problemaRelatado;
        this.tecnico = tecnico;
        this.garantia = garantia;
        this.dataUltSituacao = dataUltSituacao;
    }
}
