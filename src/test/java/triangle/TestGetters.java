package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestGetters {
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { 21.0, 15.0, 30.0 }, { 44.0, 22.0, 17.0 } };
    }
    @Test(dataProvider = "data-provider")
    public void testGetters(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        assertEquals("", triangle.getMessage(), "Error in getMessage()!");
        double p = (a+b+c)/2;
        assertEquals(Math.sqrt(p*(p-a)*(p-b)*(p-c)), triangle.getSquare(), 0.01, "Error in getSquare()!");
    }
}
