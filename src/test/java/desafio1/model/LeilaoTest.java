package desafio1.model;

import desafio1.CriadorDeLeilao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class LeilaoTest {

    Leilao leilaoPizza = null;

    Usuario usuarioJoao = null;
    Usuario usuarioMaria = null;

    Lance lanceJoao22 = null;
    Lance lanceMaria23 = null;

    @Before
    public void initTestes () {
        // Test Data Builders

        usuarioJoao  = new Usuario("Joao");
        usuarioMaria = new Usuario("Maria");

        lanceJoao22  = new Lance(usuarioJoao, 22d);
        lanceMaria23 = new Lance(usuarioMaria, 23d);
    }

    @Test
    public void naoDeveAdicionarLancesIguaisNoLeilao() {

        Leilao leilaoPizza =  new CriadorDeLeilao()
                .para("Pizza")
                .lance(usuarioJoao, 22d)
                .lance(usuarioJoao, 22d)
                .lance(usuarioJoao, 22d)
                .lance(usuarioJoao, 22d)
                .lance(usuarioJoao, 22d)
                .constroi();

        assertEquals(1, leilaoPizza.getLances().size());
    }

    @Test
    public void deveAdicionarLancesSomenteDiferentesNoLeilao() {
        leilaoPizza.propoe(lanceJoao22);
        leilaoPizza.propoe(lanceMaria23);

        HashSet<Lance> lancesEsperados = new HashSet<Lance>();
        lancesEsperados.add(lanceJoao22);
        lancesEsperados.add(lanceMaria23);

        assertEquals(2, leilaoPizza.getLances().size());
//        Assert.assertEquals(lancesEsperados, leilao.getLances());
    }
}