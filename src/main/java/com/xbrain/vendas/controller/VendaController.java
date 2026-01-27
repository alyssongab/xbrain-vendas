package com.xbrain.vendas.controller;

import com.xbrain.vendas.dto.VendaDto;
import com.xbrain.vendas.dto.VendedorDto;
import com.xbrain.vendas.services.VendaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

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

    @GetMapping("/vendedores")
    public ResponseEntity<List<VendedorDto>> getVendedores(@RequestParam("data_inicio") LocalDate dataInicio,
                                                           @RequestParam("data_fim") LocalDate dataFim) {
        List<VendedorDto> vendedores = this.vendaService.getVendedores(dataInicio, dataFim);
        return ResponseEntity.ok(vendedores);
    }
}
