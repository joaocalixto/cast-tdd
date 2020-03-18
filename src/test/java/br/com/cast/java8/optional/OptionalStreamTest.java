package br.com.cast.java8.optional;

import br.com.cast.tdd.desafio1.model.Leilao;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class OptionalStreamTest {


    @Test
    public void optionalTest(){

        List<Integer> listaNumeros = Arrays.asList(4,5,6,7,8);

        Optional<Integer> biggerThan10 = listaNumeros.stream()
                .filter(numero -> numero > 10).findAny();


//        boolean present = biggerThan10.isPresent();
//
//        if(present){
//            Integer integer = biggerThan10.get();
//
//        }

        Optional<Integer> biggerThan5 = listaNumeros.stream()
                .filter(numero -> numero > 5)
                .findAny();

        Leilao xbox = new Leilao("xbox");
        Optional<Date> createDateOptional = Optional.of(xbox.getCreateDate());

        createDateOptional.ifPresent((date)-> System.out.println(date));


//        assertEquals(false, biggerThan10.isPresent());
        assertEquals(true,  biggerThan5.isPresent());
    }
}
