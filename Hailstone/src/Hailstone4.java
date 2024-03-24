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
public final class Hailstone4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone4() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void generateSeries(int n, SimpleWriter out) {
        /*
         * Put your code for myMethod here
         */
        int i = 0;
        int max = 0;
        while (n != 1) {
            if (n == 0) {
                out.println("Error: Zero will not execute");
            } else if (n % 2 != 0) {
                n = (3 * n) + 1;
            } else {
                n = n / 2;
            }
            out.println(n);
            i++;
            if (n > max) {
                max = n;
            }
        }
        out.println("");
        out.println("The length of this sequence was " + i + ".");
        out.println("The maximum value in this sequence was " + max + ".");
        out.println("");
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
         * Put your main program code here; it may call myMethod as shown
         */
        String begin = "y";
        while (begin.equals("y")) {
            out.println("Would you like to calculate another series?");
            out.println("Press y to begin: ");
            begin = in.nextLine();
            if (begin.equals("y")) {
                out.println("Enter a starting integer: ");
                out.println("");
                int start = in.nextInteger();
                generateSeries(start, out);
            }
        }
        out.println("Goodbye");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

    private static void generateSeries(int start) {
        // TODO Auto-generated method stub

    }

}
