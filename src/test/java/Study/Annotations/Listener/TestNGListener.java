package Study.Annotations.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// ITestListener is an Interface. These methods needs to be implemented.

public class TestNGListener implements ITestListener{

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult result){
        System.out.println("New Test Started -- " +result.getName());
    }

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test Failed -- " + result.getName());
    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("Test Skipped -- " + result.getName());
    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test Successfully Finished --" + result.getName());
    }


    // This method is invoked before any test method gets executed.
    // This can be used to get the directory from where the tests are running.
    @Override
    public void onStart(ITestContext context){
        System.out.println("Test-output directory: " + context.getOutputDirectory());
    }

    // This method is invoked after all tests methods gets executed.
    // This can be used to store information of all the tests that were run.
    @Override
    public void onFinish(ITestContext context) {

    }

    // This method is invoked each time the test method fails but is within the success percentage mentioned.
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        System.out.println("Test Failed but within success percentage. Test method: " + result.getName());
    }

}