package utils;

/**
 * @Author Alexander Olsson
 */

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

public class XMLparser {

    /**
     * Metod för att läsa innehåll i XML-fil.
     * @param file filnamn att läsa.
     * @param id hämtar ut innehåll beroende på id.
     * @return innehåll i element "target".
     */
    public String parse(String file, int id){

        String result = "";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(file));
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("trans-unit");

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                if(node.getAttributes().getNamedItem("id").getTextContent().equals(Integer.toString(id))){
                    result = ((Element) node).getElementsByTagName("target").item(0).getTextContent();
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
