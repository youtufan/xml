package DomTest;


import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ListAfterOrderByName
{
	
	NodeList newlist=null;
	public static Document docu=null;
    public static void main(String[] args) throws Exception
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse((InputStream) docu);
        //Document doc = db.parse(new File("src\\chawucidui_9_for40.xml"));
        
        //Element root = doc.getDocumentElement();

        NodeList alist = doc.getElementsByTagName("anime");
        //parseElement(alist);
       
    }

    
    public void order(Document docAnimeFirst) throws ParserConfigurationException
    {
    	Document document=docAnimeFirst;
    	NodeList list = document.getElementsByTagName("anime");
    	newlist=document.getElementsByTagName("animes");

    	String content;
    	ArrayList<String> name = new ArrayList<String>();
    	for (int i = 0; i < list.getLength(); i++) {
    		Element element = (Element) list.item(i);
    		content=element.getAttribute("name");
    		name.add(content);
    	}
    	/*System.out.println("old");
    	for(int i=0;i<name.size();i++)
        {
        	System.out.println(name.get(i));
        }
    	System.out.println("new");*/
    	
    	Collections.sort(name, new SortByName());
        /*for(int i=0;i<name.size();i++)
        {
        	System.out.println(name.get(i));
        }*/
    	
        //System.out.println("   length:   "+newlist.getLength());
        for(int j=0;j<name.size();j++)
        {
        	for(int i=0;i<list.getLength();i++)
            {
            	String anime_name=list.item(i).getAttributes().item(0).getNodeValue();
            	if(anime_name.equals(name.get(j)))
            	{
            		//System.out.println("anime_name    "+anime_name);
            		newlist.item(0).appendChild(list.item(i));
            		break;
            	}
            }
        }
    }
    
	
}
