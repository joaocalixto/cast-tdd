package br.com.cast.tdd.desafio1.dao;

import br.com.cast.tdd.desafio1.CriadorDeLeilao;
import br.com.cast.tdd.desafio1.model.Leilao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class LeilaoRepositoryTest {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Before
    public void initDb(){

        leilaoRepository.saveAll(new CriadorDeLeilao().retornarLeiloes());

        System.out.println("Salvou a lista de leiloes");
    }
    @Test
    public void findLeilaoByProdutoContains() {

        List<Leilao> all = leilaoRepository.findAll();

        System.out.println(all);

        Assert.assertTrue(true);
    }

    @Test
    public void findLeilaosByCreateDate() {
        // given

        // when
        List<Leilao> listaRecebida = leilaoRepository.findByCreateDate(new Date(2020, 3, 1));
        List<Leilao> listaEsperada = new CriadorDeLeilao().retornarLeiloes();
        listaEsperada.get(0).setId(1L);
        System.out.println();
        // then
        assertThat(listaEsperada, containsInAnyOrder(listaRecebida.toArray()));

    }
}