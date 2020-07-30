package Study.Annotations.Factory_with_DataProvider;

import org.testng.annotations.Test;

public class TestA {

    private String str;

    public TestA(String s) {
        this.str = s;
    }

    @Test
    public void test1() {
        System.out.println("Test1 test method. str = "+str);
    }
}
