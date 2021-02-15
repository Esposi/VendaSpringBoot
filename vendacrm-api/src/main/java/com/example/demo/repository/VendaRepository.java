package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
	
  @Query(value = "SELECT NOME_VENDEDOR, COUNT(VENDEDOR_VENDA),CAST(COUNT(VENDEDOR_VENDA)AS FLOAT)/DATEDIFF(day,:dataInicial,:dataFinal) FROM VENDA, VENDEDOR WHERE DATA_VENDA BETWEEN :dataInicial AND :dataFinal AND ID_VENDEDOR = VENDEDOR_VENDA GROUP BY ID_VENDEDOR", nativeQuery = true)
   List<Object[]> byParams(@PathVariable(value = "dataInicial") Date dataInicial, @PathVariable(value = "dataFinal") Date dataFinal);
}