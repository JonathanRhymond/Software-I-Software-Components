import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Put your name here
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(21);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_256_88() {
        NaturalNumber n = new NaturalNumber2(256);
        NaturalNumber nExpected = new NaturalNumber2(8);
        NaturalNumber m = new NaturalNumber2(88);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_400_122() {
        NaturalNumber n = new NaturalNumber2(400);
        NaturalNumber nExpected = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(122);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_8() {
        NaturalNumber n = new NaturalNumber2(8);
        NaturalNumber nExpected = new NaturalNumber2(8);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_993() {
        NaturalNumber n = new NaturalNumber2(993);
        NaturalNumber nExpected = new NaturalNumber2(993);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber pExpected = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_2_3_4() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(3);
        NaturalNumber pExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(4);
        NaturalNumber mExpected = new NaturalNumber2(4);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_3_4_5() {
        NaturalNumber n = new NaturalNumber2(3);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(4);
        NaturalNumber pExpected = new NaturalNumber2(4);
        NaturalNumber m = new NaturalNumber2(5);
        NaturalNumber mExpected = new NaturalNumber2(5);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of IsWitnessToCompositeness
     */

    @Test
    public void testIsWitnessToCompositeness_24_43() {
        NaturalNumber w = new NaturalNumber2(24);
        NaturalNumber wExpected = new NaturalNumber2(24);
        NaturalNumber n = new NaturalNumber2(43);
        NaturalNumber nExpected = new NaturalNumber2(43);
        boolean isWitness = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(isWitness, false);
    }

    @Test
    public void testIsWitnessToCompositeness_15_79() {
        NaturalNumber w = new NaturalNumber2(15);
        NaturalNumber wExpected = new NaturalNumber2(15);
        NaturalNumber n = new NaturalNumber2(79);
        NaturalNumber nExpected = new NaturalNumber2(79);
        boolean isWitness = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(isWitness, false);
    }

    @Test
    public void testIsWitnessToCompositeness_129_563() {
        NaturalNumber w = new NaturalNumber2(129);
        NaturalNumber wExpected = new NaturalNumber2(129);
        NaturalNumber n = new NaturalNumber2(563);
        NaturalNumber nExpected = new NaturalNumber2(563);
        boolean isWitness = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(isWitness, false);
    }

    @Test
    public void testIsWitnessToCompositeness_77_386() {
        NaturalNumber w = new NaturalNumber2(77);
        NaturalNumber wExpected = new NaturalNumber2(77);
        NaturalNumber n = new NaturalNumber2(386);
        NaturalNumber nExpected = new NaturalNumber2(386);
        boolean isWitness = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(isWitness, true);
    }

    /*
     * Tests of isPrime2
     */

    @Test
    public void testIsPrime2_43() {
        NaturalNumber n = new NaturalNumber2(43);
        NaturalNumber nExpected = new NaturalNumber2(43);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsPrime2_79() {
        NaturalNumber n = new NaturalNumber2(79);
        NaturalNumber nExpected = new NaturalNumber2(79);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsPrime2_563() {
        NaturalNumber n = new NaturalNumber2(563);
        NaturalNumber nExpected = new NaturalNumber2(563);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsPrime2_386() {
        NaturalNumber n = new NaturalNumber2(386);
        NaturalNumber nExpected = new NaturalNumber2(386);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /*
     * Tests of GenerateNextLikelyPrime
     */

    @Test
    public void testGenerateNextLikelyPrime_521() {
        NaturalNumber n = new NaturalNumber2(521);
        NaturalNumber nExpected = new NaturalNumber2(521);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    @Test
    public void testGenerateNextLikelyPrime_781() {
        NaturalNumber n = new NaturalNumber2(781);
        NaturalNumber nExpected = new NaturalNumber2(787);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    @Test
    public void testGenerateNextLikelyPrime_227() {
        NaturalNumber n = new NaturalNumber2(227);
        NaturalNumber nExpected = new NaturalNumber2(227);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    @Test
    public void testGenerateNextLikelyPrime_36() {
        NaturalNumber n = new NaturalNumber2(36);
        NaturalNumber nExpected = new NaturalNumber2(37);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

}