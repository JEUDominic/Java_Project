package UI;
import java.applet.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Table.Company;
import Table.Alumni;
import Table.Organization;
import Table.School;

import Operation.Insert;
import Operation.Search;
import Operation.Count;
import Operation.Validation;

public class Companyinfo extends JFrame implements ActionListener{


		private JLabel label1=null;
		private JLabel label2=null;
		private JTextField tf=null;
		private JTextField country=null;
		private JTextField city=null;
		private JButton end=null;
		private JButton doo=null;
		private JLabel backImage=null;
		private Alumni alumni = null;
		private String name = null;

		JLabel jtf;
	
	
		private JPanel panel = new JPanel();
		private JPanel panel2 = new JPanel();
		private Object ActionListener;
		

		public  Companyinfo(){
			
			super("DOUBLKING");

			yemian();
		}
		public  Companyinfo(Alumni alumni, String name){
			
			super("DOUBLKING");
			this.alumni = alumni;
			this.name = name;
			yemian();
		}
		
		public void yemian(){
			
			Container container = super.getContentPane();
			setSize(550,400);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
						
			Container contentPane = getContentPane();

			contentPane.setLayout(new FlowLayout( ));
			
			ImageIcon background = new ImageIcon("/beijing.jpg"); 
			backImage= new JLabel();
			setLayout(null);
			background = new ImageIcon("beijing.jpg");
			backImage = new JLabel(background);
			backImage.setBounds(0, 0, background.getIconWidth(),
			background.getIconHeight());
			JPanel backPanel = (JPanel) this.getContentPane();
			backPanel.setOpaque(false);
			this.getLayeredPane().setLayout(null);
			this.getLayeredPane().add(backImage, new Integer(Integer.MIN_VALUE));
			backPanel.setLayout(new BorderLayout());
			backImage.setBounds(new Rectangle(0, 0, 1000,1000));


			label1= new JLabel();//Country de kuang
			label1.setBounds(new Rectangle(100, 50, 1000, 25));
			country= new JTextField(40);
			contentPane.add(label1);
			contentPane.add(country);
			country.setBounds(new Rectangle(260, 100, 200, 25));
		
			label2= new JLabel();//Country de zi
			label2.setText("<html><p>Company Country:</p></html>");
			label2.setBounds(new Rectangle(100, 60, 180, 100));
			label2.setFont(new Font("Century Gothic",0, 16));
			label2.setForeground(Color.white);
			tf= new JTextField();
			contentPane.add(label2);
			contentPane.add(tf);

			label1= new JLabel();//City de kuang
			label1.setBounds(new Rectangle(100, 50, 1000, 25));
			city= new JTextField(40);
			contentPane.add(label1);
			contentPane.add(city);
			city.setBounds(new Rectangle(260, 150, 200, 25));
		
			label2= new JLabel();//City de zi
			label2.setText("<html><p>Company City:</p></html>");
			label2.setBounds(new Rectangle(100, 110, 180, 100));
			label2.setFont(new Font("Century Gothic",0, 16));
			label2.setForeground(Color.white);
			tf= new JTextField();
			contentPane.add(label2);
			contentPane.add(tf);
			
		
			
			
			
			ImageIcon img1=new ImageIcon("back.gif");
			img1.setImage(img1.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));

			doo= new JButton(img1);
			doo.setBounds(new Rectangle(100, 220, 130, 130));
			doo.setBorder(null);
			doo.setContentAreaFilled(false);

			doo.addActionListener(this);
			doo.setActionCommand("back");
			contentPane.add(doo);
			doo.setFont(new Font("Century Gothic",0,12 ));
			
			ImageIcon img2=new ImageIcon("xiayibu.gif");
			img2.setImage(img2.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));
			end = new JButton(img2);
			end.setBounds(new Rectangle(300, 220, 130, 130));
			setLayout(null);
			end.setBorder(null);
			 end.setContentAreaFilled(false);
			end.setFont(new Font("Century Gothic",0,12 ));
			end.addActionListener(this);
			end.setActionCommand("save");
			contentPane.add(end);
			setVisible(true);
			
		}
		

		public void actionPerformed(ActionEvent evt) {
			String actionCommand = evt.getActionCommand();
			if (actionCommand.equals("save")) {
				int id = Insert.company(new Company(name,country.getText(),city.getText()));
				if(id > 0){
					int checkValue = Insert.alumni(new Alumni(alumni.getStudentID(),alumni.getName(),alumni.getSex(),alumni.getMajor(),2,alumni.getGraYear(),id));
					if(checkValue == id){
						this.dispose();
						new chenggong();
					}
				}

			}
			
			else if(actionCommand.equals("back")){
				this.dispose();
				new company(alumni);
			}		
		}
}