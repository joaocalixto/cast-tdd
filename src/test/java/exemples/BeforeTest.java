package exemples;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeforeTest {


    private List<String> list;

    @Before
    public void qualquerNome() {
        System.out.println("startup");
        list = new ArrayList<String>(Arrays.asList("test1", "test2"));
    }

    @Test
    public void testandoBeforeEAfter(){
        System.out.println("testando... 1");
        Assert.assertEquals(2, list.size());

        list.add("teste3");
    }

    @Test
    public void testandoBeforeEAfterExemplo2(){
        System.out.println("testando... 2");
        Assert.assertEquals(2, list.size());

        list.add("outro teste");
    }

    @After
    public void finalizar() {
        System.out.println("finalize");
        list.clear();
    }
}
