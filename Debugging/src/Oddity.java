import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public final class Oddity {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Oddity() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        final int[] values = { 8, -4, 3, 0, -5 };
        int i = 0;
        while (i < values.length) {
            int remainder = values[i] % 2;
            if (remainder == 1) {
                out.println("odd");
            } else {
                out.println("even");
            }
            i = i + 1;
        }
        out.close();
    }
}
