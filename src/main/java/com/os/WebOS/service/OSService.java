package com.os.WebOS.service;

import com.os.WebOS.dto.OSDto;
import com.os.WebOS.repository.OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OSService {
    @Autowired
    private OSRepository osRepository;

    public List<OSDto> listarPorCliente(Long clienteId) {
        return osRepository.findByIdcliente(clienteId)
                .stream()
                .map(os -> new OSDto(
                        os.getIdOs(),
                        os.getIdcliente(),
                        os.getNome(),
                        os.getCpfCnpj(),
                        os.getProblemaRelatado(),
                        os.getTecnico(),
                        os.getGarantia(),
                        os.getEquipamento(),
                        os.getMarca(),
                        os.getModelo(),
                        os.getSituacao(),
                        os.getDataEntrada(),
                        os.getDataUltSituacao()))
                .toList();
    }
}
