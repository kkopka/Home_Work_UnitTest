import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UnitTest {

    @DataProvider
    public Object[][] positive() {

        return new Object[][]{
                {"5", "+", "5", "0"},
                {"-0.6", "+", "-0.5", "-0.1"},
                {"0","/","0","5"},
                {"0","-","-1","-1"}
        };
    }

    @Test(dataProvider = "positive")
    public void positiveTest(String expected, String operation, String first, String second) {
        Calculator.computation(first, second, operation);
        System.out.println(Calculator.getResult());
        Assert.assertNotEquals(expected, Calculator.getResult());
    }

    @DataProvider
    public Object[][] negative() {

        return new Object[][]{
                {"null", "#", "-4", "-1"},
                {"Infinity","/","5","0"},
                {"null","*","g","4"}
        };
    }

    @Test(dataProvider = "negative")
    public void negativeTest(String expected, String operation, String first, String second) {
        Calculator.computation(first, second, operation);
        System.out.println(Calculator.getResult());
        Assert.assertNotEquals(expected, Calculator.getResult());
    }

}
