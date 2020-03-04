package desafio1.service;

import desafio1.model.Lance;
import desafio1.model.Leilao;
import desafio1.model.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

public class AvaliadorTest {

    Avaliador avaliador = new Avaliador();
    Leilao leilao = new Leilao();

    @Test
    public void maiorLance() {
        Usuario usuario = new Usuario("teste");
        Lance lance = new Lance(usuario, 22d);
        leilao.propoe(lance);
        Usuario usuario2 = new Usuario("teste2");
        Lance lance2 = new Lance(usuario, 56d);
        leilao.propoe(lance2);

        Lance lanceRecebido = avaliador.maiorLance(leilao);
        Lance lanceEsperado = new Lance(usuario, lance.getValor());

        assertEquals(lanceEsperado.getValor(), lanceRecebido.getValor());


    }
}