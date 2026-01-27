package com.xbrain.vendas.repositories;

import com.xbrain.vendas.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {
    List<Venda> findByDataVendaBetween(LocalDate start, LocalDate end);

    @Query("SELECT v FROM Venda v WHERE v.idVendedor = :idVendedor AND v.dataVenda BETWEEN :dataInicio AND :dataFim")
    List<Venda> findByVendedorAndPeriodo(
        @Param("idVendedor") Integer idVendedor,
        @Param("dataInicio") LocalDate dataInicio,
        @Param("dataFim") LocalDate dataFim
    );
}
