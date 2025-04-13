package com.github.jadilson22a.APIPrevisao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name= "previsoes")
@Getter
@Setter
public class Previsao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Permite que o Banco de dados gere automaticamente
    @Column(name= "id")
    private Integer id;

    @Column(name= "pedido")
    private Integer pedido;

    @Column(name= "fornecedor")
    private String fornecedor;

    @Column(name= "previsao")
    private LocalDate previsao;

    @Column(name= "cotacao")
    private Integer cotacao;

}
