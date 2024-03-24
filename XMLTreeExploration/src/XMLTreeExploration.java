import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeExploration {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private XMLTreeExploration() {
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
        XMLTree xml = new XMLTree1(
                "http://web.cse.ohio-state.edu/software/2221/web-sw1/extras/instructions/xmltree-model/columbus-weather.xml");

        //out.println(xml.toString());
        xml.display();

        if (xml.isTag()) {
            out.print("The root of XMLTree is a tag, ");
            out.println("the tag is: " + xml.label());
        } else {
            out.print("The root of XMLTree is text, ");
            out.println("the text is: " + xml.label());
        }

        XMLTree results = xml.child(0);
        XMLTree channel = results.child(0);
        out.println(channel.numberOfChildren());
        XMLTree title = channel.child(1);
        XMLTree titleText = title.child(0);
        out.println(titleText.label());

        XMLTree astronomy = xml.child(0).child(0).child(10);
        out.println(astronomy.toString());
        if (astronomy.hasAttribute("sunset")) {
            out.println("Astronomy has attribute sunset");
        } else {
            out.println("Astronomy does not have attribute sunset");
        }
        if (astronomy.hasAttribute("midday")) {
            out.println("Astronomy has attribute midday");
        } else {
            out.println("Astronomy does not have attribute midday");
        }
        if (astronomy.hasAttribute("sunrise")) {
            out.println(astronomy.attributeValue("sunrise"));
        }
        if (astronomy.hasAttribute("sunset")) {
            out.println(astronomy.attributeValue("sunset"));
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
