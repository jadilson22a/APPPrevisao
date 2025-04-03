package com.github.jadilson22a.APIPrevisao.Service;

import com.github.jadilson22a.APIPrevisao.model.Previsao;
import com.github.jadilson22a.APIPrevisao.repository.PrevisaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrevisaoService {

    private PrevisaoRepository repository;

    public PrevisaoService(PrevisaoRepository repository) {
        this.repository = repository;
    }

    public void inserir(Previsao previsao){
        repository.save(previsao);
    }

    public void excluir(Integer id){
        repository.deleteById(id.toString());
    }

    public void atualizar(Integer id, Previsao previsao){
        previsao.setId(id);
        repository.save(previsao);
    }

    public List<Previsao> buscarPedido(Integer pedido){
        return repository.findByPedido(pedido);
    }

    public List<Previsao> buscarCotacao(Integer cotacao){
        return repository.findByCotacao(cotacao);
    }
}