import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UnitTest {

    private Calculator calculator=new Calculator();

    @DataProvider
    public Object[][] additionPositive(){
        return new Object[][]{
                {-1, -2147483648,2147483647},
                {2147483647,1073741823,1073741824},
                {0,0,0}
        };
    }

    @Test(dataProvider = "additionPositive")
    public void additionPos(int expected,int first,int second){
        Assert.assertEquals(expected,calculator.addition(first,second));
    }

    @DataProvider
    public Object[][] subtractionPositive(){
        return new Object[][]{
                {-2147483648, -1073741824, 1073741824},
                {0, 0, 0},
                {0,-1073741824, -1073741824},
                {2147483647,1073741824,-1073741823},
        };
    }

    @Test(dataProvider = "subtractionPositive")
    public void subtractionPos(int expected,int first,int second){
        Assert.assertEquals(expected,calculator.subtraction(first,second));
    }

    @DataProvider
    public Object[][]  multiplicationPositive(){
        return new Object[][]{
                {2147483646,1073741823,2},
                {0,0,0}
        };
    }

    @Test(dataProvider = "multiplicationPositive")
    public void  multiplicationPos(int expected,int first,int second){
        Assert.assertEquals(expected,calculator.multiplication(first,second));
    }

    @DataProvider
    public Object[][]  divisionPositive(){
        return new Object[][]{
                {1073741823,2147483646,2},
                {0,0,-2}
        };
    }

    @Test(dataProvider = "divisionPositive")
    public void  divisionPos(int expected,int first,int second){
        Assert.assertEquals(expected,calculator.division(first,second));
    }

    @DataProvider
    public Object[][]  negative(){
        return new Object[][]{
                {-6,-3,-3},
                {-8,-4,-4}
        };
    }

    @Test(dataProvider = "negative")
    public void negative (int expected,int first,int second){
       Assert.assertNotEquals(expected,calculator.subtraction(first,second));
       Assert.assertNotEquals(expected,calculator.division(first,second));
       Assert.assertNotEquals(expected,calculator.multiplication(first, second));
    }

}
