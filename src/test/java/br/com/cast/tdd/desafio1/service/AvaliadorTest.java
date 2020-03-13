package br.com.cast.tdd.desafio1.service;

import br.com.cast.tdd.desafio1.CriadorDeLeilao;
import br.com.cast.tdd.desafio1.model.Lance;
import br.com.cast.tdd.desafio1.model.Leilao;
import br.com.cast.tdd.desafio1.model.Usuario;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AvaliadorTest {

    Leilao leilaoPizza = null;

    Usuario usuarioJoao = null;
    Usuario usuarioMaria = null;

    Lance lanceJoao22 = null;
    Lance lanceMaria23 = null;

    @Before
    public void initTestes () {
        // Test Data Builders

        usuarioJoao  = new Usuario(0l,"Joao");
        usuarioMaria = new Usuario(1l,"Maria");

        lanceJoao22  = new Lance(0l,usuarioJoao, 22d);
        lanceMaria23 = new Lance(1l,usuarioMaria, 23d);
    }

    // BDD GIVEN - WHEN - THEN

    Avaliador avaliador = new Avaliador();
    Leilao leilao = new Leilao("Playstation 4");

    @Test
    public void deveRetornarMaiorLanceQuandoUmLeilaoComLancesValidosPassado() {


        Leilao leilao =  new CriadorDeLeilao()
                .para("Playstation 4")
                .lance(usuarioJoao, 22d)
                .lance(usuarioMaria, 56d)
                .constroi();


        // quando o avaliador calcula o maior lance
        Lance lanceRecebido = avaliador.maiorLance(leilao);
        Lance lanceEsperado = new Lance(0l, usuarioMaria, 56d);

        // then - o maior lance deve ser 56 reais
        assertEquals(lanceEsperado.getValor(), lanceRecebido.getValor());


    }

    @Test
    public void deveRetornarAMediaDosValoresDosLancesQuandoCalcularMediaLancesChamado() {
        //given
        Leilao leilao =  new CriadorDeLeilao()
                .para("Playstation 4")
                .lance(usuarioJoao, 20d)
                .lance(usuarioMaria, 30d)
                .lance(usuarioJoao, 40d)
                .constroi();

        //when
        Double valorMediaRetornado = avaliador.calcularMediaLances(leilao);
        Double valorMediaEsperado = 30d;
        //then
        assertEquals(valorMediaEsperado, valorMediaRetornado);

    }

    @Test
    public void deveRetornarZeroQuandoCalcularMediaLancesChamadoComLeilaoNulo() {
        //given
        Leilao leilaoNulo = null;

        //when
        Double valorMediaRetornado = avaliador.calcularMediaLances(leilaoNulo);
        Double valorMediaEsperado = 0d;
        //then
        assertEquals(valorMediaEsperado, valorMediaRetornado);

    }


}