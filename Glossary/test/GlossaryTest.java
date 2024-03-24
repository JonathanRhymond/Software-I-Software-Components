import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class GlossaryTest {

    //all JUnit test output will go to TestCaseResults folder in test folder
    //all JUnit test input is located in TestCaseHTMLs

    /**
     * generateElements test cases
     */

    public void comparatorTest1() {
    }

    /**
     * generateElements test cases
     */

    //tests method with an empty string
    @Test
    public void generateElementsTest1() {
        Set<Character> charSet = new Set1L<>();
        Glossary.generateElements("", charSet);
        assertTrue(charSet.size() == 0);
    }

    //tests method with a string that contains only one character
    @Test
    public void generateElementsTest2() {
        Set<Character> charSet = new Set1L<>();
        Glossary.generateElements("a", charSet);
        assertEquals(1, charSet.size());
        assertTrue(charSet.contains('a'));
    }

    //tests method with a string that contains multiple characters
    @Test
    public void generateElementsTest3() {
        Set<Character> charSet = new Set1L<>();
        Glossary.generateElements("hello world", charSet);
        assertEquals(8, charSet.size());
        assertTrue(charSet.contains('h'));
        assertTrue(charSet.contains('e'));
        assertTrue(charSet.contains('l'));
        assertTrue(charSet.contains('o'));
        assertTrue(charSet.contains('w'));
        assertTrue(charSet.contains('r'));
        assertTrue(charSet.contains('d'));
        assertTrue(charSet.contains(' '));
    }

    //tests method with a string of non alphabetic characters
    @Test
    public void generateElementsTest4() {
        Set<Character> charSet = new Set1L<>();
        Glossary.generateElements("!@#$%^&*", charSet);
        assertEquals(8, charSet.size());
        assertTrue(charSet.contains('!'));
        assertTrue(charSet.contains('@'));
        assertTrue(charSet.contains('#'));
        assertTrue(charSet.contains('$'));
        assertTrue(charSet.contains('%'));
        assertTrue(charSet.contains('^'));
        assertTrue(charSet.contains('&'));
        assertTrue(charSet.contains('*'));
    }

    /**
     * nextWordOrSeparator test cases
     */

    //tests if the method returns the next word in a sentence given separators
    @Test
    public void testNextWordOrSeparator1() {
        String text = "The quick brown fox jumps over the lazy dog.";
        int position = 4;
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        separators.add('.');
        String output = Glossary.nextWordOrSeparator(text, position,
                separators);
        assertEquals("quick", output);
    }

    //tests if the method returns the next word given non-space separators
    @Test
    public void testNextWordOrSeparator2() {
        String text = "Hello,world!How are you?";
        int position = 6;
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        separators.add(',');
        separators.add('!');
        separators.add('?');
        String output = Glossary.nextWordOrSeparator(text, position,
                separators);
        assertEquals("world", output);
    }

    //tests if the method returns the next word given non-space separators
    @Test
    public void testNextWordOrSeparator3() {
        String text = "cat!dog#mouse@bird";
        int position = 4;
        Set<Character> separators = new Set1L<>();
        separators.add('!');
        separators.add('#');
        separators.add('@');
        String output = Glossary.nextWordOrSeparator(text, position,
                separators);
        assertEquals("dog", output);
    }

    //tests to see if the method returns the next word at the end of a sentence
    @Test
    public void testNextWordOrSeparator4() {
        String text = "This is a test";
        int position = 10;
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        String output = Glossary.nextWordOrSeparator(text, position,
                separators);
        assertEquals("test", output);
    }

    /**
     * generateTermHTML test cases
     */

    //tests to see if term HTML has proper header by checking first 6 lines
    @Test
    public void termHTMLTest1() {
        SimpleWriter out = new SimpleWriter1L(
                "test/JUnitTestCaseResults/termTest1.html");
        String testTerm = "apple";
        String testDef = "pie";
        Map<String, String> test = new Map1L<>();
        Glossary.generateTermHTML(out, testTerm, testDef, test);
        out.close();
        SimpleReader in = new SimpleReader1L(
                "test/JUnitTestCaseResults/termTest1.html");
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String line3 = in.nextLine();
        String line4 = in.nextLine();
        String line5 = in.nextLine();
        String line6 = in.nextLine();
        in.close();
        assertEquals(line1, "<!DOCTYPE html>");
        assertEquals(line2, "<html>");
        assertEquals(line3, "<head>");
        assertEquals(line4, "<title>apple</title>");
        assertEquals(line5, "</head>");
        assertEquals(line6, "<body>");
    }

    //tests to see if term HTML has proper footer by checking last 2 lines
    @Test
    public void termHTMLTest2() {
        SimpleWriter out = new SimpleWriter1L(
                "test/JUnitTestCaseResults/termTest2.html");
        String testTerm = "apple";
        String testDef = "pie";
        Map<String, String> test = new Map1L<>();
        Glossary.generateTermHTML(out, testTerm, testDef, test);
        out.close();
        SimpleReader in = new SimpleReader1L(
                "test/JUnitTestCaseResults/termTest2.html");
        String line1 = null;
        String line2 = null;
        while (!in.atEOS()) {
            String line = in.nextLine();
            if (line1 == null) {
                line1 = line;
            } else {
                line1 = line2;
                line2 = line;
            }
        }
        in.close();
        assertEquals(line1, "</body>");
        assertEquals(line2, "</html>");
    }

    //checks to see if term and definition are in body correctly
    @Test
    public void termHTMLTest3() {
        SimpleWriter out = new SimpleWriter1L(
                "test/JUnitTestCaseResults/termTest3.html");
        String testTerm = "pizza";
        String testDef = "a tasty snack that all can enjoy";
        Map<String, String> test = new Map1L<>();
        Glossary.generateTermHTML(out, testTerm, testDef, test);
        out.close();
        SimpleReader in = new SimpleReader1L(
                "test/JUnitTestCaseResults/termTest3.html");
        String line1 = null;
        String line2 = null;
        while (!in.atEOS()) {
            String line = in.nextLine();
            if (line.contains("<font color")) {
                line1 = line;
            } else if (line.contains("<blockquote>")) {
                line2 = in.nextLine();
            }
        }
        in.close();
        assertEquals(line1, "<font color=\"red\">pizza</font>");
        assertEquals(line2, "a tasty snack that all can enjoy");
    }

    //checks to see if links are replaced correctly in definition
    @Test
    public void termHTMLTest4() {
        SimpleWriter out = new SimpleWriter1L(
                "test/JUnitTestCaseResults/termTest4.html");
        String testTerm = "pizza";
        String testDef = "a tasty snack that all can enjoy";
        Map<String, String> test = new Map1L<>();
        test.add("tasty", "very good for eating");
        Glossary.generateTermHTML(out, testTerm, testDef, test);
        out.close();
        SimpleReader in = new SimpleReader1L(
                "test/JUnitTestCaseResults/termTest4.html");
        boolean condition = false;
        while (!in.atEOS()) {
            String line = in.nextLine();
            if (line.contains("<a href=\"tasty.html\">tasty</a>")) {
                condition = true;
                break;
            }
        }
        in.close();
        assertEquals(condition, true);
    }

    /**
     * generateIndexHTML test cases
     */

    //tests to see if index HTML has proper header by checking first 6 lines
    @Test
    public void indexHTMLTest1() {
        SimpleWriter out = new SimpleWriter1L(
                "test/JUnitTestCaseResults/indexTest1.html");
        Queue<String> test = new Queue1L<>();
        Glossary.generateIndexHTML(out, test);
        out.close();
        SimpleReader in = new SimpleReader1L(
                "test/JUnitTestCaseResults/indexTest1.html");
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String line3 = in.nextLine();
        String line4 = in.nextLine();
        String line5 = in.nextLine();
        String line6 = in.nextLine();
        in.close();
        assertEquals(line1, "<!DOCTYPE html>");
        assertEquals(line2, "<html>");
        assertEquals(line3, "<head>");
        assertEquals(line4, "<title>Glossary</title>");
        assertEquals(line5, "</head>");
        assertEquals(line6, "<body>");
    }

    //tests to see if index HTML has proper footer by checking last 2 lines
    @Test
    public void indexHTMLTest2() {
        SimpleWriter out = new SimpleWriter1L(
                "test/JUnitTestCaseResults/indexTest2.html");
        Queue<String> test = new Queue1L<>();
        Glossary.generateIndexHTML(out, test);
        out.close();
        SimpleReader in = new SimpleReader1L(
                "test/JUnitTestCaseResults/indexTest2.html");
        String line1 = null;
        String line2 = null;
        while (!in.atEOS()) {
            String line = in.nextLine();
            if (line1 == null) {
                line1 = line;
            } else {
                line1 = line2;
                line2 = line;
            }
        }
        in.close();
        assertEquals(line1, "</body>");
        assertEquals(line2, "</html>");
    }

    //checks to ensure all desired terms are in index
    @Test
    public void indexHTMLTest3() {
        SimpleWriter out = new SimpleWriter1L(
                "test/JUnitTestCaseResults/indexTest3.html");
        Queue<String> test = new Queue1L<>();
        test.enqueue("pizza");
        test.enqueue("subs");
        test.enqueue("wings");
        test.enqueue("breadsticks");
        Glossary.generateIndexHTML(out, test);
        out.close();
        SimpleReader in = new SimpleReader1L(
                "test/JUnitTestCaseResults/indexTest3.html");
        Boolean hasPizza = false;
        Boolean hasSubs = false;
        Boolean hasWings = false;
        Boolean hasBreadsticks = false;
        while (!in.atEOS()) {
            String line = in.nextLine();
            if (line.contains("pizza")) {
                hasPizza = true;
            }
            if (line.contains("subs")) {
                hasSubs = true;
            }
            if (line.contains("wings")) {
                hasWings = true;
            }
            if (line.contains("breadsticks")) {
                hasBreadsticks = true;
            }
        }
        in.close();
        assertEquals(hasPizza, true);
        assertEquals(hasSubs, true);
        assertEquals(hasWings, true);
        assertEquals(hasBreadsticks, true);
    }

    //checks to see if links are correctly formatted in index
    @Test
    public void indexHTMLTest4() {
        SimpleWriter out = new SimpleWriter1L(
                "test/JUnitTestCaseResults/indexTest3.html");
        Queue<String> test = new Queue1L<>();
        test.enqueue("pizza");
        test.enqueue("subs");
        test.enqueue("wings");
        test.enqueue("breadsticks");
        Glossary.generateIndexHTML(out, test);
        out.close();
        SimpleReader in = new SimpleReader1L(
                "test/JUnitTestCaseResults/indexTest3.html");
        String line1 = null;
        String line2 = null;
        String line3 = null;
        String line4 = null;
        while (!in.atEOS()) {
            String line = in.nextLine();
            if (line.contains("pizza")) {
                line1 = line;
            }
            if (line.contains("subs")) {
                line2 = line;
            }
            if (line.contains("wings")) {
                line3 = line;
            }
            if (line.contains("breadsticks")) {
                line4 = line;
            }
        }
        in.close();
        assertEquals(line1, "<a href=\"pizza.html\">pizza</a>");
        assertEquals(line2, "<a href=\"subs.html\">subs</a>");
        assertEquals(line3, "<a href=\"wings.html\">wings</a>");
        assertEquals(line4, "<a href=\"breadsticks.html\">breadsticks</a>");
    }
}
