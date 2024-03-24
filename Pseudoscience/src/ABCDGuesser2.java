import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ABCDGuesser2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ABCDGuesser2() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        out.print("Please enter a positive number: ");
        String input = in.nextLine();
        out.println("");
        double doublein = 0.0;
        if (FormatChecker.canParseDouble(input)
                && Double.parseDouble(input) > 0.0) {
            doublein = Double.parseDouble(input);
        } else {
            while (FormatChecker.canParseDouble(input) == false
                    || Double.parseDouble(input) <= 0.0) {
                out.println("Error: Input is invalid!");
                out.print("Please enter a positive number: ");
                input = in.nextLine();
                out.println("");
            }
            doublein = Double.parseDouble(input);
        }
        return doublein;
    }

    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        out.print("Please enter a positive number that is not one: ");
        String input = in.nextLine();
        out.println("");
        double doublein = 0.0;
        if (FormatChecker.canParseDouble(input)
                && Double.parseDouble(input) != 1.0
                && Double.parseDouble(input) >= 0.0) {
            doublein = Double.parseDouble(input);
        } else {
            while (FormatChecker.canParseDouble(input) == false
                    || (Double.parseDouble(input) == 1.0)
                    || Double.parseDouble(input) <= 0.0) {
                out.println("Error: Input is invalid!");
                out.print("Please enter a positive number that is not one: ");
                input = in.nextLine();
                out.println("");
            }
            doublein = Double.parseDouble(input);
        }
        return doublein;
    }

    private static double getRelErr(double cEst, double cnst) {
        return (Math.abs(cEst - cnst) / cnst);
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

        //Initialize all standard variables for program
        double[] jagNums = { -5, -4, -3, -2, -1, (-1 / 2), (-1 / 3), (-1 / 4),
                0, (1 / 4), (1 / 3), (1 / 2), 1, 2, 3, 4, 5 };
        double a = jagNums[0], b = jagNums[0], c = jagNums[0], d = jagNums[0];
        double closestEstimate = 0, error = 0.0, estimate = 0.0;

        //Get input for constant
        out.println("Enter the value of the constant to aproximate - ");
        double constant = getPositiveDouble(in, out);

        //Get 4 personal numbers
        out.println("Enter personal number 1 - ");
        double w = getPositiveDoubleNotOne(in, out);
        out.println("Enter personal number 2 - ");
        double x = getPositiveDoubleNotOne(in, out);
        out.println("Enter personal number 3 - ");
        double y = getPositiveDoubleNotOne(in, out);
        out.println("Enter personal number 4 - ");
        double z = getPositiveDoubleNotOne(in, out);

        //Nested loops to check every exponent combo
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                for (int k = 0; k < 17; k++) {
                    for (int l = 0; l < 17; l++) {
                        //calculate estimate
                        estimate = Math.pow(w, jagNums[i])
                                * Math.pow(x, jagNums[j])
                                * Math.pow(y, jagNums[k])
                                * Math.pow(z, jagNums[l]);
                        error = Math.abs(estimate - constant) / constant;
                        if (Math.abs(constant - estimate) < Math
                                .abs(constant - closestEstimate)) {
                            closestEstimate = estimate;
                            a = jagNums[i];
                            b = jagNums[j];
                            c = jagNums[k];
                            d = jagNums[l];
                        }
                    }
                }
            }
        }

        //Prints results
        out.println("Results below: ");
        out.println("");

        //Give exponents that give minimum error
        out.println("Exponents with minimum error:");
        out.print("a: " + a + ", ");
        out.print("b: " + b + ", ");
        out.print("c: " + c + ", ");
        out.print("d: " + d + ".");
        out.println("");

        //Give approximation of number by program and relative error
        out.print("These numbers give an approximation of: ");
        out.println(closestEstimate);
        out.print("With a relative error of: ");
        out.println(getRelErr(closestEstimate, constant));

        //Close input and output streams
        in.close();
        out.close();
    }

}
