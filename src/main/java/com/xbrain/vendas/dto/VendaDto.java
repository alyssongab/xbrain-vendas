package com.xbrain.vendas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VendaDto{
        public record Request(

                @NotNull(message = "data da venda obrigatoria")
                @JsonFormat(pattern = "yyyy-MM-dd")
                LocalDate dataVenda,

                @NotNull(message = "valor obrigatorio")
                @Positive(message = "valor deve ser positivo")
                BigDecimal valor,

                @NotNull(message = "id do vendedor obrigatorio")
                Integer idVendedor,

                @NotBlank(message = "nome do vendedor obrigatorio")
                String nomeVendedor
        ){
        }

        public record Response(
                Integer id,

                @JsonFormat(pattern = "yyyy-MM-dd")
                LocalDate dataVenda,

                BigDecimal valor,
                Integer idVendedor,
                String nomeVendedor
        ){}
}
