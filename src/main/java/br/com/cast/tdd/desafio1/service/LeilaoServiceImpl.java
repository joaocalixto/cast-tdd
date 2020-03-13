package br.com.cast.tdd.desafio1.service;

import br.com.cast.tdd.desafio1.dao.LeilaoRepository;
import br.com.cast.tdd.desafio1.model.Leilao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LeilaoServiceImpl implements LeilaoService{

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Override
    public List<Leilao> encerrarLeiloesComMaisDeUmMes() {

//
//        Leilao leilao = new Leilao("Produto 1");
//
//        leilaoRepository.save(leilao);
//
        List<Leilao> all = leilaoRepository.findAll();

        List<Leilao> leiloesEncerrados = new ArrayList<>();
        for (Leilao leilao: all) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -30);

            if (leilao.getCreateDate().compareTo(calendar.getTime()) < 0) {
                leilao.setIsEncerrado(true);
                leiloesEncerrados.add(leilao);
            }
        }

        return leiloesEncerrados;

    }

    @Override
    public List<Leilao> findAll() {
        return leilaoRepository.findAll();
    }
}
