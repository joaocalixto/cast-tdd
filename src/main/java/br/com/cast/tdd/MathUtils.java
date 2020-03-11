package br.com.cast.tdd;

public class MathUtils {


    // calcular a area de um circulo
    // primeiro crie o teste, mas oq o teste vai chamar se não existe nenhuma implementação ainda
    // oq acontece na prática é :
    // crie um metodo mockado para que o seu teste chame ele

    // passo 1 - criar método e retorne qualer valor

    public double computeCircleArea(double radius){

        return Math.PI * radius * radius;

    }
}
