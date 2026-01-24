package com.xbrain.vendas.repositories;

import com.xbrain.vendas.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
