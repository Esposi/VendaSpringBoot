package com.example.demo.service;

import com.example.demo.model.Vendedor;
import com.example.demo.repository.VendedorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public Vendedor save(Vendedor vendedor){
        return (vendedorRepository.save(vendedor));
    }

    public List<Vendedor> findAll(){
        return vendedorRepository.findAll();
    }
    
}
