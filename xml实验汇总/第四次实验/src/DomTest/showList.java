package DomTest;
/*
 * œ‘ æ¿‡
 */
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class showList extends JFrame {

	public static String testfile1="chawucidui_9_for35.xml";
	public static String testfile2="combine.xml";
	public static String testfile3="new5.xml";
	public static String testfile4="chawucidui_9_for40.xml";
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public showList(String op) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel(op,JLabel.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(72)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "\u52A8\u6F2B\u540D", "\u96C6\u6570", "\u4F5C\u8005", "\u56FD\u5BB6", "\u6765\u6E90", "\u51FA\u54C1\u65B9", "\u5267\u60C5", "\u573A\u666F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		this.fillTable(op);
		System.out.println(testfile1);
		table.clearSelection();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void fillTable(String op)
	{
		table.clearSelection();
		ParseSAX sax=new ParseSAX();
		int count=0;
		ParseSAX.file1=testfile1;
		ParseSAX.file2=testfile2;
		ParseSAX.file3=testfile3;
		ParseSAX.file4=testfile4;
		switch(op) {
		case "order_by_animeName" :
			sax.orderbyN();
			break;
		case "order_by_country":
			sax.orderbyC();
			break;
		case "order_by_riginalForm":
			sax.orderbyF();
			break;
		case "anime_plot" :
			sax.selectAP();
			break;
		case "author_cv":
			sax.selectAC();
			break;
		case "producer_frames":
			sax.selectPF();
			break;
		default : 
		}
		
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		int i=0;
		
		while(i<ParseSAX.v.size())
		{
			if(count==0)
			{
				Vector listv=new Vector();
				listv.add(ParseSAX.v.get(i));
				listv.add(ParseSAX.v.get(i+1));
				listv.add(ParseSAX.v.get(i+2));
				listv.add(ParseSAX.v.get(i+3));
				listv.add(ParseSAX.v.get(i+4));
				listv.add(ParseSAX.v.get(i+5));
				listv.add(ParseSAX.v.get(i+6));
				listv.add(ParseSAX.v.get(i+7));
				listv.add(ParseSAX.v.get(i+8));
				i=i+9;
				System.out.println(listv);
				dtm.addRow(listv);
			}
			count=0;
			
		}
	}
}
