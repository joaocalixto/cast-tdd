package br.com.cast.tdd.desafio1.service;

import br.com.cast.tdd.desafio1.controller.LeilaoController;
import br.com.cast.tdd.desafio1.model.Leilao;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

public interface LeilaoService {

    List<Leilao> encerrarLeiloesComMaisDeUmMes();

    List<Leilao> findAll();
}
