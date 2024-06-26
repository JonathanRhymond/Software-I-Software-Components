import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class CoinChange2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CoinChange2() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        String denomNames[] = { "Dollars", "Half Dollars", "Quarters", "Dimes",
                "Nickels", "Pennies" };
        int denoms[] = { 100, 50, 25, 10, 5, 1 };
        int results[] = new int[denoms.length];

        out.print("Please enter an amount of cents: ");
        int total = in.nextInteger();
        out.println("");

        for (int i = 0; i <= denoms.length - 1; i++) {
            results[i] = total / denoms[i];
            total -= (results[i] * denoms[i]);
            out.println(denomNames[i] + ": " + results[i]);
        }
        /*
         * Put your main program code here
         */
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
