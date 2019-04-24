package DomTest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Country {

	
	static Document docCountryFirst;
	String content;
    public static void main(String[] args) throws ParserConfigurationException,
            SAXException, IOException {
        // step1:鑾峰緱dom瑙ｆ瀽鍣ㄥ伐鍘�
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        System.out.println("class name:" + dbf.getClass().getName());
        // step2:鑾峰緱鍏蜂綋鐨刣om瑙ｆ瀽鍣�
        DocumentBuilder db = dbf.newDocumentBuilder();// ParserConfigurationException
        System.out.println("class name:" + db.getClass().getName());
        // step3:瑙ｆ瀽xml鏂囨。鑾峰緱document瀵硅薄
//      Document document = db.parse(new File("锟节撅拷锟斤拷锟斤拷薮硕锟�.xml"));// "/candidate.xml"锟斤拷示E:\candidate.xml
//      Document document = db.parse(new File("Untitled4.xml"));// "candidate.xml"锟斤拷示E:\workspace\javase\candidate.xml
        Document document = db.parse(new File("src\\chawucidui_9_for40.xml"));// SAXException
        NodeList alist = document.getElementsByTagName("section");
        DOMImplementation impl = db.getDOMImplementation();
        docCountryFirst = impl.createDocument(null, null, null);
        
        Country demo1=new Country();
        demo1.countryFirst(alist);
        
        Element root = docCountryFirst.getDocumentElement();
        
        System.out.println("old:");
        printOut printold=new printOut();
        printold.parseElement(root);
        /*
        delete del=new delete();
        Element temp=del.deleteDataC(root);
        
        System.out.println("new:");
        printOut printnew=new printOut();
        printnew.parseElement(temp);
        
        Element modroot =docCountryFirst.getDocumentElement();
        modify mod=new modify();
        Element tempmod=mod.modifyData(modroot);
        
        System.out.println("modifynew:");
        printOut printmod=new printOut();
        printmod.parseElement(tempmod);*/
    }
    
  
	public void countryFirst(NodeList tempList)
    {
		NodeList list=tempList;
    	Element countries=docCountryFirst.createElement("countries");
    	docCountryFirst.appendChild(countries);
    	for (int i = 0; i < list.getLength(); i++) {
    		Element element = (Element) list.item(i);
    		setCountry(element,countries);
    		//System.out.println("testcdoacvnodav     "+i);
    	}
    }
    
	private void setCountry(Element elementi,Element parentCountry)
    {
			content=elementi.getElementsByTagName("origin").item(0).getAttributes().item(0).getNodeValue();
			if(parentCountry.getElementsByTagName("country").getLength()==0)
			{
				
				Element country=docCountryFirst.createElement("country");
    	    	parentCountry.appendChild(country);
    	    	country.setAttribute("name", content);
    	    	setAnime(elementi,country);
    	    	//System.out.println("endcountry");
			}
			else
			{
				int count=parentCountry.getElementsByTagName("country").getLength();
				for(int j=0;j<count;j++)
				{
					//System.out.println("country");
					if(content.equals(parentCountry.getElementsByTagName("country").item(j).getAttributes().item(0).getNodeValue()))
	    			{
						Element parentAnime=(Element) parentCountry.getElementsByTagName("country").item(j);
						setAnime(elementi,parentAnime);
						break;
	    			}
	    			else
	    			{
	    				if(j==count-1)
	    				{
	    					Element country=docCountryFirst.createElement("country");
	            	    	parentCountry.appendChild(country);
	            	    	country.setAttribute("name", content);
	            	    	setAnime(elementi,country);
	    				}
	    			}
				}
			}
    }
    
    private void setAnime(Element elementi,Element parentAnime)
    {
    	content=elementi.getElementsByTagName("anime").item(0).getAttributes().item(0).getNodeValue();
		if(parentAnime.getElementsByTagName("anime").getLength()==0)
		{
			Element anime=docCountryFirst.createElement("anime");
			parentAnime.appendChild(anime);
	    	anime.setAttribute("name", content);
	    	setNumber(elementi,anime);
	    	//System.out.println("endanime");
		}
		else
		{
			int count=parentAnime.getElementsByTagName("anime").getLength();
			for(int j=0;j<count;j++)
			{//System.out.println("anime");
				if(content.equals(parentAnime.getElementsByTagName("anime").item(j).getAttributes().item(0).getNodeValue()))
    			{
					Element parentNumber=(Element) parentAnime.getElementsByTagName("anime").item(j);
					setNumber(elementi,parentNumber);
					break;
    			}
    			else
    			{
    				if(j==count-1)
    				{
    					Element anime=docCountryFirst.createElement("anime");
    					parentAnime.appendChild(anime);
    			    	anime.setAttribute("name", content);
    			    	setNumber(elementi,anime);
    				}
    			}
			}
		}
    }
    
    private void setNumber(Element elementi,Element parentNumber)
    {
    	content=elementi.getElementsByTagName("anime_content").item(0).getFirstChild().getNodeValue();
		if(parentNumber.getElementsByTagName("number").getLength()==0)
		{
			Element number=docCountryFirst.createElement("number");
			parentNumber.appendChild(number);
	    	number.setAttribute("content", content);
	    	setSection(elementi,number);
	    	//System.out.println("endnumber");
		}
		else
		{
			int count=parentNumber.getElementsByTagName("number").getLength();
			for(int j=0;j<count;j++)
			{/*System.out.println("number   "+parentNumber.getElementsByTagName("number").getLength());
			System.out.println("number  1 ee "+content);
			System.out.println("number 2  ee"+parentNumber.getElementsByTagName("number").item(j).getAttributes().item(0).getNodeValue());*/
				if(content.equals(parentNumber.getElementsByTagName("number").item(j).getAttributes().item(0).getNodeValue()))
    			{//System.out.println("number   "+parentNumber.getElementsByTagName("number").getLength());
					Element parentSection=(Element) parentNumber.getElementsByTagName("number").item(j);
					setSection(elementi,parentSection);
					break;
    			}
    			else
    			{
    				if(j==count-1)
    				{//System.out.println("number not  "+parentNumber.getElementsByTagName("number").getLength());
    					Element number=docCountryFirst.createElement("number");
    					parentNumber.appendChild(number);
    			    	number.setAttribute("content", content);
    			    	setSection(elementi,number);
    				}
    			}
			}
		}
    }
    
    private void setSection(Element elementi,Element parentSection)
    {
    	//System.out.println("sectionlength    "+parentSection.getElementsByTagName("section").getLength());
    	content=elementi.getAttribute("section_id");
    	//System.out.println(content);
		if(parentSection.getElementsByTagName("section").getLength()==0)
		{
			Element section=docCountryFirst.createElement("section");
			parentSection.appendChild(section);
	    	section.setAttribute("section_id", content);
	    	setPlot(elementi,section);
	    	//System.out.println("endsection");
		}
		else
		{
			int count=parentSection.getElementsByTagName("section").getLength();
			for(int j=0;j<count;j++)
			{
				if(content.equals(parentSection.getElementsByTagName("section").item(j).getAttributes().item(0).getNodeValue()))
    			{
					//System.out.println("section");
					Element parentPlotFrames=(Element) parentSection.getElementsByTagName("section").item(j);
					setPlot(elementi,parentPlotFrames);
					break;
    			}
    			else
    			{
    				if(j==count-1)
    				{
    					//System.out.println("sectionnew");
    					Element section=docCountryFirst.createElement("section");
    					parentSection.appendChild(section);
    			    	section.setAttribute("section_id", content);
    			    	setPlot(elementi,section);
    				}
    			}
			}
		}
    }

    private void setPlot(Element elementi,Element parentPlotFrames)
    {
    	content=elementi.getElementsByTagName("plot").item(0).getAttributes().item(0).getNodeValue();
    	String plot_content=elementi.getElementsByTagName("plot_content").item(0).getFirstChild().getNodeValue();
    	Element plot=docCountryFirst.createElement("plot");
		parentPlotFrames.appendChild(plot);
    	plot.setAttribute("plot_classifier", content);
    	plot.appendChild(docCountryFirst.createTextNode(plot_content));
    	//System.out.println(plot_content);
    	
    	String content1=elementi.getElementsByTagName("frames").item(0).getAttributes().item(0).getNodeValue();
    	String frames_content=elementi.getElementsByTagName("frames").item(0).getFirstChild().getNodeValue();
    	Element frames=docCountryFirst.createElement("frames");
		parentPlotFrames.appendChild(frames);
		frames.setAttribute("frames_classifier", content1);
		frames.appendChild(docCountryFirst.createTextNode(frames_content));
		//System.out.println(frames_content);
		//System.out.println();
    }
}
