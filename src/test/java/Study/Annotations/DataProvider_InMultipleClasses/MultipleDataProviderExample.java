package Study.Annotations.DataProvider_InMultipleClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleDataProviderExample {

    Calculator calculator = new Calculator();

    @Test(dataProvider = "addMethodDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testAddMethod(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.add(a, b), expectedResult);
    }

    @Test(dataProvider = "subtractMethodDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testSubtractMethod(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.subtract(a, b), expectedResult);
    }

    @Test(dataProvider = "multiplyMethodDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void testMultiplyMethod(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.multiply(a, b), expectedResult);
    }


}


class Calculator {

    public int add(int a, int b){
        return a+b;
    }

    public int subtract(int a, int b){
        return a-b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

}

