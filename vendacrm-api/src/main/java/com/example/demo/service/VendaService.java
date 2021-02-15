package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Venda;
import com.example.demo.repository.VendaRepository;

@Service
public class VendaService {
	
	 @Autowired
	    private VendaRepository vendaRepository;

	    public Venda save(Venda venda){
	        return (vendaRepository.save(venda));
	    }
	    
	    public List<Object[]> byParams(Date dataInicial, Date dataFinal){

	        return (vendaRepository.byParams(dataInicial,dataFinal));

	    }
}
