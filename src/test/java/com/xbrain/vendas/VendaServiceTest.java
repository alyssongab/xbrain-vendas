package com.xbrain.vendas;

import com.xbrain.vendas.domain.Venda;
import com.xbrain.vendas.dto.VendaDto;
import com.xbrain.vendas.dto.VendedorDto;
import com.xbrain.vendas.repositories.VendaRepository;
import com.xbrain.vendas.services.VendaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VendaServiceTest {

	@Mock
	private VendaRepository vendaRepository;

	@InjectMocks
	private VendaService vendaService;

	@Test
	@DisplayName("Deve criar uma venda com sucesso")
	void addVenda() {

		VendaDto.Request request = new VendaDto.Request(
				LocalDate.of(2026, 1, 5),
				BigDecimal.valueOf(120),
				1,
				"Alysson"
		);

		Venda vendaSalva = new Venda();
		vendaSalva.setIdVenda(1);
		vendaSalva.setDataVenda(LocalDate.of(2026, 1, 5));
		vendaSalva.setValorVenda(BigDecimal.valueOf(120));
		vendaSalva.setIdVendedor(1);
		vendaSalva.setNomeVendedor("Alysson");

		when(vendaRepository.save(any(Venda.class))).thenReturn(vendaSalva);

		// Act
		VendaDto.Response response = vendaService.addVenda(request);

		// Assert
		assertNotNull(response);
		assertEquals(1, response.id());
		assertEquals("Alysson", response.nomeVendedor());
		assertEquals(BigDecimal.valueOf(120), response.valor());
	}

	@Test
	@DisplayName("Deve retornar lista de vendedores com estatisticas no periodo")
	void getVendedores() {

		LocalDate dataInicio = LocalDate.of(2026, 1, 1);
		LocalDate dataFim = LocalDate.of(2026, 1, 10);


		Venda venda1 = new Venda();
		venda1.setIdVenda(1);
		venda1.setNomeVendedor("Alysson");
		venda1.setValorVenda(BigDecimal.valueOf(100));
		venda1.setDataVenda(LocalDate.of(2026, 1, 5));

		Venda venda2 = new Venda();
		venda2.setIdVenda(2);
		venda2.setNomeVendedor("Alysson");
		venda2.setValorVenda(BigDecimal.valueOf(200));
		venda2.setDataVenda(LocalDate.of(2026, 1, 8));

		Venda venda3 = new Venda();
		venda3.setIdVenda(3);
		venda3.setNomeVendedor("Gabriel");
		venda3.setValorVenda(BigDecimal.valueOf(150));
		venda3.setDataVenda(LocalDate.of(2026, 1, 7));

		List<Venda> vendas = List.of(venda1, venda2, venda3);


		when(vendaRepository.findByDataVendaBetween(dataInicio, dataFim))
				.thenReturn(vendas);


		List<VendedorDto> resultado = vendaService.getVendedores(dataInicio, dataFim);


		assertNotNull(resultado);
		assertEquals(2, resultado.size());


		VendedorDto alysson = resultado.stream()
				.filter(v -> v.nome().equals("Alysson"))
				.findFirst()
				.orElse(null);

		assertNotNull(alysson);
		assertEquals("Alysson", alysson.nome());
		assertEquals(BigDecimal.valueOf(300), alysson.totalVendas());
		assertEquals(new BigDecimal("30.00"), alysson.mediaVendasDiarias());


		VendedorDto gabriel = resultado.stream()
				.filter(v -> v.nome().equals("Gabriel"))
				.findFirst()
				.orElse(null);

		assertNotNull(gabriel);
		assertEquals("Gabriel", gabriel.nome());
		assertEquals(BigDecimal.valueOf(150), gabriel.totalVendas());
		assertEquals(new BigDecimal("15.00"), gabriel.mediaVendasDiarias());
	}
}