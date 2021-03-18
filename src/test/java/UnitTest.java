import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UnitTest {

    @DataProvider
    public Object[][] positive(){

        return new Object[][]{
                { -2147483648,2147483647},


        };
    }

    @Test(dataProvider = "positive")
    public void additionPos(String expected,double first,double second){
     //    Calculator.computation(first,second,expected);
        // Assert.assertNotEquals(null,);
    }

}
