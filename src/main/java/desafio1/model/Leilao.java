package desafio1.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;

@Getter
@Setter
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

        if ( ultimoLance == null ||
                (lance.getValor() > ultimoLance.getValor() &&
                        !lance.getUsuario().equals(ultimoLance.getUsuario()) )) {

            lances.add(lance);
            ultimoLance = lance;
        }
    }


}
