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
public final class Newton4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton4() {
    }

    /*
     * Method for square root via Newton Iteration
     */
    private static double sqrt(double x, double e) {
        double r = x;
        r = (r + (x / r)) / 2;
        while (Math.abs((r * r - x) / x) > e * e) {
            r = (r + (x / r)) / 2;
        }
        if (x == 0.0) {
            return 0.0;
        } else {
            return r;
        }
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
        double error = 0.0;
        /*
         * Put your main program code here
         */
        out.println("Please enter a number:");
        input = in.nextDouble();
        if (input > 0.0) {
            out.println("Enter the desired relative error as a percent:");
            error = in.nextDouble();
            ans = sqrt(input, error / 100);
            out.println("The square root of " + input + " is " + ans + ".");
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
