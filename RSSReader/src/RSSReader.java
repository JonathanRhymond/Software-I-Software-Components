import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to convert an XML RSS (version 2.0) feed from a given URL into the
 * corresponding HTML output file.
 *
 * @author Put your name here
 *
 */
public final class RSSReader {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private RSSReader() {
    }

    /**
     * Outputs the "opening" tags in the generated HTML file. These are the
     * expected elements generated by this method:
     *
     * <html> <head> <title>the channel tag title as the page title</title>
     * </head> <body>
     * <h1>the page title inside a link to the <channel> link</h1>
     * <p>
     * the channel description
     * </p>
     * <table border="1">
     * <tr>
     * <th>Date</th>
     * <th>Source</th>
     * <th>News</th>
     * </tr>
     *
     * @param channel
     *            the channel element XMLTree
     * @param out
     *            the output stream
     * @updates out.content
     * @requires [the root of channel is a <channel> tag] and out.is_open
     * @ensures out.content = #out.content * [the HTML "opening" tags]
     */
    private static void outputHeader(XMLTree channel, SimpleWriter out) {
        assert channel != null : "Violation of: channel is not null";
        assert out != null : "Violation of: out is not null";
        assert channel.isTag() && channel.label().equals("channel") : ""
                + "Violation of: the label root of channel is a <channel> tag";
        assert out.isOpen() : "Violation of: out.is_open";
        /*
         * TODO: fill in body
         */

        //Default values for title and description and pull link from table
        String title = "Empty Title";
        String link = channel.child(1).child(0).label();
        String description = "No description";

        //Replaces title and/or description if values exist
        if (channel.child(0).numberOfChildren() >= 0) {
            title = channel.child(0).child(0).label();
        }
        if (channel.child(2).numberOfChildren() >= 0) {
            description = channel.child(2).child(0).label();
        }

        //prints the header using values from tree and html formatting
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + title + "<title>");
        out.println("<head>");
        out.println("<body> = \"$0\"");
        out.println("<h1>");
        out.println("<a href=\"" + link + "\">" + title + "<a>");
        out.println("<h1>");
        out.println("<p>");
        out.println("\"" + description + "\"");
        out.println("<p>");
    }

    /**
     * Outputs the "closing" tags in the generated HTML file. These are the
     * expected elements generated by this method:
     *
     * </table>
     * </body> </html>
     *
     * @param out
     *            the output stream
     * @updates out.contents
     * @requires out.is_open
     * @ensures out.content = #out.content * [the HTML "closing" tags]
     */
    private static void outputFooter(SimpleWriter out) {
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";

        /*
         * TODO: fill in body
         */
        out.println("<body>");
        out.println("<html>");
    }

    /**
     * Finds the first occurrence of the given tag among the children of the
     * given {@code XMLTree} and return its index; returns -1 if not found.
     *
     * @param xml
     *            the {@code XMLTree} to search
     * @param tag
     *            the tag to look for
     * @return the index of the first child of type tag of the {@code XMLTree}
     *         or -1 if not found
     * @requires [the label of the root of xml is a tag]
     * @ensures <pre>
     * getChildElement =
     *  [the index of the first child of type tag of the {@code XMLTree} or
     *   -1 if not found]
     * </pre>
     */
    private static int getChildElement(XMLTree xml, String tag) {
        assert xml != null : "Violation of: xml is not null";
        assert tag != null : "Violation of: tag is not null";
        assert xml.isTag() : "Violation of: the label root of xml is a tag";
        /*
         * TODO: fill in body
         */
        int elnum = -1;
        //xml.display();
        for (int i = xml.numberOfChildren() - 1; i >= 0; i--) {
            if (xml.child(i).label().equals(tag)) {
                elnum = i;
            }
        }
        return elnum;
    }

    /**
     * Processes one news item and outputs one table row. The row contains three
     * elements: the publication date, the source, and the title (or
     * description) of the item.
     *
     * @param item
     *            the news item
     * @param out
     *            the output stream
     * @updates out.content
     * @requires [the label of the root of item is an <item> tag] and
     *           out.is_open
     * @ensures <pre>
     * out.content = #out.content *
     *   [an HTML table row with publication date, source, and title of news item]
     * </pre>
     */
    private static void processItem(XMLTree item, SimpleWriter out) {
        assert item != null : "Violation of: item is not null";
        assert out != null : "Violation of: out is not null";
        assert item.isTag() && item.label().equals("item") : ""
                + "Violation of: the label root of item is an <item> tag";
        assert out.isOpen() : "Violation of: out.is_open";

        /*
         * TODO: fill in body
         */

        //gets index values for each
        int dateIndex = getChildElement(item, "pubDate");
        int sourceIndex = getChildElement(item, "source");
        int newsIndex = getChildElement(item, "title");
        int linkIndex = getChildElement(item, "link");

        //get strings
        String date = "No date found";
        String source = "No source found";
        String news = "No news found";
        String link = "No link found";

        //checks if index exists based on return values
        //sets String to correct value or default value
        if (dateIndex != -1) {
            date = item.child(dateIndex).child(0).label();
        }
        if (sourceIndex != -1) {
            source = item.child(sourceIndex).child(0).label();
        }
        if (dateIndex != -1) {
            news = item.child(newsIndex).child(0).label();
        }
        if (linkIndex != -1) {
            link = item.child(linkIndex).child(0).label();
        }

        //table row header
        out.println("<tr>");

        //Date
        out.println("<td>" + date + "</td>");
        //Source
        out.println("<td>" + source + "</td>");
        //News
        out.println("<td>");
        out.println("<a href=\"" + link + "\">" + news + "<a>");
        out.println("</td>");

        //table row closer
        out.println("<tr>");
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        /*
         * TODO: fill in body
         */
        out.print("Enter the URL of an RSS feed: ");
        String url = in.nextLine();

        XMLTree rssTree = new XMLTree1(url);

        if (rssTree.hasAttribute("version")
                && rssTree.attributeValue("version").equals("2.0")) {
            out.println("Valid RSS Feed");
        } else {
            out.println("Invalid RSS Feed");
            while ((rssTree.hasAttribute("version") && rssTree
                    .attributeValue("version").equals("2.0")) == false) {
                out.print("Enter the URL of an RSS feed: ");
                url = in.nextLine();
                out.println();
                if (rssTree.hasAttribute("version")
                        && rssTree.attributeValue("version").equals("2.0")) {
                    out.println("Valid RSS Feed");
                } else {
                    out.println("Invalid RSS Feed");
                }
            }

        }

        out.println();
        out.print(
                "Enter the name of a html file for output (DO NOT include .html): ");
        String fileName = in.nextLine();
        out.println();
        SimpleWriter fileOut = new SimpleWriter1L(fileName + ".html");

        //header
        outputHeader(rssTree.child(0), fileOut);

        //table header
        fileOut.println("<table border=\"1\">");
        fileOut.println("<tbody>");
        fileOut.println("<tr>");
        fileOut.println("<th>Date<th>");
        fileOut.println("<th>Source<th>");
        fileOut.println("<th>News<th>");
        fileOut.println("<tr>");

        //loop for main table body
        for (int i = 0; i < rssTree.child(0).numberOfChildren(); i++) {
            if (rssTree.child(0).child(i).label().equals("item")) {
                processItem(rssTree.child(0).child(i), fileOut);
            }
        }

        //close table
        fileOut.println("<tbody>");
        fileOut.println("<table>");

        //footer
        outputFooter(fileOut);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
        fileOut.close();
    }

}