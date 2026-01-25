package com.xbrain.vendas.services;

import com.xbrain.vendas.domain.Venda;
import com.xbrain.vendas.domain.VendaRequestDto;
import com.xbrain.vendas.exceptions.GlobalExceptionHandler;
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
            dto.nomeVendedor().isBlank()
        ){
            throw new GlobalExceptionHandler();
        }

        Venda venda = new Venda();
        venda.setDataVenda(dto.dataVenda());
        venda.setValorVenda(dto.valorVenda());
        venda.setIdVendedor(dto.idVendedor());
        venda.setNomeVendedor(dto.nomeVendedor());

        return vendaRepository.save(venda);
    }
}
