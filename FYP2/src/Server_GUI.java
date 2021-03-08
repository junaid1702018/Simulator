import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;

public class Server_GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	private JScrollPane scrollPane;
	private JPanel panel;
	final Object[] row;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server_GUI frame = new Server_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Server_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 432, 261);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(176, 196, 222));
		model = new DefaultTableModel();
		Object[] column= {"ID","Longitude","Latitude","Temperature","Gas"};
		row=new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
        
	}
	public void add_data(String id,String lgt,String alt,int data1,int data2)
	{	
		row[0]=id;
		row[1]=lgt;
        row[2]=alt;
        row[3]=Integer.toString(data1);
        row[4]=Integer.toString(data2);
        model.addRow(row);
	}
}
