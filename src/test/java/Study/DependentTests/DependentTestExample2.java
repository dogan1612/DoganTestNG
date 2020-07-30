package Study.DependentTests;

import org.testng.annotations.Test;

public class DependentTestExample2 {

    @Test(dependsOnMethods = { "testTwo", "testThree" })
    public void testOne() {
        System.out.println("Test method one");
    }

    @Test
    public void testTwo() {
        System.out.println("Test method two");
    }

    @Test
    public void testThree() {
        System.out.println("Test method three");
    }

}

/*
    Output:
    Test method three
    Test method two
    Test method one
 */
