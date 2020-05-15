import org.junit.Assert;
import org.junit.Test;

public class MainClassTest
{
    @Test
    public void testGetLocalNumber()
    {
        Assert.assertTrue("Number is not 14", MainClass.getLocalNumber() == 14);
    }


    MainClass Helper = new MainClass();
    @Test
    public void testGetClassNumber()
    {
        Assert.assertTrue("Number <= 45",Helper.getClassNumber() > 45);
    }

    MainClass getString = new MainClass();
    @Test
    public boolean testGetClassString()
    {
        Assert.assertTrue("There is not a 'Hello' word", getString.getClassString());
    }
}
