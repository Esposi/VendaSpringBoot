package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Venda;
import com.example.demo.model.Vendedor;
import com.example.demo.repository.VendaRepository;
import com.example.demo.repository.VendedorRepository;
import com.example.demo.service.VendaService;
import com.example.demo.service.VendedorService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VendacrmApiApplicationTests {

	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private VendedorService vendedorService;
	
	@MockBean 
	private VendaRepository vendaRepository;
	
	@MockBean
	private VendedorRepository vendedorRepository;	
	
	//teste listagem de vendedores
	@Test
	public void listarVendedoresTest(){ 
		when(vendedorRepository.findAll()).thenReturn(Stream.of(new Vendedor(1L,"Victor"),new Vendedor(2L,"Marcio"),new Vendedor(3L,"Rebeca")).collect(Collectors.toList()));
		assertEquals(3,vendedorService.findAll().size());	
	}
	
	//teste cadastro de vendedores
	@Test
	public void cadastrarVendedorTest(){
		Vendedor vendedor = new Vendedor(1L,"Victor");
		when(vendedorRepository.save(vendedor)).thenReturn(vendedor);
		assertEquals(vendedor,vendedorService.save(vendedor));
	}	
	
	//teste cadastro de vendas
	@Test
	public void cadastrarVendaTest(){
		Venda venda = new Venda(1L,new java.sql.Date(2021,2,1),20.50f, new Vendedor(1L,"Victor"));
		when(vendaRepository.save(venda)).thenReturn(venda);
		assertEquals(venda,vendaService.save(venda));
	}

}
