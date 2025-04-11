package com.os.WebOS.service;

import com.os.WebOS.dto.OSDto;
import com.os.WebOS.repository.OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OSService {
    @Autowired
    private OSRepository osRepository;

    public List<OSDto> listarPorCliente(Long clienteId) {
        return osRepository.findByIdcliente(clienteId)
                .stream()
                .map(os -> new OSDto(
                        os.getId(),
                        os.getModelo(),
                        os.getProblemaRelatado(),
                        os.getTecnico(),
                        os.getGarantia(),
                        os.getDataUltSituacao()))
                .collect(Collectors.toList());
    }
}
