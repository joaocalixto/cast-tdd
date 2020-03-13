package br.com.cast.tdd.desafio1;

import br.com.cast.tdd.desafio1.model.Lance;
import br.com.cast.tdd.desafio1.model.Leilao;
import br.com.cast.tdd.desafio1.model.Usuario;

import java.util.Date;

public class CriadorDeLeilao {

    private Leilao leilao;

    public CriadorDeLeilao para(String nomeItem){

        this.leilao = new Leilao(nomeItem);
        return this;
    }

    public CriadorDeLeilao lance(Usuario usuario, Double valor){
        this.leilao.propoe(new Lance(0l,usuario, valor));
        return this;
    }

    public CriadorDeLeilao encerrado(boolean isEncerrado){
        this.leilao.setIsEncerrado(isEncerrado);
        return this;
    }

    public CriadorDeLeilao createDate(Date createDate) {
        this.leilao.setCreateDate(createDate);
        return this;
    }

    public Leilao constroi(){
        return leilao;
    }
}
