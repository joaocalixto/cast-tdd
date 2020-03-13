package br.com.cast.tdd.desafio1.controller;

import br.com.cast.tdd.desafio1.CriadorDeLeilao;
import br.com.cast.tdd.desafio1.model.Leilao;
import br.com.cast.tdd.desafio1.service.LeilaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(LeilaoController.class)
public class LeilaoControllerMockServiceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LeilaoService service;

    @Test
    public void getAllLeiloes() throws Exception {

        List<Leilao> leiloes = new ArrayList<>();

        Leilao leilaoXbox = new CriadorDeLeilao().para("xbox").constroi();

        leiloes.add(leilaoXbox);

        given(service.findAll()).willReturn(leiloes);

        mvc.perform(get("/api/leiloes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].produto", is("xbox")));

    }
}