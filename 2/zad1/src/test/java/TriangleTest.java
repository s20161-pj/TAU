import org.example.Triangle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TriangleTest {
    private Triangle triangle;

    @Before
    public void setUp() {
        triangle = new Triangle();
    }

    @After
    public void tearDown() {
        triangle = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void trianglePerimeterShouldThrowExceptionWhenParametersAreNegativeTest() {
        // arrange
        triangle.a = -1.5;
        triangle.b = -2.5;
        triangle.c = -3.5;

        //act
        triangle.setPerimeter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void trianglePerimeterShouldThrowExceptionWhenOneParameterIsMissingTest() {
        // arrange
        triangle.b = 2.5;
        triangle.c = 3.5;

        //act
        triangle.setPerimeter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void trianglePerimeterShouldThrowExceptionWhenOneParameterIsZeroTest() {
        // arrange
        triangle.a = 1.5;
        triangle.b = 2.5;
        triangle.c = 0;

        //act
        triangle.setPerimeter();
    }

    @Test
    public void trianglePerimeterShouldBeCorrectWhenParametersAreProperTest() {
        // arrange
        triangle.a = 1.5;
        triangle.b = 2.5;
        triangle.c = 3.5;

        //act
        double expectedResult = (1 / 2) * (triangle.a + triangle.b + triangle.c);
        triangle.setPerimeter();
        double actualResult = triangle.getPerimeter();

        // assert
        assertEquals(expectedResult, actualResult, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void triangleHeightShouldThrowExceptionWhenParametersAreNegativeTest(){
        // arrange
        triangle.a = -1.5;
        triangle.c = -3.5;

        //act
        triangle.seth();
    }

    @Test(expected = IllegalArgumentException.class)
    public void triangleHeightShouldThrowExceptionWhenOneParameterIsZeroTest(){
        //arrange
        triangle.a = 0;
        triangle.c = 3.5;

        //act
        triangle.seth();
    }

    @Test
    public void triangleHeightShouldBeCorrectWhenParametersAreProperTest() {
        // arrange
        triangle.a = 1.5;
        triangle.c = 3.5;

        //act
        double expectedResult =  Math.sqrt(triangle.c * triangle.c - ((1 / 2) * triangle.a * (1 / 2) * triangle.a));
        triangle.seth();
        double actualResult = triangle.geth();

        // assert
        assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void triangleIsEquilateralTest(){
        //arrange
        triangle.a = 3;
        triangle.b = 3;
        triangle.c = 3;

        //act
        double expectedResult = ((triangle.a* triangle.a * Math.sqrt(3)) / 4);
        double actualResult = triangle.getArea();

        // assert
        assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void triangleIsIsoscelesTest(){
        //arrange
        triangle.a = 3;
        triangle.b = 3;
        triangle.c = 5;

        //act
        triangle.setPerimeter();
        double perimeter = triangle.getPerimeter();
        double expectedResult = Math.sqrt(perimeter * (perimeter - triangle.a) * (perimeter - triangle.b) * (perimeter - triangle.c));
        double actualResult = triangle.getArea();

        // assert
        assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void triangleIsScaleneTest(){
        //arrange
        triangle.a = 3;
        triangle.b = 4;
        triangle.c = 5;

        //act
        triangle.seth();
        double h = triangle.geth();
        double expectedResult = (1 / 2) * triangle.c * h;
        double actualResult = triangle.getArea();

        // assert
        assertEquals(expectedResult, actualResult, 0);
    }

}