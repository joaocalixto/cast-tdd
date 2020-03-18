package br.com.cast.java8.data;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DataJava8Test {


    @Test
    public void retornandoDataDeHoje(){

        // new Date()
        LocalDate hoje = LocalDate.now();

        System.out.println(hoje);
    }

    @Test
    public void retornandoDataMarretada(){

        LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);

        System.out.println(olimpiadasRio);
    }

    @Test
    public void calculandoDiferencas(){

        LocalDate hoje = LocalDate.now();

        LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
        int anos = olimpiadasRio.getYear() - hoje.getYear();

        System.out.println(anos);

    }

    @Test
    public void betweenPeriod(){
        LocalDate hoje = LocalDate.now();
        LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);

        Period periodo = Period.between(hoje, olimpiadasRio);
        System.out.println(periodo);
        System.out.println(periodo.getYears());
        System.out.println(periodo.getMonths());
    }

    @Test
    public void adicionandoDias(){
        LocalDate hoje = LocalDate.now();


        System.out.println(hoje.minusYears(1));
        System.out.println(hoje.minusDays(2));

    }

    @Test
    public void formatandoDatas(){
        LocalDate hoje = LocalDate.now();

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy/dd/MM/yyyy");

        String valorFormatado = hoje.format(formatador);

        System.out.println(valorFormatado);

    }
}
