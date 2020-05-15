import org.junit.Assert;
import org.junit.Test;

public class MainClassTest
{
    @Test
    public void testGetLocalNumber()
    {
        Assert.assertTrue("Number is not 14", MainClass.getLocalNumber() == 14);
    }


    MainClass getClassNumber = new MainClass();
    @Test
    public void testGetClassNumber()
    {
        Assert.assertTrue("Number <= 45",getClassNumber.getClassNumber() > 45);
    }

    MainClass getClassString = new MainClass();
    @Test
    public void testGetClassString()
    {
        Assert.assertTrue("There is not a 'Hello' word", getClassString.getClassString().toLowerCase().contains("hello"));
    }
}
