package br.com.cast.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaTest {

    List<String> listaPalavras = Arrays.asList("B", "AAAA", "CCCCC");

    List<String> listaNumeros = Arrays.asList("1", "2", "3");

    @Test
    public void lambda1(){

        Function<Integer, Integer> function = (x) -> 3 * x + 2;

        Integer resultadoRecebido = function.apply(1);

        Assert.assertEquals(new Integer(5), resultadoRecebido);
    }

    @Test
    public void operacoesTerminais(){

        // operacao intermediaria
        // count operacao terminal
        List<Integer> collect = listaNumeros.parallelStream()
                .map(numeroStr -> Integer.valueOf(numeroStr))
                .filter(numero -> numero > 2)

                .collect(Collectors.toList());

        System.out.println(collect);

//        listaPalavras.stream().filter(palavra -> {
//            System.out.println(palavra);
//            return true;
//        }).count();
    }

}
