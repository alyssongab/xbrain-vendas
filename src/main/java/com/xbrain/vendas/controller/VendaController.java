package com.xbrain.vendas.controller;

import com.xbrain.vendas.domain.Venda;
import com.xbrain.vendas.dto.VendaDto;
import com.xbrain.vendas.services.VendaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<VendaDto.Response> createSale(@RequestBody @Valid VendaDto.Request request) {
        VendaDto.Response vendaResponse = this.vendaService.addVenda(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaResponse);
    }
}
