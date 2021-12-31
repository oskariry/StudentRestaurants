package menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class App {

	private JFrame frame;
	private JTextField header;
	private JTextField filtAlrg;
	private JTextField restaurantHead;
	private JTextField fazerHead;
	private JTextField sodexoHead;
	private JTextField foodHead;
	private JTextField menuHead;
	private JTextField ablockHead;
	private JTextField dipoliHead;
	private JTextField alvariHead;
	private JTextField tuasHead;
	private JTextField kvarkkiHead;
	private JTextField valimoHead;
	private JTextField tietHead;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1750, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		header = new JTextField();
		header.setEditable(false);
		header.setBackground(Color.LIGHT_GRAY);
		header.setText("Otaniemen opiskelijaravintolat");
		header.setFont(new Font("Times New Roman", Font.BOLD, 24));
		header.setBounds(725, 13, 325, 45);
		frame.getContentPane().add(header);
		header.setColumns(10);
		
		filtAlrg = new JTextField();
		filtAlrg.setEditable(false);
		filtAlrg.setBackground(Color.LIGHT_GRAY);
		filtAlrg.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		filtAlrg.setText("Suodata:");
		filtAlrg.setBounds(200, 125, 75, 25);
		frame.getContentPane().add(filtAlrg);
		filtAlrg.setColumns(10);
		
		JRadioButton lactoseBut = new JRadioButton("Laktoositon");
		lactoseBut.setBackground(Color.LIGHT_GRAY);
		lactoseBut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lactoseBut.setBounds(423, 125, 100, 25);
		frame.getContentPane().add(lactoseBut);
		lactoseBut.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            updatePanel(1, lactoseBut);
	        }
	    });
		
		JRadioButton lowlactoseBut = new JRadioButton("Vähälaktoosinen");
		lowlactoseBut.setBackground(Color.LIGHT_GRAY);
		lowlactoseBut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lowlactoseBut.setBounds(671, 125, 130, 25);
		frame.getContentPane().add(lowlactoseBut);
		lowlactoseBut.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	updatePanel(2, lowlactoseBut);
	        }
	    });
		
		JRadioButton milklessBut = new JRadioButton("Maidoton");
		milklessBut.setBackground(Color.LIGHT_GRAY);
		milklessBut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		milklessBut.setBounds(1187, 125, 90, 25);
		frame.getContentPane().add(milklessBut);
		milklessBut.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	updatePanel(3, milklessBut);
	        }
	    });
		
		JRadioButton contalrgBut = new JRadioButton("Ei sis. allergeeneja");
		contalrgBut.setBackground(Color.LIGHT_GRAY);
		contalrgBut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contalrgBut.setBounds(923, 125, 139, 25);
		frame.getContentPane().add(contalrgBut);
		contalrgBut.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	updatePanel(4, contalrgBut);
	        }
	    });
		
		JRadioButton veganBut = new JRadioButton("Vegaani");
		veganBut.setBackground(Color.LIGHT_GRAY);
		veganBut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		veganBut.setBounds(1425, 125, 80, 25);
		frame.getContentPane().add(veganBut);
		veganBut.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	updatePanel(5, veganBut);
	        }
	    });
		
		restaurantHead = new JTextField();
		restaurantHead.setEditable(false);
		restaurantHead.setBackground(Color.LIGHT_GRAY);
		restaurantHead.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		restaurantHead.setText("Raviintolat:");
		restaurantHead.setBounds(200, 175, 75, 25);
		frame.getContentPane().add(restaurantHead);
		restaurantHead.setColumns(10);
		
		
		fazerHead = new JTextField();
		fazerHead.setEditable(false);
		fazerHead.setBackground(Color.LIGHT_GRAY);
		fazerHead.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		fazerHead.setText("Fazer");
		fazerHead.setBounds(295, 175, 50, 25);
		frame.getContentPane().add(fazerHead);
		fazerHead.setColumns(10);
		
		sodexoHead = new JTextField();
		sodexoHead.setEditable(false);
		sodexoHead.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sodexoHead.setBackground(Color.LIGHT_GRAY);
		sodexoHead.setText("Sodexo");
		sodexoHead.setBounds(295, 220, 55, 25);
		frame.getContentPane().add(sodexoHead);
		sodexoHead.setColumns(10);
		
		JRadioButton ablockBut = new JRadioButton("ABlock");
		ablockBut.setBackground(Color.LIGHT_GRAY);
		ablockBut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ablockBut.setBounds(423, 175, 127, 25);
		frame.getContentPane().add(ablockBut);
		ablockBut.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	updatePanel(6, ablockBut);
	        }
	    });
		
		JRadioButton dipoliBut = new JRadioButton("Dipoli");
		dipoliBut.setBackground(Color.LIGHT_GRAY);
		dipoliBut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		dipoliBut.setBounds(671, 175, 127, 25);
		frame.getContentPane().add(dipoliBut);
		dipoliBut.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	updatePanel(7, dipoliBut);
	        }
	    });
		
		JRadioButton alvariBut = new JRadioButton("Alvari");
		alvariBut.setBackground(Color.LIGHT_GRAY);
		alvariBut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		alvariBut.setBounds(923, 175, 127, 25);
		frame.getContentPane().add(alvariBut);
		alvariBut.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	updatePanel(8, alvariBut);
	        }
	    });
		
		JRadioButton tuasBut = new JRadioButton("TUAS");
		tuasBut.setBackground(Color.LIGHT_GRAY);
		tuasBut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tuasBut.setBounds(1187, 175, 127, 25);
		frame.getContentPane().add(tuasBut);
		tuasBut.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	updatePanel(9, tuasBut);
	        }
	    });
		
		JRadioButton kvarkkiBut = new JRadioButton("Kvarkki");
		kvarkkiBut.setBackground(Color.LIGHT_GRAY);
		kvarkkiBut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		kvarkkiBut.setBounds(423, 220, 85, 25);
		frame.getContentPane().add(kvarkkiBut);
		kvarkkiBut.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	updatePanel(10, kvarkkiBut);
	        }
	    });
		
		JRadioButton valimoBut = new JRadioButton("Valimo");
		valimoBut.setBackground(Color.LIGHT_GRAY);
		valimoBut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		valimoBut.setBounds(671, 220, 80, 25);
		frame.getContentPane().add(valimoBut);
		valimoBut.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	updatePanel(11, valimoBut);
	        }
	    });
		
		JRadioButton tietBut = new JRadioButton("Tietotekniikantalo");
		tietBut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tietBut.setBackground(Color.LIGHT_GRAY);
		tietBut.setBounds(923, 220, 165, 25);
		frame.getContentPane().add(tietBut);
		tietBut.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	updatePanel(12, tietBut);
	        }
	    });
		
		JRadioButton allBut = new JRadioButton("Kaikki");
		allBut.setSelected(true);
		allBut.setBackground(Color.LIGHT_GRAY);
		allBut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		allBut.setBounds(1425, 201, 127, 25);
		frame.getContentPane().add(allBut);
		allBut.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	updatePanel(13, allBut);
	        }
	    });
		
		
		ButtonGroup filt = new ButtonGroup();
		filt.add(ablockBut);
		filt.add(dipoliBut);
		filt.add(alvariBut);
		filt.add(tuasBut);
		filt.add(kvarkkiBut);
		filt.add(valimoBut);
		filt.add(tietBut);
		filt.add(allBut);
		
		foodHead = new JTextField();
		foodHead.setEditable(false);
		foodHead.setBackground(Color.LIGHT_GRAY);
		foodHead.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		foodHead.setText("Raaka-aine");
		foodHead.setBounds(200, 270, 116, 25);
		frame.getContentPane().add(foodHead);
		foodHead.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(423, 270, 170, 22);
		frame.getContentPane().add(comboBox);
		
		menuHead = new JTextField();
		menuHead.setEditable(false);
		menuHead.setFont(new Font("Times New Roman", Font.BOLD, 22));
		menuHead.setText("Ruokalistat");
		menuHead.setBounds(815, 337, 120, 30);
		frame.getContentPane().add(menuHead);
		menuHead.setColumns(10);
		
		JPanel menuGroup = new JPanel();
		menuGroup.setBackground(Color.LIGHT_GRAY);
		menuGroup.setBounds(40, 380, 1650, 550);
		frame.getContentPane().add(menuGroup);
		menuGroup.setLayout(null);
		
		ablockHead = new JTextField();
		ablockHead.setFont(new Font("Times New Roman", Font.BOLD, 16));
		ablockHead.setEditable(false);
		ablockHead.setText("Fazer ABlock");
		ablockHead.setBounds(12, 90, 100, 25);
		menuGroup.add(ablockHead);
		ablockHead.setColumns(10);
		
		dipoliHead = new JTextField();
		dipoliHead.setEditable(false);
		dipoliHead.setFont(new Font("Times New Roman", Font.BOLD, 16));
		dipoliHead.setText("Fazer Dipoli");
		dipoliHead.setBounds(390, 90, 90, 25);
		menuGroup.add(dipoliHead);
		dipoliHead.setColumns(10);
		
		alvariHead = new JTextField();
		alvariHead.setEditable(false);
		alvariHead.setFont(new Font("Times New Roman", Font.BOLD, 16));
		alvariHead.setText("Fazer Alvari");
		alvariHead.setBounds(788, 90, 90, 25);
		menuGroup.add(alvariHead);
		alvariHead.setColumns(10);
		
		tuasHead = new JTextField();
		tuasHead.setEditable(false);
		tuasHead.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tuasHead.setText("Fazer TUAS");
		tuasHead.setBounds(1192, 90, 90, 22);
		menuGroup.add(tuasHead);
		tuasHead.setColumns(10);
		
		kvarkkiHead = new JTextField();
		kvarkkiHead.setFont(new Font("Times New Roman", Font.BOLD, 16));
		kvarkkiHead.setText("Sodexo Kvarkki");
		kvarkkiHead.setEditable(false);
		kvarkkiHead.setBounds(1115, 315, 116, 22);
		menuGroup.add(kvarkkiHead);
		kvarkkiHead.setColumns(10);
		
		valimoHead = new JTextField();
		valimoHead.setEditable(false);
		valimoHead.setFont(new Font("Times New Roman", Font.BOLD, 16));
		valimoHead.setText("Sodexo Valimo");
		valimoHead.setBounds(12, 315, 116, 22);
		menuGroup.add(valimoHead);
		valimoHead.setColumns(10);
		
		tietHead = new JTextField();
		tietHead.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tietHead.setEditable(false);
		tietHead.setText("Sodexo tietotekniikantalo");
		tietHead.setBounds(543, 315, 180, 22);
		menuGroup.add(tietHead);
		tietHead.setColumns(10);
		
		JLabel dayLabel = new JLabel("Viikonpäivä");
		dayLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		dayLabel.setBounds(780, 30, 150, 16);
		menuGroup.add(dayLabel);
		dayLabel.setText(getCurrentDay().toUpperCase());
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(543, 171, 116, 22);
		menuGroup.add(textField);
		textField.setColumns(10);
		
		
	}
	
	private static void updatePanel(int num, JRadioButton but) {
		// Lactose = 1, Low lactose = 2, Milkless = 3, cont = 4, vegan = 5, ablock = 6, dipoli = 7
		// alvari = 8, tuas = 9, kvarkki = 10, valimo  = 11, tietotekniikantalo = 12
		switch(num) {
		
		case 1:
			if (but.isSelected()) {
				
			}else {
				
			}
			break;
		case 2: 
			if (but.isSelected()) {
				
			}else {
				
			}
			break;
		case 3:
			if (but.isSelected()) {
				
			}else {
				
			}
			break;
		case 4: 
			if (but.isSelected()) {
				
			}else {
				
			}
			break;
		case 5:
			if (but.isSelected()) {
				
			}else {
				
			}
			break;
		case 6:
			if (but.isSelected()) {
				
			}else {
				
			}
			break;
		case 7:
			if (but.isSelected()) {
				
			}else {
				
			}
			break;
		case 8:
			if (but.isSelected()) {
				
			}else {
				
			}
			break;
		case 9:
			if (but.isSelected()) {
				
			}else {
				
			}
			break;
		case 10:
			if (but.isSelected()) {
				
			}else {
				
			}
			break;
		case 11:
			if (but.isSelected()) {
				
			}else {
				
			}
			break;
		case 12:
			if (but.isSelected()) {
				
			}else {
				
			}
			break;
		case 13:
			if (but.isSelected()) {
				
			}else {
				
			}
		default:
			break;
		}
		
	}
	
	private static String getCurrentDay() {
		Date now = new Date();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        return (simpleDateformat.format(now));
	}
	
}
