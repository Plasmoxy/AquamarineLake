import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class MyStuff
{
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException
    {
        File file = new File("idk.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc=  dBuilder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList books = doc.getElementsByTagName("book");
        
        for (int i = 0; i < books.getLength(); i++)
        {
            Node node = books.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) continue;
            Element e = (Element) node;

            System.out.println("--BOOK--");
            System.out.println("id = " + e.getAttribute("id"));
            System.out.println("name = " + e.getAttribute("name"));
            System.out.println("author = " + e.getAttribute("author"));
            System.out.println("taker = " + e.getAttribute("taker"));
            System.out.println();
        }
    }
}
