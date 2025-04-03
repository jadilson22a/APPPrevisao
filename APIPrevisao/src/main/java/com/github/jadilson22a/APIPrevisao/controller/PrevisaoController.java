package com.github.jadilson22a.APIPrevisao.controller;

import com.github.jadilson22a.APIPrevisao.Service.PrevisaoService;
import com.github.jadilson22a.APIPrevisao.model.Previsao;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // Permite requisições do React
@RestController
@RequestMapping("/previsao")
public class PrevisaoController {

    private PrevisaoService Service;

    public PrevisaoController(PrevisaoService service) {
        Service = service;
    }

    @PostMapping
    public void inserir(@RequestBody Previsao previsao){
        this.Service.inserir(previsao);
    }

    @DeleteMapping
    public void excluir(@RequestParam("id") Integer id){
        this.Service.excluir(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") Integer id, @RequestBody Previsao previsao){
        this.Service.atualizar(id, previsao);
    }


    @GetMapping("/pedido")
    public List<Previsao> buscarPedido(@RequestParam("pedido") Integer pedido){
        return this.Service.buscarPedido(pedido);
    }

    @GetMapping("/cotacao")
    public List<Previsao> buscarCotacao(@RequestParam("cotacao") Integer cotacao){
        return this.Service.buscarCotacao(cotacao);
    }
}
