package Component.Tests;

import org.testng.annotations.Test;

public class SmokeTestA {
    @Test(groups = { "smoke" })
    public void testMethodOne() {
        System.out.println("Test 1 is belonging to smoke group.");
    }

    @Test
    public void testMethodTwo() {
        System.out.println("Test 2 is not belonging to smoke group.");
    }

    @Test(groups = { "smoke" })
    public void testMethodThree() {
        System.out.println("Test 3 is belonging to smoke group.");
    }
}



