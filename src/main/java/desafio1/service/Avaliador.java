package desafio1.service;

import desafio1.model.Lance;
import desafio1.model.Leilao;

public class Avaliador {


    // Desafio 1
    // criar um método que calcule o maior lance de um leilão
    // Desafio 2
    // criar um método que calcule o menor lance de um leilão
    // DEsafio 3
    // criar um método que calcula a media dos lances

    public Lance maiorLance(Leilao leilao) {

        Lance maiorLance = null;
        double maiorValor = 0;
        for (Lance lance: leilao.getLances()) {
            if (lance.getValor() > maiorValor) {
                maiorValor = lance.getValor();
                maiorLance = lance;
            }

        }


        return maiorLance;
    }
}
