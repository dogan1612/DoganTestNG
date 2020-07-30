package Study.Annotations.Factory;

import org.testng.annotations.Factory;

public class TestNGFactory {

    @Factory()
    public Object[] getTestClasses() {
        Object[] tests = new Object[2];
        tests[0] = new Test1();
        tests[1] = new Test2();
        return tests;
    }

}
// we define a Factory method that returns an Object array of 2 classes.
// It returns an object array

// TestNG Factory is useful when you want to run multiple test classes through a single test class.
// Let’s say we have two Test classes with few test methods defined.