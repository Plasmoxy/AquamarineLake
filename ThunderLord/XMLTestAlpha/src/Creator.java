import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Creator
{


    public static void main(String[] args) throws Exception
    {
        // factories
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
        TransformerFactory tfactory = TransformerFactory.newInstance();
        Transformer transformer = tfactory.newTransformer();
        
        // turn on indentation
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        
        Document doc = dbuilder.newDocument();
        
        // categories
        Element root = doc.createElement("database");
        doc.appendChild(root);
        
        Element books = doc.createElement("books");
        root.appendChild(books);
        
        Element persons = doc.createElement("persons");
        root.appendChild(persons);
        
        //---
        
        Element b, p;
        
        b = doc.createElement("book");
        books.appendChild(b);
        b.setAttribute("id", "600");
        b.setAttribute("name", "XDDD");

        b = doc.createElement("book");
        books.appendChild(b);
        b.setAttribute("id", "663");
        b.setAttribute("name", "LOL");
        
        p = doc.createElement("person");
        persons.appendChild(p);
        p.setAttribute("id", "sebastianpetrik");
        p.setAttribute("name", "Sebastián Petrík");

        DOMSource src = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("creatt.xml"));
        transformer.transform(src, result);
        
    }
}
