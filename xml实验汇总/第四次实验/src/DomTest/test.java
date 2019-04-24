package DomTest;
/*
 * 运行类
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class test extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public test() throws ParserConfigurationException, SAXException, IOException {
		setTitle("查无此队");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("animeName");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				showList list1=new showList("order_by_animeName");
				list1.setVisible(true);
				
			}
		});
		
		JButton button = new JButton("country");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				showList list2=new showList("order_by_country");
				list2.setVisible(true);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("riginalForm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				showList list3=new showList("order_by_riginalForm");
				list3.setVisible(true);
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("anime_plot");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				showList list4=new showList("anime_plot");
				list4.setVisible(true);
			}
		});
		
		JButton btnNewButton_3 = new JButton("author_cv");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				showList list5=new showList("author_cv");
				list5.setVisible(true);
			}
		});
		
		JButton btnNewButton_4 = new JButton("producer_frames");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList list6=new showList("producer_frames");
				list6.setVisible(true);
			}
		});
		
		
		
		JFrame jf1 = new JFrame("CountryFirst调整");
        JFrame jf2 = new JFrame("CountryFirst删除");
        JFrame jf3 = new JFrame("AnimeFirst调整");
        JFrame jf4 = new JFrame("AnimeFirst删除");
        
        // step1:获得dom解析器工厂
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        System.out.println("class name:" + dbf.getClass().getName());
        // step2:获得具体的dom解析器
        DocumentBuilder db = dbf.newDocumentBuilder();// ParserConfigurationException
        System.out.println("class name:" + db.getClass().getName());
        // step3:解析xml文档获得document 对象
        Document document =db.parse(new File("chawucidui_9_for40.xml"));
        NodeList alist = document.getElementsByTagName("section");
        DOMImplementation impl = db.getDOMImplementation();
        Country demo1=new Country();
        Anime demo2=new Anime();
        demo1.docCountryFirst = impl.createDocument(null, null, null);
        demo1.countryFirst(alist);
        demo2.docAnimeFirst = impl.createDocument(null, null, null);
        ListAfterOrderByName order =new ListAfterOrderByName();
        demo2.animeFirst(alist);
        order.order(demo2.docAnimeFirst);
        
        Element country_before = demo1.docCountryFirst.getDocumentElement();
        JTable cTable1 = printOut.showCountryFirst(country_before);
        jf1.getContentPane().add(new JScrollPane(cTable1));
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf1.setSize(500, 500);
          
        Element country_delete =demo1.docCountryFirst.getDocumentElement();
        delete del=new delete();
        del.deleteDataC(country_delete);
        printOut.item=0;
        JTable cTable2 = printOut.showCountryFirst(country_delete);
        jf2.getContentPane().add(new JScrollPane(cTable2));
        jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf2.setSize(500, 500);
        
        Element anime_before = demo2.docAnimeFirst.getDocumentElement();
        printOut.item=0;
        JTable cTable3 = printOut.showAnimeFirst(anime_before);
        jf3.getContentPane().add(new JScrollPane(cTable3));
        jf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf3.setSize(500, 500);
          
        Element anime_delete =demo2.docAnimeFirst.getDocumentElement();
        del.deleteDataA(anime_delete);
        printOut.item=0;
        JTable cTable4 = printOut.showAnimeFirst(anime_delete);
        jf4.getContentPane().add(new JScrollPane(cTable4));
        jf4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf4.setSize(500, 500);
          
		
		JButton btnNewButton_5 = new JButton("DOM[3]修改");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf1.setVisible(true);
			}
		});
		
		JButton btnNewButton_6 = new JButton("DOM[3]删除");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf2.setVisible(true);
				
			}
		});
		
		JButton btnNewButton_7 = new JButton("DOM[4]修改");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf3.setVisible(true);
			}
		});
		
		JButton btnNewButton_8 = new JButton("DOM[4]删除");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf4.setVisible(true);
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
				 
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(btnNewButton_5))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_6))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_7))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_8))
						.addGap(40))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
