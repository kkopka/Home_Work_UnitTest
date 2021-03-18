import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UnitTest {

    @DataProvider
    public Object[][] positive() {

        return new Object[][]{
                {"5.0", "+", "5", "0"},
                {"1.8","+","0.9","0.9"},
                {"0.05", "*", "-0.5", "-0.1"},
                {"0.0","/","0","5"},
                {"0.0","-","-1","-1"},
                {"25.0","*","5","5"},
                {"4.5","/","0.9","0.2"}
        };
    }

    @Test(dataProvider = "positive")
    public void positiveTest(String expected, String operation, String first, String second) {
        Calculator.computation(first, second, operation);
        System.out.println("Результат positive теста: "+ Calculator.getResult());
        Assert.assertEquals(expected, Calculator.getResult());
    }

    @DataProvider
    public Object[][] negative() {

        return new Object[][]{
                {"Нет подходящего символа", "@", "-4", "-1"},
                {"Infinity","/","5","0"},
                {"Вы ввели неверные данные","*","g","3"}
        };
    }

    @Test(dataProvider = "negative")
    public void negativeTest(String expected, String operation, String first, String second) {
        Calculator.computation(first, second, operation);
        System.out.println("Результат negative теста: "+ Calculator.getResult());
        Assert.assertEquals(expected, Calculator.getResult());
    }

}
