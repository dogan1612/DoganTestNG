package Component.Tests;

import org.testng.annotations.Test;

public class SmokeTestB {
    @Test
    public void testMethodFour() {
        System.out.println("Test 4 is not belonging to smoke group.");
    }

    @Test(groups = { "smoke" })
    public void testMethodFive() {
        System.out.println("Test 5 is belonging to smoke group.");
    }

    @Test
    public void testMethodSix() {
        System.out.println("Test 6 is not belonging to smoke group");
    }
}



