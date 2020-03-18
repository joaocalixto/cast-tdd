package br.com.cast.tdd.desafio1.service;

import br.com.cast.tdd.desafio1.CriadorDeLeilao;
import br.com.cast.tdd.desafio1.dao.LeilaoRepository;
import br.com.cast.tdd.desafio1.model.Lance;
import br.com.cast.tdd.desafio1.model.Leilao;
import br.com.cast.tdd.desafio1.model.Usuario;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class LeilaoServiceImplTest {

    @InjectMocks
    private LeilaoServiceImpl leilaoService;

    @Mock
    private LeilaoRepository leilaoRepository;

    Usuario usuarioJoao = null;
    Usuario usuarioMaria = null;

    Lance lanceJoao22 = null;
    Lance lanceMaria23 = null;

    @Before
    public void initTestes () {
        // Test Data Builders

        usuarioJoao  = new Usuario(0l,"Joao");
        usuarioMaria = new Usuario(1l, "Maria");

        lanceJoao22  = new Lance(0l,usuarioJoao, 22d);
        lanceMaria23 = new Lance(1l,usuarioMaria, 23d);
    }

    @Test
    public void encerrarLeiloesComMaisDeUmMes() {

        // given
        // input com leiloes com mais de um mes
        // leiloes com menos de um mes
        // leilao com exatamente Um mes de diferenca

        Leilao leilaoAntesUmMes =  new CriadorDeLeilao()
                .para("Playstation 4")
                .lance(usuarioJoao, 20d)
                .createDate(new Date("01/01/2020"))
                .constroi();

        Leilao leilaoAntesUmMes2 =  new CriadorDeLeilao()
                .para("Playstation 5")
                .lance(usuarioJoao, 20d)
                .createDate(new Date("03/04/2020"))
                .constroi();

        Leilao leilaoEsperado =  new CriadorDeLeilao()
                .para("Playstation 4")
                .lance(usuarioJoao, 20d)
                .createDate(new Date("01/01/2020"))
                .encerrado(true)
                .constroi();


        // verificar se todos os leiloes (qtd) foram encerrados corretamente

        ArrayList<Leilao> leiloesMocks = new ArrayList<>();

        leiloesMocks.add(leilaoAntesUmMes);
        leiloesMocks.add(leilaoAntesUmMes2);

        when(leilaoRepository.findAll()).thenReturn(leiloesMocks);

        List<Leilao> leilaosRecebido = leilaoService.encerrarLeiloesComMaisDeUmMes();
        List<Leilao> leilaosEsperado = new ArrayList<Leilao>();
        leilaosEsperado.add(leilaoEsperado);

        Mockito.verify(leilaoRepository, times(1)).findAll();

        assertThat(leilaosEsperado, containsInAnyOrder(leilaosRecebido.toArray()));

    }

    @Test
    public void encerrarLeiloesComMenosDeUmMes() {

        // given
        // input com leiloes com mais de um mes
        // leiloes com menos de um mes
        // leilao com exatamente Um mes de diferenca

        Leilao leilaoAntesUmMes =  new CriadorDeLeilao()
                .para("Playstation 4")
                .lance(usuarioJoao, 20d)
                .createDate(new Date("11/03/2020"))
                .constroi();

        Leilao leilaoEsperado =  new CriadorDeLeilao()
                .para("Playstation 4")
                .lance(usuarioJoao, 20d)
                .createDate(new Date("01/03/2020"))
                .encerrado(true)
                .constroi();


        // verificar se todos os leiloes (qtd) foram encerrados corretamente

        ArrayList<Leilao> leiloesMocks = new ArrayList<>();

        leiloesMocks.add(leilaoAntesUmMes);

        when(leilaoRepository.findAll()).thenReturn(leiloesMocks);

        List<Leilao> leilaosRecebido = leilaoService.encerrarLeiloesComMaisDeUmMes();
        List<Leilao> leilaosEsperado = new ArrayList<Leilao>();

        Mockito.verify(leilaoRepository, times(1)).findAll();

        assertThat(leilaosEsperado, containsInAnyOrder(leilaosRecebido.toArray()));

    }

    @Test
    public void encerrarLeiloesComExatamenteUmMes() {

        // given
        // input com leiloes com mais de um mes
        // leiloes com menos de um mes
        // leilao com exatamente Um mes de diferenca

        Instant instant = Instant.now();
        Instant menosTritaDias = instant.minus(Duration.ofDays(30));

        Leilao leilaoAntesUmMes =  new CriadorDeLeilao()
                .para("Playstation 4")
                .lance(usuarioJoao, 20d)
                .createDate(Date.from(menosTritaDias))
                .constroi();

        Leilao leilaoEsperado =  new CriadorDeLeilao()
                .para("Playstation 4")
                .lance(usuarioJoao, 20d)
                .createDate(Date.from(menosTritaDias))
                .encerrado(true)
                .constroi();



        // verificar se todos os leiloes (qtd) foram encerrados corretamente

        ArrayList<Leilao> leiloesMocks = new ArrayList<>();

        leiloesMocks.add(leilaoAntesUmMes);

        when(leilaoRepository.findAll()).thenReturn(leiloesMocks);

        List<Leilao> leilaosRecebido = leilaoService.encerrarLeiloesComMaisDeUmMes();
        List<Leilao> leilaosEsperado = new ArrayList<Leilao>();
        leilaosEsperado.add(leilaoEsperado);

        Mockito.verify(leilaoRepository, times(1)).findAll();

        assertThat(leilaosEsperado, containsInAnyOrder(leilaosRecebido.toArray()));

    }
}