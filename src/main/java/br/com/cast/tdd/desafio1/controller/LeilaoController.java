package br.com.cast.tdd.desafio1.controller;

import br.com.cast.tdd.desafio1.model.Leilao;
import br.com.cast.tdd.desafio1.service.LeilaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LeilaoController {

    @Autowired
    private LeilaoService leilaoService;

    @GetMapping("/leiloes")
    public List<Leilao> getAllLeiloes() {
        return leilaoService.findAll();
    }
}
