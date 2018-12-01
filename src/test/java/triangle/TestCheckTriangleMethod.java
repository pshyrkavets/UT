package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class TestCheckTriangleMethod {
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { 21.0, 15.0, 30.0 }, { 44.0, 22.0, 17.0 } };
    }
    @Test(dataProvider = "data-provider")
    public void testCheckTriangle(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        assertTrue(triangle.checkTriangle());
    }
}
