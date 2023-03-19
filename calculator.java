package calculator;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

public class calculator extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	int nr_operatori=0;
	boolean flag=false;
	private JTextField textField_2;
	boolean flag_2=false;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator frame = new calculator();
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
	public calculator()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * schimbam iconita de la mouse
		 */
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("cursor.png").getImage(),
				new Point(0,0),"custom cursor"));
	

		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(39, 404, 131, 49);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("2");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(175, 404, 131, 49);
		contentPane.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(314, 404, 116, 49);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setBounds(44, 322, 104, 39);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("5");
		btnNewButton_4.addActionListener(this);
		btnNewButton_4.setBounds(175, 314, 104, 39);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("6");
		btnNewButton_5.addActionListener(this);
		btnNewButton_5.setBounds(314, 306, 104, 55);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("7");
		btnNewButton_6.addActionListener(this);
		btnNewButton_6.setBounds(44, 237, 104, 49);
		contentPane.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("8");
		btnNewButton_7.addActionListener(this);
		btnNewButton_7.setBounds(181, 237, 98, 49);
		contentPane.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("9");
		btnNewButton_8.addActionListener(this);
		btnNewButton_8.setBounds(314, 237, 104, 49);
		contentPane.add(btnNewButton_8);

		textField = new JTextField();
		textField.setBounds(39, 10, 493, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_9 = new JButton("+");
		btnNewButton_9.addActionListener(this);
		btnNewButton_9.setBounds(39, 170, 109, 47);
		contentPane.add(btnNewButton_9);


		JButton btnNewButton_10 = new JButton("-");
		btnNewButton_10.addActionListener(this);
		btnNewButton_10.setBounds(181, 170, 98, 47);
		contentPane.add(btnNewButton_10);

		JButton btnNewButton_11 = new JButton("*");
		btnNewButton_11.addActionListener(this);
		btnNewButton_11.setBounds(311, 170, 119, 47);
		contentPane.add(btnNewButton_11);

		textField_1 = new JTextField();
		textField_1.setBounds(210, 35, 116, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton_12 = new JButton("delete 1");
		btnNewButton_12.addActionListener(this);

		btnNewButton_12.setBounds(460, 110, 85, 50);
		contentPane.add(btnNewButton_12);

		JButton btnNewButton_13 = new JButton("/");
		btnNewButton_13.addActionListener(this);
		btnNewButton_13.setBounds(440, 170, 105, 47);
		contentPane.add(btnNewButton_13);

		JButton btnNewButton_14 = new JButton("delete tot");
		btnNewButton_14.addActionListener(this);
		btnNewButton_14.setBounds(335, 110, 95, 50);
		contentPane.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("=");
		btnNewButton_15.addActionListener(this);
		btnNewButton_15.setBounds(460, 404, 85, 49);
		contentPane.add(btnNewButton_15);

		textField_2 = new JTextField();
		textField_2.setBounds(39, 72, 506, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_16 = new JButton(".");
		btnNewButton_16.addActionListener(this);
		btnNewButton_16.setBounds(460, 237, 85, 49);
		contentPane.add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("0");
		btnNewButton_17.addActionListener(this);
		btnNewButton_17.setBounds(460, 314, 85, 38);
		contentPane.add(btnNewButton_17);



	}



	public void actionPerformed(ActionEvent e)
	{
		try
		{
		if(e.getActionCommand().equals("delete tot") || flag_2)
		{
			/**
			 * delete tot inseamna reset pentru calculator
			 */
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			nr_operatori=0;
			flag=false;
			flag_2=false;
		}
		else if(e.getActionCommand().equals("delete 1"))
		{
			if(nr_operatori==0)
			{
				textField.setText(textField.getText().substring(0, textField.getText().length()-1));
				/**
				 * stergem cate un element formand un nou string care e cel vechi mai putin ultimul element
				 */
			}
			else if(nr_operatori==1)
			{
				textField_2.setText(textField_2.getText().substring(0, textField_2.getText().length()-1));
				/**
				 * stergem cate un element formand un nou string care e cel vechi mai putin ultimul element
				 */
			}

		}
		else
		{
			/**
			 * daca introducem o operatie fara sa introducem un numar ni se pune automat un 0 in prima casuta text
			 */
			if(nr_operatori>0 && textField.getText().equals(""))
				textField.setText("0");
			/**
			 * daca apasam pe un buton a carui nume este un operator  el este introdus in casuta text 1 si se incrementeaza numarul de operatori care ne indica daca scriem in prima sau in a doua casuta
			 */
			if (e.getActionCommand().equals("/") || e.getActionCommand().equals("*") || e.getActionCommand().equals("-") || e.getActionCommand().equals("+") || e.getActionCommand().equals("="))
			{
				if(flag==false || e.getActionCommand().equals("="))
				{
					textField_1.setText((textField_1.getText()+e.getActionCommand()));
					nr_operatori++;
				}
				else
				{
					flag=false;
					textField_1.setText(e.getActionCommand());
					textField_2.setText("");
				}
			}
			else
			{
				/**
				 * daca apasam pe un buton care reprezinta un numar el este introdus in casuta 0 sau casuta 2 in fucntie de numarul de operatori
				 */
				if(nr_operatori==1)
				{
					textField_2.setText(textField_2.getText()+e.getActionCommand());
				}
				else
				{
					textField.setText(textField.getText()+e.getActionCommand());
				}

			}
			/**
			 * cand apasam pe al doilea operator ni se executa operatia precedenta
			 */
			if(nr_operatori>=2) 
			{
				/**
				 * testam cazul in care causta 2 de text nu are nimic in ea dar incercam sa efectuam o operatie
				 */
				if(textField_2.getText().equals(""))
				{
					textField_1.setText(textField_1.getText().substring(1));
					nr_operatori--;
					textField.setText("");
				}
				else
				{
				float i,i2;
				i=Float.parseFloat(textField.getText());
				i2=Float.parseFloat(textField_2.getText());
				
				switch(textField_1.getText().charAt(0)) {
				case '+':
					/**
					 * daca numarul e foarte mare schimbam pe format stiintific
					 */
					if((i+i2)>10000000 ||(i+i2)<-10000000) 
						textField.setText(String.format("%9.3E",i2+i));
					else
						textField.setText(String.valueOf(i2+i));
					nr_operatori--;
					if(textField_1.getText().charAt(1)!='=') {
						textField_1.setText(textField_1.getText().substring(1));
						textField_2.setText("");
					}
					else
					{
						flag=true;
						textField_1.setText(""+textField_1.getText().charAt(0));

					}
					break;
				case '*':

					if((i*i2)>10000000 ||(i*i2)<-10000000)
						textField.setText(String.format("%9.3E",i2*i));
					else
						textField.setText(String.valueOf(i2*i));
					nr_operatori--;
					if(textField_1.getText().charAt(1)!='=') {
						textField_1.setText(textField_1.getText().substring(1));
						textField_2.setText("");
					}
					else
					{
						flag=true;
						textField_1.setText(""+textField_1.getText().charAt(0));

					}
					break;
				case '-':

					if((i-i2)>10000000 ||(i-i2)<-10000000)
						textField.setText(String.format("%9.3E",i-i2));
					else
						textField.setText(String.valueOf(i-i2));
					nr_operatori--;
					if(textField_1.getText().charAt(1)!='=') {
						textField_1.setText(textField_1.getText().substring(1));
						textField_2.setText("");
					}
					else
					{
						flag=true;
						textField_1.setText(""+textField_1.getText().charAt(0));

					}
					break;
				case '/':


					if(i2==0)
					{
						/**
						 * tratarea cazului de exceptie cu impartirea la 0
						 */
						textField.setText("impartirea la zero nu e acceptata , te rog apasa orice buton pentru a incepe iar");
						flag_2=true;
						break;
					}
					if((i/i2)>10000000 ||(i/i2)<-10000000)
						textField.setText(String.format("%9.3E",i/i2));
					else
						textField.setText(String.valueOf(i/i2));
					nr_operatori--;
					if(textField_1.getText().charAt(1)!='=') {
						textField_1.setText(textField_1.getText().substring(1));
						textField_2.setText("");
					}
					else
					{
						flag=true;
						textField_1.setText(""+textField_1.getText().charAt(0));

					}
					break;
				}

				}


			}

		}

	}
	
	catch(Exception e2)
	{	
		/**
		 * tratare exceptie cu try catch , in cazul in care apar probleme neprevazute avem un pop up care ne reseteaza calculatorul
		 */
		java.awt.Toolkit.getDefaultToolkit().beep();
		flag_2=true;
		int result=JOptionPane.showConfirmDialog(this, "ceva nu merge , vom reseta calculatorul ", "mesaj de eroare,", JOptionPane.DEFAULT_OPTION);
		
		
		if (result == JOptionPane.OK_OPTION)
		{
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			nr_operatori=0;
			flag=false;
			flag_2=false;
		}

			
		
	}
	}
}

