package com.xbrain.vendas.services;

import com.xbrain.vendas.domain.Venda;
import com.xbrain.vendas.dto.VendaDto;
import com.xbrain.vendas.repositories.VendaRepository;
import org.springframework.stereotype.Service;

@Service
public class VendaService {
    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public VendaDto.Response addVenda(VendaDto.Request request) {
        Venda venda = new Venda();
        venda.setDataVenda(request.dataVenda());
        venda.setValorVenda(request.valor());
        venda.setIdVendedor(request.idVendedor());
        venda.setNomeVendedor(request.nomeVendedor());

        this.vendaRepository.save(venda);
        return convertToResponse(venda);
    }

    private VendaDto.Response convertToResponse(Venda venda) {
        return new VendaDto.Response(
                venda.getIdVenda(),
                venda.getDataVenda(),
                venda.getValorVenda(),
                venda.getIdVendedor(),
                venda.getNomeVendedor()
        );
    }

}
