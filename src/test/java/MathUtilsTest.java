import br.com.cast.tdd.MathUtils;
import org.junit.Assert;
import org.junit.Test;

public class MathUtilsTest {

    MathUtils mathUtils = new MathUtils();

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