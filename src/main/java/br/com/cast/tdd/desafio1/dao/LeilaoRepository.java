package br.com.cast.tdd.desafio1.dao;

import br.com.cast.tdd.desafio1.model.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long> {


    List<Leilao> findLeilaoByProdutoContains(@Param("produto") String produto);

    List<Leilao> findByCreateDate(@Param("createDate") Date createDate);
}
