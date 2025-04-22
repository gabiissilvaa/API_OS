package com.os.WebOS.controller;

import com.os.WebOS.dto.OSDto;
import com.os.WebOS.service.OSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/os")
@CrossOrigin(origins = "*")
public class OSController {
    @Autowired
    private OSService os;

    @GetMapping("/{clienteId}")
    public List<OSDto> listarOSPorCliente(@PathVariable Long clienteId) {
        return os.listarPorCliente(clienteId);
    }
}
