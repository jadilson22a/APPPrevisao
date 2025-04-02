package com.github.jadilson22a.APIPrevisao.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name= "previsoes")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPedido() {
        return pedido;
    }

    public void setPedido(Integer pedido) {
        this.pedido = pedido;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDate getPrevisao() {
        return previsao;
    }

    public void setPrevisao(LocalDate previsao) {
        this.previsao = previsao;
    }

    @Override
    public String toString() {
        return "Previsao{" +
                "id=" + id +
                ", pedido=" + pedido +
                ", fornecedor='" + fornecedor + '\'' +
                ", previsao=" + previsao +
                '}';
    }
}
