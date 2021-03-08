import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SGLD_GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ID;
	private JTextField Longitude;
	private JTextField Latitude;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SGLD_GUI frame = new SGLD_GUI();
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
	public SGLD_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ID = new JTextField();
		ID.setBounds(81, 42, 86, 20);
		contentPane.add(ID);
		ID.setColumns(10);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(64, 45, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Longitude");
		lblNewLabel_1.setBounds(30, 86, 48, 14);
		contentPane.add(lblNewLabel_1);

		Longitude = new JTextField();
		Longitude.setBounds(81, 83, 86, 20);
		contentPane.add(Longitude);
		Longitude.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Latitude");
		lblNewLabel_2.setBounds(41, 125, 37, 14);
		contentPane.add(lblNewLabel_2);

		Latitude = new JTextField();
		Latitude.setBounds(81, 122, 86, 20);
		contentPane.add(Latitude);
		Latitude.setColumns(10);

		JButton start = new JButton("Start");
		start.setBounds(81, 210, 89, 23);
		contentPane.add(start);

		JButton btnNewButton_1 = new JButton("Add New Device");
		btnNewButton_1.setBounds(245, 210, 89, 23);
		contentPane.add(btnNewButton_1);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SGLD device = new SGLD(ID.getText(), Longitude.getText(), Latitude.getText());

				if (start.getText().equals("Start")) {
					if (ID.getText() != "" && Longitude.getText() != " " && Latitude.getText() != " ") {
						device.start();
						start.setText("Stop");
					}
				}
				else {
					start.setText("Start");
					device.stopSendingData();
				}

			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SGLD_GUI fr = new SGLD_GUI();
				fr.setVisible(true);
			}
		});
	}
}
