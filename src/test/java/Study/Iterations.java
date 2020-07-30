package Study;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Iterations {

    private int i = 0;

    @Test(successPercentage=100, invocationCount=5)
    public void example(){
        i++;
        System.out.println(i);
    }
}
