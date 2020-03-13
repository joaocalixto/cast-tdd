package br.com.cast.tdd.desafio1.service;

import br.com.cast.tdd.desafio1.model.Leilao;

import java.util.List;

public interface LeilaoService {

    List<Leilao> encerrarLeiloesComMaisDeUmMes();

    List<Leilao> findAll();

}
