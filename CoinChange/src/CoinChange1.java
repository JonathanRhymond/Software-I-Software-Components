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
public final class CoinChange1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CoinChange1() {
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

        int total = 0;
        int dollars = 0;
        int halfDollars = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        out.print("Please enter an amount of cents: ");
        total = in.nextInteger();
        out.println("");

        dollars = total / 100;
        total -= (dollars * 100);
        halfDollars = total / 50;
        total -= (halfDollars * 50);
        quarters = total / 25;
        total -= (quarters * 25);
        dimes = total / 10;
        total -= (dimes * 10);
        nickels = total / 5;
        total -= (nickels * 5);
        pennies = total;

        out.println("Dollars: " + dollars);
        out.println("Half Dollars: " + halfDollars);
        out.println("Quarters: " + quarters);
        out.println("Dimes: " + dimes);
        out.println("Nickels: " + nickels);
        out.println("Pennies: " + pennies);
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
