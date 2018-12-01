package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestConstructor {
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { 5.0, 6.0, 7.0 }, { 10.0, 11.0, 15.0 } };
    }
    @Test(dataProvider = "data-provider")
    public void testConstructor(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        assertEquals("", triangle.getMessage());
        double p = (a+b+c)/2;
        assertEquals(Math.sqrt(p*(p-a)*(p-b)*(p-c)), triangle.getSquare(), 0.01);
    }
}
