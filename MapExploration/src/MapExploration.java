import components.map.Map;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public final class MapExploration {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private MapExploration() {
        // no code needed here
    }

    /**
     * Inputs a "menu" of words (items) and their prices from the given file and
     * stores them in the given {@code Map}.
     *
     * @param fileName
     *            the name of the input file
     * @param priceMap
     *            the word -> price map
     * @replaces priceMap
     * @requires <pre>
     * [file named fileName exists but is not open, and has the
     *  format of one "word" (unique in the file) and one price (in cents)
     *  per line, with word and price separated by ','; the "word" may
     *  contain whitespace but no ',']
     * </pre>
     * @ensures [priceMap contains word -> price mapping from file fileName]
     */
    private static void getPriceMap(String fileName,
            Map<String, Integer> priceMap) {
        SimpleReader fileReader = new SimpleReader1L(fileName);
        while (!fileReader.atEOS()) {
            String line = fileReader.nextLine();
            int commaIndex = line.indexOf(',');
            if (commaIndex >= 0) {
                String word = line.substring(0, commaIndex);
                Integer price = Integer.valueOf(line.substring(commaIndex + 1));
                priceMap.add(word, price);
            }
        }
        fileReader.close();
    }

    /**
     * Input one pizza order and compute and return the total price.
     *
     * @param input
     *            the input stream
     * @param sizePriceMap
     *            the size -> price map
     * @param toppingPriceMap
     *            the topping -> price map
     * @return the total price (in cents)
     * @updates input
     * @requires <pre>
     * input.is_open and
     * [input.content begins with a pizza order consisting of a size
     *  (something defined in sizePriceMap) on the first line, followed
     *  by zero or more toppings (something defined in toppingPriceMap)
     *  each on a separate line, followed by an empty line]
     * </pre>
     * @ensures <pre>
     * input.is_open and
     * #input.content = [one pizza order (as described
     *              in the requires clause)] * input.content and
     * getOneOrder = [total price (in cents) of that pizza order]
     * </pre>
     */
    private static int getOneOrder(SimpleReader input,
            Map<String, Integer> sizePriceMap,
            Map<String, Integer> toppingPriceMap) {
        int total = 0;
        boolean sizeFound = false;
        String size = "";
        while (!input.atEOS()) {
            String line = input.nextLine();
            if (line.isEmpty()) {
                break;
            }
            if (!sizeFound) {
                if (sizePriceMap.hasKey(line)) {
                    sizeFound = true;
                    size = line;
                    total = sizePriceMap.value(size);
                }
            } else {
                if (toppingPriceMap.hasKey(line)) {
                    total = total + toppingPriceMap.value(line);
                }
            }
        }
        return total;
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
        out.close();
        in.close();
    }

}
