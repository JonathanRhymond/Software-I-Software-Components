import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

public class NNtoStringWithCommasTest {

    /**
     * Calls the method under test.
     *
     * @param n
     *            the number to pass to the method under test
     * @return the {@code String} returned by the method under test
     * @ensures <pre>
     * redirectToMethodUnderTest = [String returned by the method under test]
     * </pre>
     */
    private static String redirectToMethodUnderTest(NaturalNumber n) {
        return NNtoStringWithCommas1.toStringWithCommas(n);
    }

    /**
     * Tests to see if can print out 0, which requires no commas
     */
    @Test
    public void commaTest1() {
        NaturalNumber n = new NaturalNumber2(0);
        String result = redirectToMethodUnderTest(n);

        assertTrue(result.length() == 1);
        assertEquals("0", result);
    }

    /**
     * Tests to see if can print out 3 digit number, which requires no commas
     */
    @Test
    public void commaTest2() {
        NaturalNumber n = new NaturalNumber2(100);
        String result = redirectToMethodUnderTest(n);

        assertTrue(result.length() == 3);
        assertEquals("100", result);
    }

    /**
     * Test to see if can print out 4 digit number, which needs one comma
     */
    @Test
    public void commaTest3() {
        NaturalNumber n = new NaturalNumber2(9999);
        String result = redirectToMethodUnderTest(n);

        assertTrue(result.length() == 5);
        assertEquals("9,999", result);
    }

    /**
     * Test to see if can print out 5 digit number, which needs one comma
     */
    @Test
    public void commaTest4() {
        NaturalNumber n = new NaturalNumber2(67898);
        String result = redirectToMethodUnderTest(n);

        assertTrue(result.length() == 6);
        assertEquals("67,898", result);
    }

    /**
     * Tests to see if can print out longer number, needing 2 commas.
     */
    @Test
    public void commaTest5() {
        NaturalNumber n = new NaturalNumber2(99999999);
        String result = redirectToMethodUnderTest(n);

        assertTrue(result.length() == 10);
        assertEquals("99,999,999", result);
    }

    /**
     * Tests to see if can print out very large number, needing 3 commas
     */
    @Test
    public void commaTest6() {
        NaturalNumber n = new NaturalNumber2(1000000000);
        String result = redirectToMethodUnderTest(n);

        assertTrue(result.length() == 13);
        assertEquals("1,000,000,000", result);
    }

}
