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
public final class Newton1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton1() {
    }

    /*
     * Method for square root via Newton Iteration
     */
    private static double sqrt(double x) {
        double r = x;
        r = (r + (x / r)) / 2;
        while (Math.abs((r * r - x) / x) > 0.0001 * 0.0001) {
            r = (r + (x / r)) / 2;
        }
        return r;
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
        /*
         * Initalize variables
         */
        double input = 0.0;
        double ans = 0.0;
        /*
         * Put your main program code here
         */
        out.println("Do you wish to calculate another square root?");
        out.println("Press y to begin: ");
        String start = in.nextLine();
        if (start.equals("y")) {
            out.println("Please enter a number: ");
            input = in.nextDouble();
            ans = sqrt(input);
            if (input == 0.0) {
                out.println("Error: This program cannot calculate for 0.0");
            } else {
                out.println("The square root of " + input + " is " + ans + ".");
            }
        } else {
            out.println("Okay Goodbye");
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
