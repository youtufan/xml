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

public class Anime {

	
	static Document docAnimeFirst = null;
	String content;
	
	public void animeFirst(NodeList tempList)
    {
		NodeList list=tempList;
    	Element animes=docAnimeFirst.createElement("animes");
    	docAnimeFirst.appendChild(animes);
    	for (int i = 0; i < list.getLength(); i++) {
    		Element element = (Element) list.item(i);
    		setAnime(element,animes);
    		//System.out.println("testcdoacvnodav     "+i);
    	}
    }
    
    
    private void setAnime(Element elementi,Element parentAnime)
    {
    	content=elementi.getElementsByTagName("anime").item(0).getAttributes().item(0).getNodeValue();
		if(parentAnime.getElementsByTagName("anime").getLength()==0)
		{
			Element anime=docAnimeFirst.createElement("anime");
			parentAnime.appendChild(anime);
	    	anime.setAttribute("name", content);
	    	setAuthor(elementi,anime);
	    	setFramesTable(elementi,anime);
	    	//System.out.println("endanime");
		}
		else
		{
			int count=parentAnime.getElementsByTagName("anime").getLength();
			for(int j=0;j<count;j++)
			{//System.out.println("anime");
				if(content.equals(parentAnime.getElementsByTagName("anime").item(j).getAttributes().item(0).getNodeValue()))
    			{
					//System.out.println("animeold:"+content);
					Element parentAuthor=(Element) parentAnime.getElementsByTagName("anime").item(j);
					setAuthor(elementi,parentAuthor);
			    	setFramesTable(elementi,parentAuthor);
					break;
    			}
    			else
    			{
    				if(j==count-1)
    				{
    					//System.out.println("animenew:"+content);
    					Element anime=docAnimeFirst.createElement("anime");
    					parentAnime.appendChild(anime);
    			    	anime.setAttribute("name", content);
    			    	setAuthor(elementi,anime);
    			    	setFramesTable(elementi,anime);
    				}
    			}
			}
		}
    }
    
    private void setAuthor(Element elementi,Element parentAuthor)
    {
    	content=elementi.getElementsByTagName("author").item(0).getAttributes().item(2).getNodeValue();
    	String gender=elementi.getElementsByTagName("author").item(0).getAttributes().item(1).getNodeValue();
    	String birth=elementi.getElementsByTagName("author").item(0).getAttributes().item(0).getNodeValue();
    	//System.out.println("name:"+content+"  gender:"+gender+"  birth: "+birth);
		if(parentAuthor.getElementsByTagName("author").getLength()==0)
		{
			Element author=docAnimeFirst.createElement("author");
			parentAuthor.appendChild(author);
			author.setAttribute("name",content);
			author.setAttribute("gender",gender);
			author.setAttribute("birth",birth);
		}
    }
    
    private void setFramesTable(Element elementi,Element parentFramesTable)
    {
    	Element framesTable = null;
    	if(parentFramesTable.getElementsByTagName("framesTable").getLength()==0)
		{
    		framesTable=docAnimeFirst.createElement("framesTable");
        	parentFramesTable.appendChild(framesTable);
        	setFrames(elementi,framesTable);
		}
    	else
    	{
    		framesTable=(Element) parentFramesTable.getElementsByTagName("framesTable").item(0);
    		setFrames(elementi,framesTable);
    	}
    }
    
    private void setFrames(Element elementi,Element parentFrames)
    {
    	content=elementi.getElementsByTagName("frames").item(0).getAttributes().item(0).getNodeValue();
    	//System.out.println("framesclass:   "+content+"length  "+parentFrames.getElementsByTagName("frames").getLength()+"id:"+elementi.getAttribute("section_id"));
    	if(parentFrames.getElementsByTagName("frames").getLength()==0)
		{
    		Element frames=docAnimeFirst.createElement("frames");
        	parentFrames.appendChild(frames);
    		frames.setAttribute("frames_classifier", content);
    		setFrame(elementi,frames);
		}
		else
		{
			int count=parentFrames.getElementsByTagName("frames").getLength();
			for(int j=0;j<count;j++)
			{
				if(content.equals(parentFrames.getElementsByTagName("frames").item(j).getAttributes().item(0).getNodeValue()))
    			{
					//System.out.println("framesclass==:   "+content);
					Element parentFrame=(Element) parentFrames.getElementsByTagName("frames").item(j);
					setFrame(elementi,parentFrame);
					break;
    			}
    			else
    			{
    				//System.out.println("framesclass bu=:   "+content);
    				if(j==count-1)
    				{
    					Element frames=docAnimeFirst.createElement("frames");
    		        	parentFrames.appendChild(frames);
    		    		frames.setAttribute("frames_classifier", content);
    		    		setFrame(elementi,frames);
    				}
    			}
			}
		}
    }
    
    private void setFrame(Element elementi,Element parentFrame)
    {
    	
    	content=elementi.getAttribute("section_id");
    	String frames_content=elementi.getElementsByTagName("frames").item(0).getFirstChild().getNodeValue();
    	Element frame=docAnimeFirst.createElement("frame");
		parentFrame.appendChild(frame);
    	frame.setAttribute("s_id", content);
    	frame.appendChild(docAnimeFirst.createTextNode(frames_content));
    	//System.out.println("section_id   "+content+"frames_content    "+frames_content);
    	//System.out.println();
    }
    
}
