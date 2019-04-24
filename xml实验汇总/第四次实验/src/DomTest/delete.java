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

public class delete
{

    public static Element deleteDataA(Element element)
    {

        String tagName = element.getNodeName();

        NodeList children = element.getChildNodes();
        
        NamedNodeMap map = element.getAttributes();
        
        for(int i = 0; i < map.getLength(); i++)
        {
            Attr attr = (Attr)map.item(i);
            String attrName = attr.getName();
            String attrValue = attr.getValue();
            if(attrName.equals("frames_classifier") && attrValue.equals("人物") )
            {
            	element.removeAttributeNode(attr);
            }
        }

        //System.out.println("tagName:"+tagName);
        
        int count=children.getLength();
        for(int i = 0; i < count; i++)
        {
            Node node = children.item(i);
            String nodeName = node.getNodeName();
            short nodeType = node.getNodeType();
            //System.out.println("nodeName:"+nodeName+"     nodeType:"+nodeType);
			if(nodeType == Node.ELEMENT_NODE)
            {
            	/*if(nodeName.equals("author"))
                {
            		//System.out.println("newnodeName:"+nodeName+"     nodeType:"+nodeType);
                	element.removeChild(node);
                	count=children.getLength();
                	i--;
                }
            	else
            	{
            		deleteData((Element)node);
            	}*/
				deleteDataA((Element)node);
            }
            
        }
		return element;
    }
    
    public static Element deleteDataC(Element element)
    {

        String tagName = element.getNodeName();

        NodeList children = element.getChildNodes();
        
        NamedNodeMap map = element.getAttributes();
        
        for(int i = 0; i < map.getLength(); i++)
        {
            Attr attr = (Attr)map.item(i);
            String attrName = attr.getName();
            String attrValue = attr.getValue();
            if(attrName.equals("plot_classifier") && attrValue.equals("日常") )
            {
            	element.removeAttributeNode(attr);
            }
        }

        //System.out.println("tagName:"+tagName);
        
        int count=children.getLength();
        for(int i = 0; i < count; i++)
        {
            Node node = children.item(i);
            String nodeName = node.getNodeName();
            short nodeType = node.getNodeType();
            //System.out.println("nodeName:"+nodeName+"     nodeType:"+nodeType);
			if(nodeType == Node.ELEMENT_NODE)
            {
            	/*if(nodeName.equals("author"))
                {
            		//System.out.println("newnodeName:"+nodeName+"     nodeType:"+nodeType);
                	element.removeChild(node);
                	count=children.getLength();
                	i--;
                }
            	else
            	{
            		deleteData((Element)node);
            	}*/
				deleteDataC((Element)node);
            }
            
        }
		return element;
    }
}
