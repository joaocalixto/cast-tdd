package desafio1.model;

import desafio1.excecao.LeilaoSemLancesException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

@Getter
@Setter
@Log
public class Leilao {

    private String produto;
    private HashSet<Lance> lances = new HashSet<Lance>();
    Lance ultimoLance = null;


    public Leilao(String produto){
        this.produto = produto;
    }

    // nao pode haver lances repetidos
    // nao pode haver lances menores ou igual do que o ultimo lance
    // um usuario nao pode dar dois lances seguidos
    public void propoe(Lance lance){

        log.info("logando alguma coisa ... ");

        if ( ultimoLance == null ||
                (lance.getValor() > ultimoLance.getValor() &&
                        !lance.getUsuario().equals(ultimoLance.getUsuario()) )) {

            lances.add(lance);
            ultimoLance = lance;
        }
    }

    public void dobrarUltimoLance() throws LeilaoSemLancesException {

        if(lances.isEmpty()){
            throw new LeilaoSemLancesException("Lista de leilao sem elementos");
        }

        lances.remove(ultimoLance);
        ultimoLance.setValor(2 * ultimoLance.getValor());
        lances.add(ultimoLance);

    }


}
