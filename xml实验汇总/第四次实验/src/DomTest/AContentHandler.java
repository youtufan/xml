package DomTest;
/*
 * content handler ÷ÿ‘ÿ
 */

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class AContentHandler implements ContentHandler {
	public List<AnimeSection> section = new ArrayList<AnimeSection>();

	public AnimeSection currentSection = new AnimeSection("00");
	public String currentElement;

	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub
		String content = new String(arg0,arg1,arg2);		
		if (currentElement=="anime_content") {
		currentSection.setAnimecontent(content);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("End Document!");

	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		// TODO Auto-generated method stub
		if(arg2=="section"){section.add(currentSection); currentSection = new AnimeSection("00");}
		currentElement = "";
		System.out.println("End Element:" + arg2);
	}

	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Start Document!");
	}

	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Start Element:"+arg2);
		currentElement = arg2;
		String id;
		switch(arg2){
	    case "section" :
	    	id = arg3.getValue("section_id");
		       currentSection.setId(id);
		       break;
	    case "origin" :
		     String country = arg3.getValue(0);
		     currentSection.setCountry(country);
		       break;
	    case "anime" :
	    	String animename = arg3.getValue(0);
	    	currentSection.setAnimename(animename);
		       break;
	    case "producer" :
	    	String producer = arg3.getValue(0);
	    	currentSection.setProducer(producer);
		       break;
	    case "original" :
	    	String form = arg3.getValue(0);
	    	currentSection.setForm(form);
		       break;
	    case "author" :
	    	String authorname = arg3.getValue(0);
	    	currentSection.setAuthor_name(authorname);
		       break;
	    case "role" :
	    	String rolename = arg3.getValue(0);
	    	String role_gender = arg3.getValue(1);
	    	int role_age = Integer.parseInt(arg3.getValue(2));
	    	String role_cv = arg3.getValue(3); 	
		       Role temp1 = new Role(rolename);
		       temp1.setGender(role_gender);
		       temp1.setAge(role_age);
		       temp1.setCV(role_cv);
		       currentSection.addRole(temp1);
		       break;
	    case "plot":
	    	String plot = arg3.getValue(0);
	    	currentSection.setPlot(plot);
		       break;
	    case "frames":
	    	String frame = arg3.getValue(0);
	    	currentSection.setFrames(frame);
		       break;
	   
	    default : 	    	
	       System.out.println("now£∫"+arg2);
	}
	}

	@Override
	public void startPrefixMapping(String arg0, String arg1) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}

}
