package Study.Annotations.Factory_with_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class TestNGFactory2 {

    @Factory(dataProvider = "dp")
    public Object[] getTestClasses(String s) {
        Object[] tests = new Object[2];
        tests[0] = new TestA(s);
        tests[1] = new TestB();
        return tests;
    }

    @DataProvider
    public Object[] dp() {
        return new Object[] {"A", "B"};
    }

}
