package desafio1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Leilao {

    private String produto;
    private List<Lance> lances;


    public void propoe(Lance lance){
        if(lances == null){
            lances = new ArrayList<Lance>();
        }
        lances.add(lance);
    }


}
