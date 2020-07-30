package Study.Annotations.DataProvider_inOneClass;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    @Test(dataProvider = "addMethodDataProvider")
    public void testAddMethod(int a, int b, int result) {
        Calc calculator = new Calc();
        Assert.assertEquals(calculator.add(a, b), result);
    }

    @DataProvider(name = "addMethodDataProvider")
    public Object[][] dataProvider() {
        return new Object[][] { { 2, 5, 7 }, { 3, 7, 10 }, { 4, 5, 9 } };
    }

}


class Calc {
    public int add(int a, int b){
        return a+b;
    }

}

