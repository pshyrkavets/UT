package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TestMethodsForNumberFormatException {
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { 21.0, 15.0, 30.0 }, { 44.0, 22.0, 17.0 } };
    }
    @Test(dataProvider = "data-provider", expectedExceptions={NumberFormatException.class})
    public void testDetectTriangle(double a, double b, double c) throws NumberFormatException {
        //Overflow is possible in the fragment of code ((a*a+b*b == c*c) || (b*b + c*c == a*a)||(a*a + c*c == b*c)) of
        // the detectTriangle() method.
        Triangle triangle = new Triangle(a, b, c);
        if(triangle.detectTriangle() == 1) {
            assertEquals(1, triangle.detectTriangle(), "TR_EQUILATERAL");
        } else if(triangle.detectTriangle() == 2) {
            assertEquals(2, triangle.detectTriangle(), "TR_ISOSCELES");
        } else if(triangle.detectTriangle() == 4) {
            assertEquals(4, triangle.detectTriangle(), "TR_ORDYNARY");
        } else if(triangle.detectTriangle() == 8) {
            assertEquals(8, triangle.detectTriangle(), "TR_RECTANGULAR");
        } else {
            fail("Test failed!");
        }
    }
    @Test(dataProvider = "data-provider", expectedExceptions={NumberFormatException.class})
    public void testGetSquare(double a, double b, double c) throws NumberFormatException {
        //Overflow is possible in the fragments of code (a+b+c) and (p*(p-a)*(p-b)*(p-c)) of
        // the getSquare() method.
        Triangle triangle = new Triangle(a, b, c);
        double p = (a+b+c)/2;
        assertEquals(Math.sqrt(p*(p-a)*(p-b)*(p-c)), triangle.getSquare(), 0.01);
    }
}
