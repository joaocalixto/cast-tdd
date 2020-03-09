package exemples;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeforeClassTest {



    @BeforeClass
    public static void init() {

        System.out.println("Iniciando conexao com banco de dados");
    }

    @Test
    public void testeSimples(){
        System.out.println("teste 1");
    }

    @Test
    public void testeSimples2(){
        System.out.println("teste 2");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Terminando conexao com o banco de dados");
    }
}
