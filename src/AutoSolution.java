import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class AutoSolution {
	
	CCompagnie CO = new CCompagnie();

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutoSolution window = new AutoSolution();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AutoSolution() {
		initialize();
		
		CChauffeur Chauffeur1 = new CChauffeur("Marsolais","Francis","725 Duhamel","2017");
		CChauffeur Chauffeur2 = new CChauffeur("Marsolais","Samuel","725 Duhamel","2014");
		CChauffeur Chauffeur3 = new CChauffeur("Marsolais","Noémie","725 Duhamel","2016");
		
		CO.AddChauffeur(Chauffeur1);
		CO.AddChauffeur(Chauffeur2);
		CO.AddChauffeur(Chauffeur3);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnDireBonjour = new JButton("Dire bonjour !");
		btnDireBonjour.setBounds(0, 238, 434, 23);
		btnDireBonjour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<CChauffeur> LstChauffeur = CO.GetLstChauffeur();
				
				//
				for(CChauffeur cc : LstChauffeur){
					System.out.println(cc.AfficherInformationChauffeur());
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnDireBonjour);
		
		textField = new JTextField();
		textField.setBounds(10, 24, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 70, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 114, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(10, 58, 46, 14);
		frame.getContentPane().add(lblPrenom);
	}
}
