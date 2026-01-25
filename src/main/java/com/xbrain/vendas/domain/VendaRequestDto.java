package com.xbrain.vendas.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VendaRequestDto(
        LocalDate dataVenda,
        BigDecimal valorVenda,
        int idVendedor,
        String nomeVendedor
) {
}
