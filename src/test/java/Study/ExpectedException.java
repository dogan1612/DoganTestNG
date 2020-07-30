package Study;

import org.testng.annotations.Test;

import java.io.IOException;

public class ExpectedException {

    @Test(expectedExceptions = { IOException.class })
    public void exceptionTestOne() throws Exception {
        throw new IOException();            // pass
    }

    @Test(expectedExceptions = { ArithmeticException.class})
    public void exceptionTestTwo() throws Exception {
        System.out.println(5/0);
        int n = 10/0;                   // pass
    }

    @Test(expectedExceptions = { IOException.class, NullPointerException.class })
    public void exceptionTestThree() throws Exception {
        throw new Exception();      // it will fail bcos there is no match
    }

    // ******************************************************

    @Test(expectedExceptions = { IOException.class }, expectedExceptionsMessageRegExp = "Pass Message test")
    public void customMsg1() throws Exception {
        throw new IOException("Pass Message test");
    }

    @Test(expectedExceptions = { IOException.class }, expectedExceptionsMessageRegExp = ".* Message .*")
    public void customMsg2() throws Exception {
        throw new IOException("Pass Message test");
    }

    @Test(expectedExceptions = { IOException.class }, expectedExceptionsMessageRegExp = "Pass Message test")
    public void customMsg3() throws Exception {
        throw new IOException("Fail Message test");     // Fail
    }

    @Test(expectedExceptions = { ArithmeticException.class }, expectedExceptionsMessageRegExp = ".* divide .*")
    public void customMsg4() throws Exception {
        throw new ArithmeticException("Don't divide by 0");
    }

}
