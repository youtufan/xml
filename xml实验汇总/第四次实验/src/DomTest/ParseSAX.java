package DomTest;
/*
 * 排序，组合查找算法以及对象list向vector的转化函数
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
 
import org.xml.sax.XMLReader;
 

public class ParseSAX {
 
	
	public static String file1,file2,file3,file4="combine.xml";
	public static  Vector<String> v;
	public static AnimeSection blank = new AnimeSection("00");
	public List<AnimeSection> anime;
 
	public void selectAP()
	{
try {	
	        v = new Vector<String>();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			SAXParser saxParser = factory.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			AContentHandler handler1 = new AContentHandler();
			xmlReader.setContentHandler(handler1);
			xmlReader.parse(file1);
			AContentHandler handler2 = new AContentHandler();
			xmlReader.setContentHandler(handler2);
			xmlReader.parse(file2);
			AContentHandler handler3 = new AContentHandler();
			xmlReader.setContentHandler(handler3);
			xmlReader.parse(file3);
			anime = new ArrayList<AnimeSection>();
			for (AnimeSection s : handler1.section) {
			    if(s.getPlot().equals("战斗")&&s.getAnimename().equals("东京食尸鬼")) {
			    	anime.add(s);
			    }  
		    }
			anime.add(blank);
			for (AnimeSection s : handler2.section) {
			    if(s.getPlot().equals("战斗")&&s.getAnimename().equals("东京食尸鬼")) {
			    	anime.add(s);
			    }  
		    }
			anime.add(blank);
			for (AnimeSection s : handler3.section) {
			    if(s.getPlot().equals("战斗")&&s.getAnimename().equals("东京食尸鬼")) {
			    	anime.add(s);
			    }  
		    }
			showTable(anime);
			System.out.println(v.size());
		} catch (Exception e) {
			e.printStackTrace();
	}
	}
	
	public void selectAC()
	{
try {	
	        v = new Vector<String>();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			SAXParser saxParser = factory.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			AContentHandler handler1 = new AContentHandler();
			xmlReader.setContentHandler(handler1);
			xmlReader.parse(file1);
			AContentHandler handler2 = new AContentHandler();
			xmlReader.setContentHandler(handler2);
			xmlReader.parse(file2);
			AContentHandler handler3 = new AContentHandler();
			xmlReader.setContentHandler(handler3);
			xmlReader.parse(file3);
			anime = new ArrayList<AnimeSection>();
			for (AnimeSection s : handler1.section) {
			    if(s.getAuthor_name().equals("晓佳奈")) {
			    	for(Role r : s.getRoletable()) {
			    		if(r.getCV().equals("浪川大辅"))
			    			anime.add(s);
			    	}
			    }    
		    }
			anime.add(blank);
			for (AnimeSection s : handler2.section) {
			    if(s.getAuthor_name().equals("晓佳奈")) {
			    	for(Role r : s.getRoletable()) {
			    		if(r.getCV().equals("浪川大辅"))
			    			anime.add(s);
			    	}
			    }    
		    }
			anime.add(blank);
			for (AnimeSection s : handler3.section) {
			    if(s.getAuthor_name().equals("晓佳奈")) {
			    	for(Role r : s.getRoletable()) {
			    		if(r.getCV().equals("浪川大辅"))
			    			anime.add(s);
			    	}
			    }    
		    }
			showTable(anime);
			System.out.println(v.size());
		} catch (Exception e) {
			e.printStackTrace();
	}
	}
	
	public void selectPF()
	{
try {	
	        v = new Vector<String>();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			SAXParser saxParser = factory.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			AContentHandler handler1 = new AContentHandler();
			xmlReader.setContentHandler(handler1);
			xmlReader.parse(file1);
			AContentHandler handler2 = new AContentHandler();
			xmlReader.setContentHandler(handler2);
			xmlReader.parse(file2);
			AContentHandler handler3 = new AContentHandler();
			xmlReader.setContentHandler(handler3);
			xmlReader.parse(file3);
			anime = new ArrayList<AnimeSection>();
			for (AnimeSection s : handler1.section) {
			    if(s.getProducer().equals("Bones")&&s.getFrames().equals("自然")) {
			    	anime.add(s);
			    }  
		    }
			anime.add(blank);
			for (AnimeSection s : handler2.section) {
			    if(s.getProducer().equals("Bones")&&s.getFrames().equals("自然")) {
			    	anime.add(s);
			    }  
		    }
			anime.add(blank);
			for (AnimeSection s : handler3.section) {
			    if(s.getProducer().equals("Bones")&&s.getFrames().equals("自然")) {
			    	anime.add(s);
			    }  
		    }
			showTable(anime);
			System.out.println(v.size());
		} catch (Exception e) {
			e.printStackTrace();
	}
	}
	
	public void orderbyC() {
		try {	
	        v = new Vector<String>();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			SAXParser saxParser = factory.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			AContentHandler handler = new AContentHandler();
			xmlReader.setContentHandler(handler);
			xmlReader.parse(file4);
			anime = new ArrayList<AnimeSection>();
		    List<CompareCountry> orderC = new ArrayList<CompareCountry>();
		    for (AnimeSection s : handler.section) {
			    orderC.add(new CompareCountry(s));
		    }
		    Collections.sort(orderC);
		    for (CompareCountry c : orderC) {
			    anime.add(c.getSection());
		    }
		    showTable(anime);
	    	System.out.println(v.size());
	} catch (Exception e) {
		e.printStackTrace();
}
	}
	
	public void orderbyN() {
		try {	
	        v = new Vector<String>();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			SAXParser saxParser = factory.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			AContentHandler handler = new AContentHandler();
			xmlReader.setContentHandler(handler);
			xmlReader.parse(file4);
			anime = new ArrayList<AnimeSection>();
		    List<CompareName> orderC = new ArrayList<CompareName>();
		    for (AnimeSection s : handler.section) {
			    orderC.add(new CompareName(s));
		    }
		    Collections.sort(orderC);
		    for (CompareName c : orderC) {
			    anime.add(c.getSection());
		    }
		    showTable(anime);
	    	System.out.println(v.size());
	} catch (Exception e) {
		e.printStackTrace();
}
	}
	
	public void orderbyF() {
		try {	
	        v = new Vector<String>();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			SAXParser saxParser = factory.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			AContentHandler handler = new AContentHandler();
			xmlReader.setContentHandler(handler);
			xmlReader.parse(file4);
			anime = new ArrayList<AnimeSection>();
		    List<CompareForm> orderC = new ArrayList<CompareForm>();
		    for (AnimeSection s : handler.section) {
			    orderC.add(new CompareForm(s));
		    }
		    Collections.sort(orderC);
		    for (CompareForm c : orderC) {
			    anime.add(c.getSection());
		    }
		    showTable(anime);
	    	System.out.println(v.size());
	} catch (Exception e) {
		e.printStackTrace();
}
	}

	private void showTable(List<AnimeSection> sectionTest) {
		for(int i=0;i<sectionTest.size();i++)
		{
			v.add(sectionTest.get(i).getId());
			v.add(sectionTest.get(i).getAnimename());
			v.add(sectionTest.get(i).getAnimecontent());
			v.add(sectionTest.get(i).getAuthor_name());
			v.add(sectionTest.get(i).getCountry());
			v.add(sectionTest.get(i).getForm());
			v.add(sectionTest.get(i).getProducer());
			v.add(sectionTest.get(i).getPlot());
			v.add(sectionTest.get(i).getFrames());
		}
			
	}

}