package br.com.cast.java8;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

public class DefaultMethodsTest {

    List<String> listaPalavras = Arrays.asList("B", "AAAA", "CCCCC");


    @Test
    public void sort_defaultMethodTest(){

        OrdenarPorTamanho ordenarPorTamanho = new OrdenarPorTamanho();

        // ordena com comparator
//        Collections.sort(listaPalavras, ordenarPorTamanho);

        // ordena default
//        Collections.sort(listaPalavras);

        listaPalavras.sort((s1, s2) -> {
                if(s1.length() >= s2.length()){
                    return -1;
                }
                return 1;
            }
        );

        Thread teste_com_thread = new Thread(() -> {
            System.out.println("Teste com thread");
        });

        teste_com_thread.start();

        System.out.println(listaPalavras);
    }

    @Test
    public void foreach_defaultMehodTest(){

        listaPalavras.forEach(new ImprimeNaLinha());

    }

    class OrdenarPorTamanho implements Comparator<String>{


        @Override
        public int compare(String s1, String s2) {

            if(s1.length() >= s2.length()){
                return -1;
            }
            return 1;
        }
    }

    class ImprimeNaLinha implements Consumer<String> {

        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    }


}
