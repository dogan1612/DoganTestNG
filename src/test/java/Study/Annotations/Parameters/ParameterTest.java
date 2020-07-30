package Study.Annotations.Parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    /**
     * Following method takes one parameter as input.
     * Value of the parameter is defined at suite level.
     */
    @Parameters({ "suite-level-parameter" })
    @Test
    public void TestOne(String param) {
        System.out.println("Parameter for TestOne is: " + param);
    }

    /**
     * Value of the said parameter is defined at test level.
     */
    @Parameters({ "test-level-parameter" })
    @Test
    public void TestTwo(String param) {
        System.out.println("Test two param is: " + param);
    }

    /**
     * Following method takes two parameters as input. Value of the
     * test parameter is defined at test level. The suite level
     * parameter is overridden at the test level.
     */
    @Parameters({ "suite-level-parameter", "test-three-param" })
    @Test
    public void TestThree(String param, String paramTwo) {
        System.out.println("Test three suite param is: " + param);
        System.out.println("Test three param is: " + paramTwo);
    }
}
