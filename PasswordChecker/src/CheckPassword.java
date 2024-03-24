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
public final class CheckPassword {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CheckPassword() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void checkPassword(String passwordCanidate,
            SimpleWriter out) {
        boolean length = checkPasswordLength(passwordCanidate);
        boolean upperCase = containsUpperCaseLetter(passwordCanidate);
        boolean lowerCase = containsLowerCaseLetter(passwordCanidate);
        boolean digit = containsDigit(passwordCanidate);
        int i = 0;
        if (upperCase) {
            i++;
        }
        if (lowerCase) {
            i++;
        }
        if (digit) {
            i++;
        }
        if (i >= 2 && length) {
            out.println("Your Password is Valid!");
        }
    }

    private static boolean checkPasswordLength(String passwordCanidate) {
        if (passwordCanidate.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean containsUpperCaseLetter(String passwordCanidate) {
        for (int i = 0; i < passwordCanidate.length() - 1; i++) {
            char currentChar = passwordCanidate.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLowerCaseLetter(String passwordCanidate) {
        for (int i = 0; i < passwordCanidate.length() - 1; i++) {
            char currentChar = passwordCanidate.charAt(i);
            if (Character.isLowerCase(currentChar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsDigit(String passwordCanidate) {
        for (int i = 0; i < passwordCanidate.length() - 1; i++) {
            char currentChar = passwordCanidate.charAt(i);
            if (Character.isDigit(currentChar)) {
                return true;
            }
        }
        return false;
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
        out.print("Enter a password to test: ");
        String password = in.nextLine();
        out.println("");
        checkPassword(password, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
