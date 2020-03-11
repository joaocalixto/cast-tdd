package br.com.cast.tdd.desafio1.model;

import br.com.cast.tdd.desafio1.excecao.LeilaoSemLancesException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;

@Getter
@Setter
@Log
@Entity
@NoArgsConstructor
public class Leilao {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String produto;
    private Boolean isEncerrado;
    private HashSet<Lance> lances = new HashSet<Lance>();

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "modify_date")
    private Date modifyDate;

    @Transient
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
