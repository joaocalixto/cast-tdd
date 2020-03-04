package desafio1.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class LeilaoTest {

    @Test
    public void naoDeveAdicionarLancesIguaisNoLeilao() {
        // given
        //  lances repetido
        Leilao leilao = new Leilao("Pizza");
        Usuario usuario = new Usuario("Joao");
        Lance lance = new Lance(usuario, 22d);

        // when
        leilao.propoe(lance);
        leilao.propoe(lance);
        leilao.propoe(lance);
        leilao.propoe(lance);
        leilao.propoe(lance);

        // then
        Assert.assertEquals(1, leilao.getLances().size());

    }

    @Test
    public void deveAdicionarLancesSomenteDiferentesNoLeilao() {
        // given
        //  lances repetido
        Leilao leilao = new Leilao("Pizza");
        Usuario usuario = new Usuario("Joao");
        Lance lance = new Lance(usuario, 22d);


        Usuario usuario1 = new Usuario("Joao da silva");
        Lance lance1 = new Lance(usuario1, 23d);

        // when
        leilao.propoe(lance);
        leilao.propoe(lance1);


        // then
        HashSet<Lance> lancesEsperados = new HashSet<Lance>();
        lancesEsperados.add(lance);
        lancesEsperados.add(lance1);

        Assert.assertEquals(2, leilao.getLances().size());
//        Assert.assertEquals(lancesEsperados, leilao.getLances());


    }
}