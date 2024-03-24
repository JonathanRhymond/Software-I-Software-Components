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
public final class HelloJack {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HelloJack() {
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
         * Put your main program code here
         */
        out.println("Hello, what is your name?: ");
        String name = in.nextLine();
        out.println("Hello, " + name);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
