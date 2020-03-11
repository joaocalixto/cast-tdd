package br.com.cast.tdd.desafio1.service;

import br.com.cast.tdd.desafio1.dao.LeilaoRepository;
import br.com.cast.tdd.desafio1.model.Leilao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeilaoServiceImpl implements LeilaoService{

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Override
    public void encerrarLeiloesComMaisDeUmMes() {


        Leilao leilao = new Leilao("Produto 1");

        leilaoRepository.save(leilao);

        List<Leilao> all = leilaoRepository.findAll();

        System.out.println(all);

    }
}
