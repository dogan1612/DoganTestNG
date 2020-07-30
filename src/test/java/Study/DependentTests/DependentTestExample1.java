package Study.DependentTests;

import org.testng.annotations.Test;

public class DependentTestExample1 {

    @Test(dependsOnMethods = { "testTwo" })
    public void testOne() {
        System.out.println("Test 1 one will be executed after Test 2");
    }

    @Test(enabled = true)
    public void testTwo() {
        System.out.println("Test method 2");
    }
}


