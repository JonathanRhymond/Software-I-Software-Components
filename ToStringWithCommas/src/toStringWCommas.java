import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public final class toStringWCommas {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private toStringWCommas() {
        // no code needed here
    }

    public static String toStringWithCommas(NaturalNumber n) {
        String result = "";
        NaturalNumber thousand = new NaturalNumber2(1000);
        if (n.compareTo(thousand) >= 0) {
            int digit1 = n.divideBy10();
            int digit2 = n.divideBy10();
            int digit3 = n.divideBy10();
            result = toStringWithCommas(n);
            result = result + "," + digit3 + digit2 + digit1;
            n.multiplyBy10(digit1);
            n.multiplyBy10(digit2);
            n.multiplyBy10(digit3);
        } else {
            result = n.toString();
        }
        return result;
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

        NaturalNumber n = new NaturalNumber2(in.nextLine());
        out.println(toStringWithCommas(n));

        out.close();
        in.close();
    }

}
