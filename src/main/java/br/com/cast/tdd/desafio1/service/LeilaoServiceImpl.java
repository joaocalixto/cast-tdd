package br.com.cast.tdd.desafio1.service;

import br.com.cast.tdd.desafio1.dao.LeilaoRepository;
import br.com.cast.tdd.desafio1.model.Leilao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

//        List<Leilao> leiloesEncerrados = new ArrayList<>();
//        for (Leilao leilao: all) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.add(Calendar.DAY_OF_MONTH, -30);
//
//            if (leilao.getCreateDate().compareTo(calendar.getTime()) < 0) {
//                leilao.setIsEncerrado(true);
//                leiloesEncerrados.add(leilao);
//            }
//        } // filtar 30 dias - , mudar set is encrerro , retornar no collect to lin

        List<Leilao> listaEncerrados = all.stream()
                .filter(LeilaoServiceImpl::isLessThan30Days)
                .peek(leilao -> leilao.setIsEncerrado(true))
                .collect(Collectors.toList());

//        all.stream()
//                .filter(leilao -> isLessThan30Days(leilao.getCreateDate()))
//                .forEach(leilao -> leilao.setIsEncerrado(true));


        return all;

    }

    public static boolean isLessThan30Days(Leilao leilao){

        Date createDate = leilao.getCreateDate();
        Date date = createDate;

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -30);

        LocalDate createDateLocalDate = convertToLocalDateViaMilisecond(leilao.getCreateDate());
        Period between = Period.between(LocalDate.now().minusDays(30), createDateLocalDate);

        return between.getDays() < 0;
    }

    public static LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    @Override
    public List<Leilao> findAll() {
        return leilaoRepository.findAll();
    }
}
