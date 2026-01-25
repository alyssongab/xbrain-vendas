package com.xbrain.vendas.services;

import com.xbrain.vendas.domain.Venda;
import com.xbrain.vendas.domain.VendaRequestDto;
import com.xbrain.vendas.repositories.VendaRepository;
import org.springframework.stereotype.Service;

@Service
public class VendaService {
    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Venda addVenda(VendaRequestDto dto) {
        if(
            dto.dataVenda() == null ||
            dto.valorVenda() == null ||
            dto.idVendedor() <= 0 ||
            dto.nomeVendedor() == null ||
            dto.nomeVendedor().isBlank()
        ) {
            throw new IllegalArgumentException("Dados obrigatórios inválidos");
        }

        Venda venda = new Venda();
        venda.setDataVenda(dto.dataVenda());
        venda.setValorVenda(dto.valorVenda());
        venda.setIdVendedor(dto.idVendedor());
        venda.setNomeVendedor(dto.nomeVendedor());

        return vendaRepository.save(venda);
    }
}
