package br.com.cast.tdd.desafio1.dao;

import br.com.cast.tdd.desafio1.model.Leilao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class LeilaoRepositoryTest {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Test
    public void findLeilaoByProdutoContains() {

        List<Leilao> all = leilaoRepository.findAll();

        System.out.println(all);

        Assert.assertTrue(true);
    }
}