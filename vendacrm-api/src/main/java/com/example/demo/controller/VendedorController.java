package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.VendedorService;
import com.example.demo.model.Vendedor;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {	
	
	    @Autowired
	    private VendedorService vendedorService;

	    @PostMapping
	    public Vendedor save(@RequestBody Vendedor vendedor){
	        return (vendedorService.save(vendedor));
	    }
	    
	    @GetMapping
	    public List<Vendedor> findAll(){
	        return vendedorService.findAll();
	    }

	
}
