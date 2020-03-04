import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathUtilsTest {

    br.com.cast.pic.tdd.exercicios.MathUtils mathUtils = new br.com.cast.pic.tdd.exercicios.MathUtils();

    @Test
    public void deveRetornarAreaCirculoEsperadaQuandoMetodoComputeCircleAreaChamado() {

        // given
        int raio = 10;

        // when
        double returnedValue = mathUtils.computeCircleArea(raio);

        // then
        double expectedValue = 314.1592653589793d;

        Assert.assertEquals(expectedValue, returnedValue, 0);
    }
}