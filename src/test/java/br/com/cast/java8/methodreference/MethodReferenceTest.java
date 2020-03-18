package br.com.cast.java8.methodreference;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class MethodReferenceTest {


    // findNumbers recebe uma lista e um Predicado
    // o predicado pode ser transformado em lambda pq é uma interface funcional
    // como a chamada desse lambda só tem um método
    // podemos transformalo para um method reference

    @Test
    public void methodReferencePasso1(){

        List<Integer> list = Arrays.asList(12,5,45,18,33,24,40);


        Numbers.findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2));


        Numbers.findNumbers(list, Numbers::isMoreThanFifty);

    }

    static class Numbers {


        public static boolean isMoreThanFifty(int n1, int n2) {
            return (n1 + n2) > 50;
        }

        public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer, Integer> p) {
            List<Integer> newList = new ArrayList<>();
            for(Integer i : l) {
                if(p.test(i, i + 10)) {
                    newList.add(i);
                }
            }
            return newList;
        }
    }
}
