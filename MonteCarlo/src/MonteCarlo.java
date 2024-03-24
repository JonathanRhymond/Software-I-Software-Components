import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: compute percentage of pseudo-random points in [0.0,1.0)
 * interval that fall in the left half subinterval [0.0,0.5).
 */
public final class MonteCarlo {

    /**
     * Private constructor so this utility class cannot be instantiated.
     *
     * private MonteCarlo() { }
     * 
     * /** Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        /*
         * Open input and output streams
         */
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        /*
         * Declare counters and initialize them
         */
        double totalCount = 0;
        double circleCount = 0;
        double distance = 0;
        /*
         * Create pseudo-random number generator
         */
        Random rnd = new Random1L();
        /*
         * Generate points and count how many fall in [0.0,0.5) interval
         */
        while (totalCount < 1000000) {
            /*
             * Generate pseudo-random number in [0.0,1.0) interval
             */
            double x = rnd.nextDouble() * 2;
            double y = rnd.nextDouble() * 2;
            /*
             * Increment total number of generated points
             */
            totalCount++;
            /*
             * Increment total number of points in circle
             */
            distance = Math.sqrt((Math.pow(x - 1, 2)) + (Math.pow(y - 1, 2)));
            if (distance < 1.0) {
                circleCount++;
            }
        }
        /*
         * Estimate percentage of points generated in [0.0,1.0) interval that
         * fall in the [0.0,0.5) subinterval
         */
        output.println("Estimate of cirlce area: " + circleCount / totalCount);
        /*
         * Close input and output streams
         */
        input.close();
        output.close();
    }

}