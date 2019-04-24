package DomTest;


import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class modify
{

    public static Element modifyData(Element element)
    {
 
        String tagName = element.getNodeName();

        NodeList children = element.getChildNodes();
        
        NamedNodeMap map = element.getAttributes();
        
            for(int i = 0; i < map.getLength(); i++)
            {
                Attr attr = (Attr)map.item(i);
                String attrName = attr.getName();
                String attrValue = attr.getValue();
                if(attrName.equals("frames_classifier") )
                {
                	element.setAttribute("frames_classifier", "newframes");
                }
                
                
            }
        

           
        for(int i = 0; i < children.getLength(); i++)
        {
            Node node = children.item(i);
            
            short nodeType = node.getNodeType();
            String nodeName = node.getNodeName();
            
            if(nodeType == Node.ELEMENT_NODE)
            	modifyData((Element)node);
        }
		return element;
    }
}
