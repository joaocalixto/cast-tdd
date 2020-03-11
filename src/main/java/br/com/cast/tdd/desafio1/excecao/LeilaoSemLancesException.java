package br.com.cast.tdd.desafio1.excecao;

public class LeilaoSemLancesException extends Exception {
    public LeilaoSemLancesException(String mensagem) {
        super(mensagem);
    }
}
