package Study.Annotations.Listener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// @Listeners(PackageName.ClassName.class)
@Listeners(TestNGListener.class)

public class TestCases {

    @Test
    public void TestToPass(){
        Assert.assertTrue(true);
    }

    @Test(enabled = true)
    public void TestToFail(){
        System.out.println("This method to test fail");
        Assert.assertTrue(false);
    }

    @Test
    public void TestToSkip(){
        throw new SkipException("Forcely skipping the test");
    }

    private int i = 0;

    @Test (successPercentage=60, invocationCount=5)
    public void example(){
        /*
           5 x .60 = 3  => that means:
           if at least 3 out of 5 times the test method gets passed,
           it would be considered as passed.
           onTestFailedButWithinSuccessPercentage (in listener class)
           will be invoked each time the test method fails
           but is within the success percentage mentioned.
         */
        i++;
        if (i == 1 || i == 2) {
            Assert.assertEquals(i, 6);
        }
    }


}

