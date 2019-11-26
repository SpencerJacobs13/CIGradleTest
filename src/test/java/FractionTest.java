import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest {
    Fraction fraction;


    @Test
    public void testConstructor(){
        fraction = new Fraction(1, 2);
        assertEquals(fraction.getRealValue(), .5);
    }

//    @Test
//    public void testReduce(){
//        fraction = new Fraction(5, 10);
//        assertEquals(.5, fraction.reduce());
//    }

}
