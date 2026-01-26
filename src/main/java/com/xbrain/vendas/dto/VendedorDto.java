package com.xbrain.vendas.dto;

import java.math.BigDecimal;

public record VendedorDto(
        String nome,
        BigDecimal totalVendas,
        BigDecimal mediaVendasDiarias
) {
}
