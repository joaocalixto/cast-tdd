package desafio1.model;

import desafio1.CriadorDeLeilao;
import desafio1.excecao.LeilaoSemLancesException;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LeilaoTest {

    Leilao leilaoPizza = null;

    Usuario usuarioJoao = null;
    Usuario usuarioMaria = null;

    Lance lanceJoao22 = null;
    Lance lanceMaria23 = null;

    @Rule
    public ExpectedException exception = ExpectedException.none();

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
        Leilao leilaoPizza =  new CriadorDeLeilao()
                .para("Pizza")
                .lance(usuarioJoao, 22d)
                .lance(usuarioMaria, 23d)
                .constroi();

        HashSet<Lance> lancesEsperados = new HashSet<Lance>();
        lancesEsperados.add(lanceJoao22);
        lancesEsperados.add(lanceMaria23);

        assertEquals(2, leilaoPizza.getLances().size());
//        Assert.assertEquals(lancesEsperados, leilao.getLances());
    }

    @Test
    public void deveDobrarOUltimoLanceQuandoOMetodoDobrarUltimoLanceChamado() throws LeilaoSemLancesException {

        Leilao leilaoPizza =  new CriadorDeLeilao()
                .para("Pizza")
                .lance(usuarioJoao, 22d)
                .constroi();

        leilaoPizza.dobrarUltimoLance();

        HashSet<Lance> lancesEsperados = new HashSet<Lance>();

        lancesEsperados.add(new Lance(usuarioJoao, 44d));

        assertThat(leilaoPizza.getLances(), equalTo(lancesEsperados));
    }


    @Test
    public void deveLancarUmaExcecaoQuandoNaoHouveLance() throws LeilaoSemLancesException {
        exception.expect(LeilaoSemLancesException.class);
        exception.expectMessage("Lista de leilao sem elementos");
        Leilao leilaoVazio = new Leilao("MacBook de Joao");

        leilaoVazio.dobrarUltimoLance();
    }
}