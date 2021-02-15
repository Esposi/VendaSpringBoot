package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "Vendedor")
public class Vendedor {
    @Id
    @Column(name = "idVendedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomeVendedor", nullable = false)
    private String nome;

    public Vendedor(Long id,String nome){
        super();
        this.id = id;
        this.nome= nome;
    }

    public Vendedor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    


}
