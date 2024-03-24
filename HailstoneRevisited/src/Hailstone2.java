import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
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
public final class Hailstone2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone2() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void generateSeries(NaturalNumber n, SimpleWriter out) {
        /*
         * Put your code for myMethod here
         */
        NaturalNumber nCopy = new NaturalNumber2(n);
        NaturalNumber one = new NaturalNumber2(1);
        NaturalNumber two = new NaturalNumber2(2);
        NaturalNumber three = new NaturalNumber2(3);
        int count = 0;

        while (nCopy.compareTo(one) != 0) {
            NaturalNumber remainder = nCopy.divide(two);
            nCopy.multiply(two);
            nCopy.add(remainder);

            if (remainder.isZero()) {
                //even
                nCopy.divide(two);
            } else {
                //odd
                nCopy.multiply(three);
                nCopy.add(one);
            }
            out.println(nCopy);
            count++;
        }
        out.print("The length of the series is: ");
        out.println(count);
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
        out.print("Enter a starting number: ");
        int input = in.nextInteger();

        NaturalNumber start = new NaturalNumber2(input);
        NaturalNumber copyStart = new NaturalNumber2(start);

        generateSeries(start, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
