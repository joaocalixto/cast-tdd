package br.com.cast.tdd.desafio1.dao;

import br.com.cast.tdd.desafio1.model.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long> {
}
