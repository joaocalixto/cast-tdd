import org.junit.Assert;

import static org.junit.Assert.*;

public class MathUtilsTest {

    @org.junit.Test
    public void computeCircleArea() {

        br.com.cast.pic.tdd.exercicios.MathUtils mathUtils = new br.com.cast.pic.tdd.exercicios.MathUtils();

        double expectedValue = 314.1592653589793d;

        double returnedValue = mathUtils.computeCircleArea(10);

        Assert.assertEquals(expectedValue, returnedValue, 0);
    }
}