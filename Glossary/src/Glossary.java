import java.util.Comparator;

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

/**
 * Glossary of items in HTML format
 *
 * @author J. Rhymond
 */
public final class Glossary {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Glossary() {
        // no code needed here
    }

    //comparator for queue
    public static class AlphabeticalComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    }

    //method to separate given string into set of characters
    public static void generateElements(String str, Set<Character> charSet) {
        assert str != null : "Violation of: str is not null";
        assert charSet != null : "Violation of: charSet is not null";

        charSet.clear();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!charSet.contains(c)) {
                charSet.add(c);
            }
        }
    }

    //method to return first word or separator starting at given position
    public static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        assert text != null : "Violation of: text is not null";
        assert separators != null : "Violation of: separators is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";

        String output = "";
        int count = 0;
        char returned = 'b';

        if (separators.contains(text.charAt(position))) {
            while (count < text.substring(position, text.length()).length()) {
                returned = text.charAt(position + count);
                if (separators.contains(text.charAt(position + count))) {
                    output += returned;
                    count++;
                } else {
                    count = text.substring(position, text.length()).length();
                }
            }
            count = 0;
        } else {
            while (count < text.substring(position, text.length()).length()) {
                returned = text.charAt(position + count);
                if (!separators.contains(text.charAt(position + count))) {
                    output += returned;
                    count++;
                } else {
                    count = text.substring(position, text.length()).length();
                }
            }
        }
        return output;
    }

    //method to create generic HTML header
    public static void generateHTMLHeader(SimpleWriter out, String title) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body>");
    }

    //method to create generic HTML footer
    public static void generateHTMLFooter(SimpleWriter out) {
        out.println("</body>");
        out.println("</html>");
    }

    //method to create term HTML taking in currentTerm and currentDefinition
    public static void generateTermHTML(SimpleWriter out, String currentTerm,
            String currentDefinition, Map<String, String> termAndDefinition) {
        //preparation for link replacement in definition
        final String seperatorStr = " \t, ";
        Set<Character> seperatorSet = new Set1L<>();
        generateElements(seperatorStr, seperatorSet);

        //generate HTML header
        generateHTMLHeader(out, currentTerm);
        //starts generating HTML body
        out.println("<h2>");
        out.println("<b>");
        out.println("<i>");
        out.print("<font color=\"red\">");
        out.print(currentTerm);
        out.println("</font>");
        out.println("</i>");
        out.println("</b>");
        out.println("</h2>");
        out.println("<blockquote>");
        //generates definition with correct links
        int index = 0;
        while (index < currentDefinition.length()) {
            String def = nextWordOrSeparator(currentDefinition, index,
                    seperatorSet);
            index += def.length();
            if (termAndDefinition.hasKey(def)) {
                out.print("<a href=\"" + def + ".html\">" + def + "</a>");
            } else {
                out.print(def);
            }
        }
        out.println();
        //finishes generating HTML body
        out.println("</blockquote>");
        out.println("<hr>");
        out.println("<p>");
        out.println("return to");
        out.println("<a href = \"index.html\">index</a>");
        out.println("</p>");

        //generate HTML footer
        generateHTMLFooter(out);
    }

    //method to create index HTML
    public static void generateIndexHTML(SimpleWriter out,
            Queue<String> termsList) {
        //sort queue alphabetically using AlphabeticalComparator comparator
        Comparator<String> comparator = new AlphabeticalComparator();
        termsList.sort(comparator);

        //generate HTML header
        generateHTMLHeader(out, "Glossary");

        //generate HTML body
        out.println("<h2>Glossary</h2>");
        out.println("<hr>");
        out.println("<h3>Index</h3>");
        out.println("<ul>");
        for (String term : termsList) {
            out.println("<li>");
            out.println("<a href=\"" + term + ".html\">" + term + "</a>");
            out.println("</li>");
            out.println("<br>");
        }
        out.println("<ul>");

        //generate HTML footer
        generateHTMLFooter(out);
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();

        //requests information from user on input file and save location
        out.print("Enter the name of the input file: ");
        String input = in.nextLine();
        out.println();
        out.print("Enter the name of the save location: ");
        String saveLocation = in.nextLine();
        out.println();

        //create SimpleReader for input file
        SimpleReader fileReader = new SimpleReader1L(input);

        //create map to store terms and definitions
        Map<String, String> glossaryMap = new Map1L<>();

        //creates queue to store just terms (easier for comparator)
        Queue<String> termsList = new Queue1L<>();

        //while loop to iterate through input and add to map
        String currentTerm = null;
        String currentDefinition = null;
        while (!fileReader.atEOS()) {
            String currentLine = fileReader.nextLine();

            //checks what current line is and performs responding task
            if (!currentLine.isEmpty()) {
                if (currentTerm == null) {
                    currentTerm = currentLine;
                } else if (currentDefinition == null) {
                    currentDefinition = currentLine;
                } else {
                    currentDefinition += " " + currentLine;
                }
            } else {
                if (currentTerm != null && currentDefinition != null) {
                    glossaryMap.add(currentTerm, currentDefinition);
                    termsList.enqueue(currentTerm);
                }
                currentTerm = null;
                currentDefinition = null;
            }
        }

        //call method to generate HTMLs with while loop through term set
        for (Map.Pair<String, String> termAndDefinition : glossaryMap) {
            String HTMLTerm = termAndDefinition.key();
            String HTMLDefinition = termAndDefinition.value();

            //create local SimpleWriter for specific term
            SimpleWriter pageWriter = new SimpleWriter1L(
                    saveLocation + "/" + HTMLTerm + ".html");

            //runs generateTermHTMLs under current term and definition pair
            generateTermHTML(pageWriter, HTMLTerm, HTMLDefinition, glossaryMap);

            //close local SimpleWriter
            pageWriter.close();
        }
        //generate index HTML using method with SimpleWriter in given location
        SimpleWriter indexHTMLWriter = new SimpleWriter1L(
                saveLocation + "/index.html");
        generateIndexHTML(indexHTMLWriter, termsList);

        //close input and output streams
        indexHTMLWriter.close();
        fileReader.close();
        out.close();
        in.close();
    }
}
