package com.xbrain.vendas.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Integer idVenda;

    @NotNull
    @Column(name = "data_venda")
    private LocalDate dataVenda;

    @NotNull
    @Column(name = "valor_venda")
    private BigDecimal valorVenda;

    @Column(name = "id_vendedor")
    private int idVendedor;

    @NotBlank
    @Column(name = "nome_vendedor")
    private String nomeVendedor;

    public Venda() {

    }

    public Venda(int idVenda, LocalDate dataVenda, BigDecimal valorVenda, int idVendedor, String nomeVendedor) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
        this.idVendedor = idVendedor;
        this.nomeVendedor = nomeVendedor;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }
}
