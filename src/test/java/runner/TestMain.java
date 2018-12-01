package runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class TestMain {
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { 21.0, 15.0, 30.0 }, { 44.0, 22.0, 17.0 } };
    }
    @Test(dataProvider = "data-provider")
    public void testMain(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        System.out.println(triangle.checkTriangle());
        System.out.println(triangle.getMessage());
        System.out.println(triangle.detectTriangle());
    }
}

