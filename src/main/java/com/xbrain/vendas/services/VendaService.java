package com.xbrain.vendas.services;

import com.xbrain.vendas.domain.Venda;
import com.xbrain.vendas.dto.VendaDto;
import com.xbrain.vendas.dto.VendedorDto;
import com.xbrain.vendas.repositories.VendaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        Venda vendaSalva = this.vendaRepository.save(venda);
        return convertToResponse(vendaSalva);
    }

    // lista de vendedores com as estatisticas (total $ de vendas e media diaria de vendas) no periodo
    public List<VendedorDto> getVendedores(LocalDate dataInicio, LocalDate dataFim) {
        var vendasNoPeriodo = this.vendaRepository.findByDataVendaBetween(dataInicio, dataFim);

        long diasNoPeriodo = ChronoUnit.DAYS.between(dataInicio, dataFim) + 1;

        Map<String, List<Venda>> vendasPorVendedor =  vendasNoPeriodo.stream()
                .collect(Collectors.groupingBy(Venda::getNomeVendedor));

        return vendasPorVendedor.entrySet().stream()
            .map(entry -> {
                String nomeVendedor = entry.getKey();
                List<Venda> vendasVendedor = entry.getValue();

                BigDecimal totalVendas = vendasVendedor.stream()
                        .map(Venda::getValorVenda)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                BigDecimal mediaDiariaVendas = totalVendas
                        .divide(BigDecimal.valueOf(diasNoPeriodo), 2, RoundingMode.HALF_UP);

                return new VendedorDto(
                        nomeVendedor,
                        totalVendas,
                        mediaDiariaVendas
                );
            })
            .collect(Collectors.toList());

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
