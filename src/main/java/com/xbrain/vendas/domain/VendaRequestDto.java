package com.xbrain.vendas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VendaRequestDto(
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dataVenda,

        @NotNull
        BigDecimal valorVenda,

        @Positive
        int idVendedor,

        @NotBlank
        String nomeVendedor
) {
}
