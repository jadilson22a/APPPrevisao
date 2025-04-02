package com.github.jadilson22a.APIPrevisao.repository;

import com.github.jadilson22a.APIPrevisao.model.Previsao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrevisaoRepository extends JpaRepository <Previsao, String> {
    List<Previsao> findByPedido(Integer pedido);
}
