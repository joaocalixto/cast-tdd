package br.com.cast.tdd.desafio1.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@NoArgsConstructor
public class Lance {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Transient
    private Usuario usuario;
    private Double valor;

    public Lance(Usuario usuario, Double valor){
        this.usuario = usuario;
        this.valor = valor;
    }
}
