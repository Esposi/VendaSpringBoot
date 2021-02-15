package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

}
