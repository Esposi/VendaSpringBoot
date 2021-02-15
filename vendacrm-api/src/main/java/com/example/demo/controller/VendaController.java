package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.VendaService;
import com.example.demo.model.Venda;

@RestController
@RequestMapping("/venda")
public class VendaController {
	
	    @Autowired
	    private VendaService vendaService;

	    @PostMapping
	    public Venda save(@RequestBody Venda venda){
	        return vendaService.save(venda);
	    }
	    
	    @GetMapping
	    public List<Object[]> byParams(@RequestParam String dataInicial, @RequestParam  String dataFinal) throws ParseException {
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	        Date dataInicialFormatada = formatter.parse(dataInicial);
	        Date dataFinalFormatada = formatter.parse(dataFinal);

	        return (vendaService.byParams(dataInicialFormatada,dataFinalFormatada));

	    }

}
