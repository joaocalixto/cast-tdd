package br.com.cast.tdd.desafio1;

import br.com.cast.tdd.desafio1.model.Lance;
import br.com.cast.tdd.desafio1.model.Leilao;
import br.com.cast.tdd.desafio1.model.Usuario;

public class CriadorDeLeilao {

    private Leilao leilao;

    public CriadorDeLeilao para(String nomeItem){

        this.leilao = new Leilao(nomeItem);
        return this;
    }

    public CriadorDeLeilao lance(Usuario usuario, Double valor){
        this.leilao.propoe(new Lance(usuario, valor));
        return this;
    }

    public Leilao constroi(){
        return leilao;
    }
}
