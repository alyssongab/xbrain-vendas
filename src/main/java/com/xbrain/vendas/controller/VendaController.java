package com.xbrain.vendas.controller;

import com.xbrain.vendas.domain.Venda;
import com.xbrain.vendas.domain.VendaRequestDto;
import com.xbrain.vendas.services.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<Venda> createSale(@RequestBody VendaRequestDto dto) {
        Venda venda = this.vendaService.addVenda(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }
}
