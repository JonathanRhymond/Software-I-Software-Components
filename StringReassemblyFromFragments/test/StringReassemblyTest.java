import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    /**
     * Tests of combination method
     */

    @Test
    public void comboTest1() {
        String result = StringReassembly.combination("test", "start", 2);
        assertEquals(result, "testart");
    }

    @Test
    public void comboTest2() {
        String result = StringReassembly.combination("rest", "start", 2);
        assertEquals(result, "restart");
    }

    @Test
    public void comboTest3() {
        String result = StringReassembly.combination("play", "start", 0);
        assertEquals(result, "playstart");
    }

    @Test
    public void comboTest4() {
        String result = StringReassembly.combination("planes", "start", 1);
        assertEquals(result, "planestart");
    }

    /**
     * Tests of addToSetAvoidingSubstrings method
     */

    @Test
    public void testAddToSetAvoidingSubstrings1() {
        Set<String> testSet = new Set1L<>();
        testSet.add("apple");
        testSet.add("orange");
        testSet.add("banana");
        testSet.add("kiwi");
        testSet.add("mango");
        StringReassembly.addToSetAvoidingSubstrings(testSet, "pear");
        assertTrue(testSet.contains("pear"));
        assertFalse(testSet.contains("ea"));
        assertFalse(testSet.contains("pe"));
        assertFalse(testSet.contains("ea"));
    }

    @Test
    public void testAddToSetAvoidingSubstrings2() {
        Set<String> testSet = new Set1L<>();
        testSet.add("apple");
        testSet.add("banana");
        testSet.add("kiwi");
        testSet.add("mango");
        StringReassembly.addToSetAvoidingSubstrings(testSet, "banana");
        assertTrue(testSet.contains("banana"));
        assertTrue(testSet.contains("apple"));
        assertTrue(testSet.contains("kiwi"));
        assertTrue(testSet.contains("mango"));
    }

    @Test
    public void testAddToSetAvoidingSubstrings3() {
        Set<String> testSet = new Set1L<>();
        testSet.add("abcd");
        testSet.add("efgh");
        testSet.add("ijkl");
        StringReassembly.addToSetAvoidingSubstrings(testSet, "ab");
        assertFalse(testSet.contains("ab"));
        assertTrue(testSet.contains("abcd"));
        assertTrue(testSet.contains("efgh"));
        assertTrue(testSet.contains("ijkl"));
    }

    @Test
    public void testAddToSetAvoidingSubstrings4() {
        Set<String> testSet = new Set1L<>();
        testSet.add("abcd");
        testSet.add("efgh");
        testSet.add("ijkl");
        StringReassembly.addToSetAvoidingSubstrings(testSet, "mnop");
        assertTrue(testSet.contains("abcd"));
        assertTrue(testSet.contains("efgh"));
        assertTrue(testSet.contains("ijkl"));
        assertTrue(testSet.contains("mnop"));
    }

    /**
     * Tests of linesFromInput method
     */

    @Test
    public void testLinesFromInput1() {
        SimpleReader test = new SimpleReader1L(
                "/Users/jonathanrhymond/Documents/OSU Files/CSE 2221/workspace/StringReassemblyFromFragments/data/cheer-8-2.txt");
        Set<String> result = new Set1L<>();
        Set<String> expected = new Set1L<>();
        expected.add("Bucks -- Beat");
        expected.add("Go Bucks");
        expected.add("Beat Mich");
        expected.add("Michigan~");
        expected.add("o Bucks -- B");
        result = StringReassembly.linesFromInput(test);
        assertEquals(result, expected);
    }

    @Test
    public void testLinesFromInput2() {
        SimpleReader test = new SimpleReader1L(
                "/Users/jonathanrhymond/Documents/OSU Files/CSE 2221/workspace/StringReassemblyFromFragments/data/cheer-8-2.txt");
        Set<String> result = new Set1L<>();
        result = StringReassembly.linesFromInput(test);
        assertEquals(result.size(), 5);
    }

    @Test
    public void testLinesFromInput3() {
        SimpleReader test = new SimpleReader1L(
                "/Users/jonathanrhymond/Documents/OSU Files/CSE 2221/workspace/StringReassemblyFromFragments/data/declaration-50-10.txt");
        Set<String> result = new Set1L<>();
        result = StringReassembly.linesFromInput(test);
        assertEquals(result.size(), 649);
    }

    @Test
    public void testLinesFromInput4() {
        SimpleReader test = new SimpleReader1L(
                "/Users/jonathanrhymond/Documents/OSU Files/CSE 2221/workspace/StringReassemblyFromFragments/data/gettysburg-30-4.txt");
        Set<String> result = new Set1L<>();
        Set<String> expected = new Set1L<>();
        expected.add("Bucks -- Beat");
        expected.add("Go Bucks");
        expected.add("Beat Mich");
        expected.add("Michigan~");
        expected.add("o Bucks -- B");
        result = StringReassembly.linesFromInput(test);
        assertEquals(result.size(), 120);
    }

    /**
     * Tests of printWithLineSeparators method
     */

    @Test
    public void testLineSeperators1() {
        String testString = "Line 1~Line 2~Line 3";
        String expectedTestString = "Line 1~Line 2~Line 3";
        SimpleWriter out = new SimpleWriter1L("test.txt");
        StringReassembly.printWithLineSeparators(testString, out);
        assertEquals(testString, expectedTestString);
    }

    @Test
    public void testLineSeperators2() {
        String testString = "";
        String expectedTestString = "";
        SimpleWriter out = new SimpleWriter1L("test.txt");
        StringReassembly.printWithLineSeparators(testString, out);
        assertEquals(testString, expectedTestString);
    }

    @Test
    public void testLineSeperators3() {
        String testString = "a~b~c~d~e~f~g";
        SimpleWriter out = new SimpleWriter1L("test.txt");
        StringReassembly.printWithLineSeparators(testString, out);
        SimpleReader in = new SimpleReader1L("test.txt");
        int lineCount = 0;
        while (!in.atEOS()) {
            String line = in.nextLine();
            lineCount++;
        }
        assertEquals(lineCount, 7);
    }

    @Test
    public void testLineSeperators4() {
        String testString = "abcdefg";
        SimpleWriter out = new SimpleWriter1L("test.txt");
        StringReassembly.printWithLineSeparators(testString, out);
        SimpleReader in = new SimpleReader1L("test.txt");
        int lineCount = 0;
        while (!in.atEOS()) {
            String line = in.nextLine();
            lineCount++;
        }
        assertEquals(lineCount, 1);
    }

}
