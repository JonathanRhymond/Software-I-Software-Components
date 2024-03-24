import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        //initialize return value and values for math operations
        NaturalNumber result = new NaturalNumber2();
        NaturalNumber leftValue = new NaturalNumber2();
        NaturalNumber rightValue = new NaturalNumber2();
        NaturalNumber tempValue = new NaturalNumber2();
        NaturalNumber zero = new NaturalNumber2(0);

        if (exp.label().equals("plus")) {
            //set values for operation
            leftValue.copyFrom(evaluate(exp.child(0)));
            rightValue.copyFrom(evaluate(exp.child(1)));

            //perform operation and return
            tempValue.copyFrom(leftValue);
            tempValue.add(rightValue);
            result.copyFrom(tempValue);

        } else if (exp.label().equals("minus")) {
            //set values for operation
            leftValue.copyFrom(evaluate(exp.child(0)));
            rightValue.copyFrom(evaluate(exp.child(1)));

            //error message for invalid input
            if (rightValue.compareTo(leftValue) > 0) {
                Reporter.fatalErrorToConsole(
                        "Error: input involves negative numbers");
            }

            //perform operation and return
            tempValue.copyFrom(leftValue);
            tempValue.subtract(rightValue);
            result.copyFrom(tempValue);

        } else if (exp.label().equals("times")) {
            //set values for operation
            leftValue.copyFrom(evaluate(exp.child(0)));
            rightValue.copyFrom(evaluate(exp.child(1)));

            //perform operation and return
            tempValue.copyFrom(leftValue);
            tempValue.multiply(rightValue);
            result.copyFrom(tempValue);

        } else if (exp.label().equals("divide")) {
            //set values for operation
            leftValue.copyFrom(evaluate(exp.child(0)));
            rightValue.copyFrom(evaluate(exp.child(1)));

            //error message for invalid input
            if (rightValue.compareTo(zero) == 0) {
                Reporter.fatalErrorToConsole(
                        "Error: input involves division by 0");
            }

            //perform operation and return
            tempValue.copyFrom(leftValue);
            tempValue.divide(rightValue);
            result.copyFrom(tempValue);

        } else if (exp.hasAttribute("value")) {
            //sets value from attribute
            //NOTE: Proper formatting is guaranteed so no checking is required
            result.setFromString(exp.attributeValue("value"));

        } else {
            //if nothing else tree must be formatted incorrectly
            Reporter.fatalErrorToConsole("Error: Incorrect input formatting");

        }

        //clear NaturalNumbers
        leftValue.clear();
        rightValue.clear();
        tempValue.clear();

        //return result
        return result;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
