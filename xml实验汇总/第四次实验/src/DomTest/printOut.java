package DomTest;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
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
import org.xml.sax.SAXException;

public class printOut
{
	
	public static int item= 0;
	//public static int countforA = 0;
    
    public static CombineTable showAnimeFirst(Element root) throws ParserConfigurationException,
           SAXException, IOException {
          
           
          
           
           String[][] datas = new String[40][5];
           for (int i = 0; i < datas.length; i++) {
               String[] data = datas[i];
               for (int j = 0; j < data.length; j++) {
                   data[j] = " ";
               }
           }
           
           
           datas = fillAnimetable(root,datas);

           CombineData m = new CombineData(datas, 0,1,2);
           DefaultTableModel tm = new DefaultTableModel(datas, new String[]{"Anime", "Author", "Frames_classifier", "Section_id"});
           CombineTable cTable = new CombineTable(m, tm);
    
           TableColumnModel columnModel = cTable.getColumnModel();
           for (Integer integer : m.combineColumns) {
               TableColumn column = columnModel.getColumn(integer);
               column.setCellRenderer(new CombineColumnRender());
           }
    
           cTable.setCellSelectionEnabled(true);
           return cTable;
}
    
    public static CombineTable showCountryFirst(Element root) throws ParserConfigurationException,
    SAXException, IOException {
    
    String[][] datas = new String[40][7];
    for (int i = 0; i < datas.length; i++) {
        String[] data = datas[i];
        for (int j = 0; j < data.length; j++) {
            data[j] = " ";
        }
    }
    
    
    datas = fillCountrytable(root,datas);

    CombineData m = new CombineData(datas, 0,1,2);
    DefaultTableModel tm = new DefaultTableModel(datas, new String[]{"Country", "Anime", "Number", "Section_id","Plot_classifier","Frames_classifier"});
    CombineTable cTable = new CombineTable(m, tm);

    TableColumnModel columnModel = cTable.getColumnModel();
    for (Integer integer : m.combineColumns) {
        TableColumn column = columnModel.getColumn(integer);
        column.setCellRenderer(new CombineColumnRender());
    }

    cTable.setCellSelectionEnabled(true);
    return cTable;
}

    public static void parseElement(Element element)

    {
        String tagName = element.getNodeName();

        NodeList children = element.getChildNodes();

        System.out.print("<" + tagName);

        NamedNodeMap map = element.getAttributes();

        if(null != map)
        {
            for(int i = 0; i < map.getLength(); i++)
            {

                Attr attr = (Attr)map.item(i);

                String attrName = attr.getName();
                String attrValue = attr.getValue();

                System.out.print(" " + attrName + "=\"" + attrValue + "\"");
            }
        }

        System.out.print(">");
        System.out.println();

        for(int i = 0; i < children.getLength(); i++)
        {
            Node node = children.item(i);

            short nodeType = node.getNodeType();

            if(nodeType == Node.ELEMENT_NODE)
            {

                parseElement((Element)node);
            }
            else if(nodeType == Node.TEXT_NODE)
            {

                System.out.print(node.getNodeValue());
            }
            else if(nodeType == Node.COMMENT_NODE)
            {
                System.out.print("<!--");

                Comment comment = (Comment)node;

                String data = comment.getData();

                System.out.print(data);

                System.out.print("-->");
            }
        }

        System.out.print("</" + tagName + ">");
        System.out.println();
    }
    
    
    public static String[][] fillAnimetable(Element root,String[][] datas)
    {
    	String tagName = root.getNodeName();

        NodeList children = root.getChildNodes();

        NamedNodeMap map = root.getAttributes();
        
        if(tagName.equals("frames")) {
        	datas[item][2]="   ";
        }

        if(null != map)
        {
            for(int i = 0; i < map.getLength(); i++)
            {

                Attr attr = (Attr)map.item(i);

                String attrName = attr.getName();
                String attrValue = attr.getValue();
                switch (attrName){
                case "s_id":
              	   datas[item][3]=attrValue;
              	   item=item+1;
              	   break;
                 case "frames_classifier":
              	   datas[item][2]=attrValue;
              	   break;
                 case "name":
                 	if(tagName.equals("author"))datas[item][1]=attrValue;
                 	if(tagName.equals("anime")) {
                 		//countforA ++;
                 		//if (countforA>top) break;
                 		datas[item][0]=attrValue;
                 		}
                 	break;
                }
            }
        }

        for(int i = 0; i < children.getLength(); i++)
        {
            Node node = children.item(i);

            short nodeType = node.getNodeType();

            if(nodeType == Node.ELEMENT_NODE)
            {

            	datas=fillAnimetable((Element)node,datas);
            }
        }
		return datas;
    }

    public static String[][] fillCountrytable(Element root,String[][] datas)
    {
    	String tagName = root.getNodeName();
    	
        NodeList children = root.getChildNodes();

        NamedNodeMap map = root.getAttributes();
        
        if(null != map)
        {
            for(int i = 0; i < map.getLength(); i++)
            {

                Attr attr = (Attr)map.item(i);

                String attrName = attr.getName();
                String attrValue = attr.getValue();
                
                switch (attrName){
                case "section_id":
             	   datas[item][3]=attrValue;
             	   NamedNodeMap map1=children.item(0).getAttributes();
             	   NamedNodeMap map2=children.item(1).getAttributes();
             	   Attr attr1 = (Attr)map1.item(0);
             	   Attr attr2 = (Attr)map2.item(0);
             	   String str = "   ";
             	   if(attr1!=null)str = attr1.getValue();
             	   datas[item][4]=str;
             	   if(attr2!=null)str = attr2.getValue();
             	   datas[item][5]=str;
             	   item=item+1;
             	   break;
                case "content":
               	   datas[item][2]=attrValue;
               	   break;
                case "name":
                	if(tagName.equals("anime"))datas[item][1]=attrValue;
                	if(tagName.equals("country"))datas[item][0]=attrValue;
                	break;
                }
            }
        }


        for(int i = 0; i < children.getLength(); i++)
        {
            Node node = children.item(i);

            short nodeType = node.getNodeType();

            if(nodeType == Node.ELEMENT_NODE)
            {

               datas=fillCountrytable((Element)node,datas);
            }
        }
		return datas;
    }

}
