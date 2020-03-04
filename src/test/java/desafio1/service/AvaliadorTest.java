package desafio1.service;

import desafio1.model.Lance;
import desafio1.model.Leilao;
import desafio1.model.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

public class AvaliadorTest {

    // BDD GIVEN - WHEN - THEN

    Avaliador avaliador = new Avaliador();
    Leilao leilao = new Leilao("Playstation 4");

    @Test
    public void deveRetornarMaiorLanceQuandoUmLeilaoComLancesValidosPassado() {

        // given
        // dado dois usarios com nome de joao e maria
        // e joao deu um lance de 22 reais e maria deu um lance de 56 reais
        Usuario usuario = new Usuario("Joao");
        Lance lance = new Lance(usuario, 22d);
        leilao.propoe(lance);
        Usuario usuario2 = new Usuario("Maria");
        Lance lance2 = new Lance(usuario2, 56d);
        leilao.propoe(lance2);

        // quando o avaliador calcula o maior lance
        Lance lanceRecebido = avaliador.maiorLance(leilao);
        Lance lanceEsperado = new Lance(usuario2, lance2.getValor());

        // then - o maior lance deve ser 56 reais
        assertEquals(lanceEsperado.getValor(), lanceRecebido.getValor());


    }

    @Test
    public void deveRetornarAMediaDosValoresDosLancesQuandoCalcularMediaLancesChamado() {
        //given
        Usuario usuario = new Usuario("Joao");
        Lance lance = new Lance(usuario, 20d);
        leilao.propoe(lance);
        Usuario usuario2 = new Usuario("Maria");
        Lance lance2 = new Lance(usuario2, 30d);
        leilao.propoe(lance2);
        Lance lance3 = new Lance(usuario, 40d);
        leilao.propoe(lance3);

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