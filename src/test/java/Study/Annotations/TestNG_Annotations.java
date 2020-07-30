package Study.Annotations;

import org.testng.annotations.*;

public class TestNG_Annotations {
/*
    What is org.testng.TestNG?
            -> TestNG stands for Test NextGeneration.
            -> TestNG is a unit testing tool that allows us create flow using Annotations.
	-> First we create methods, then we use TestNG annotations to create running flow.
            - We decide which method is test
		- Which method runs before tests
		- Which method runs after tests
		- And so on and so forth

    What are annotations?
            -> Annotations are a way of controlling the flow of the test.

    @Test annotation:
            -> Makes the annotated method a TestNG test.
	-> Which allows us to run those methods(tests) without main method.
            -> All of the tests are independent from each other, UNLESS we create dependency.


        HIERARCHY OF TESTNG ANNOTATIONS **********************************

        BeforeSuite                                AfterSuite
            BeforeTest                          AfterTest
                BeforeClass                 AfterClass
                    BeforeMethod        AfterMethod
                                  @Test

     */

    @BeforeSuite
    public void before_suite(){
        System.out.println("BeforeSuite will be run only once! before all tests in the suite have run");
        System.out.println("A test suite is a collection of test cases");
    }

    @BeforeTest
    public void before_Test(){
        System.out.println("BeforeTest will be run before any test belonging to the classes inside the <test> tag is run!");
    }

    @BeforeClass
    public void before_class(){
        System.out.println("BeforeCLASS will be run only once, before the first test method in the current class");
    }

    @BeforeMethod
    public void before_method(){
        System.out.println("BeforeMethod will be run before each @Test method");
    }

    @Test
    public void test() {
        System.out.println("Test is running...");
        System.out.println(System.getProperty("user.dir"));
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("Test2 is running...");

    }

    @AfterMethod
    public void after_method(){
        System.out.println("AfterMethod will be run after each @Test method");
    }

    @AfterClass
    public void after_class(){
        System.out.println("AfterCLASS will be run only once, after all the test methods in the current class have been run");
    }

    @AfterTest
    public void after_Test(){
        System.out.println("AfterTest will be run after all the test methods belonging to the classes inside the <test> tag is run");
    }

    @AfterSuite
    public void after_suite(){
        System.out.println("AfterSuite will be run only once after all tests in the suite have run");
    }
}

