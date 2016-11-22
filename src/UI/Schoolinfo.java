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
import javax.swing.JTextField;

import Table.Company;
import Table.Alumni;
import Table.Organization;
import Table.School;

import Operation.Insert;
import Operation.Search;
import Operation.Count;
import Operation.Validation;
public class Schoolinfo extends JFrame implements ActionListener{


		private JLabel label1=null;
		private JLabel label2=null;
		private JLabel label3=null;
		private JTextField tf4=null;
		private JTextField tf=null;
		private JTextField tf2=null;
		private JTextField country=null;
		private JTextField city=null;
		private JButton end=null;
		private JButton doo=null;
		private JRadioButton jb1 = new JRadioButton("Yes",  true);
		private JRadioButton jb2 = new JRadioButton("No", true);
		private JPanel panel = new JPanel();
		private JLabel backImage=null;
		
		private Alumni alumni = null;
		private String name = null;
		
		public Schoolinfo(){
			
			super("DOUBLKING");
			yemian();
		
		}
		
		public  Schoolinfo(Alumni alumni,String name){
					
			super("DOUBLKING");
			this.alumni = alumni;
			this.name = name;
			yemian();
				
		}
		
		public void yemian(){
			Container container = super.getContentPane();
			setSize(550,480);
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
			
		
			
			label1= new JLabel();//country de kuang
			label1.setBounds(new Rectangle(100, 50, 1000, 25));
			country= new JTextField(11);
			contentPane.add(label1);
			contentPane.add(country);
			country.setBounds(new Rectangle(240, 100, 200, 25));
		
			label2= new JLabel();//country de zi
			label2.setText("<html><p>School Country:</p></html>");
			label2.setBounds(new Rectangle(100, 60, 180, 100));
			label2.setFont(new Font("Century Gothic",0, 16));
			label2.setForeground(Color.white);
			tf= new JTextField();
			contentPane.add(label2);
			contentPane.add(tf);

			label1= new JLabel();//city de kuang
			label1.setBounds(new Rectangle(100, 50, 1000, 25));
			city= new JTextField(40);
			contentPane.add(label1);
			contentPane.add(city);
			city.setBounds(new Rectangle(240, 150, 200, 25));
		
			label2= new JLabel();//city de zi
			label2.setText("<html><p>School City:</p></html>");
			label2.setBounds(new Rectangle(100, 110, 180, 100));
			label2.setFont(new Font("Century Gothic",0, 16));
			label2.setForeground(Color.white);
			tf= new JTextField();
			contentPane.add(label2);
			contentPane.add(tf);
			
			label2= new JLabel();//top100 de zi
			label2.setText("<html><p>If the school is the first 100? </p></html>");
			label2.setBounds(new Rectangle(100, 160, 400, 100));
			label2.setFont(new Font("Century Gothic",0, 18));
			label2.setForeground(Color.white);
			tf= new JTextField();
			contentPane.add(label2);
			contentPane.add(tf);
			
			label3= new JLabel();//top100 de kuang
			label3.setBounds(new Rectangle(100, 50, 1000, 25));
			
			panel.setLayout(new GridLayout(1, 3));
			ButtonGroup group = new ButtonGroup();
			group.add(this.jb1);
			group.add(this.jb2);
			panel.add(this.jb1);
			panel.add(this.jb2);
			container.add(panel);
			panel.setOpaque(false);
			jb1.setBorder(null);
			jb1.setContentAreaFilled(false);
			jb2.setBorder(null);
			jb2.setContentAreaFilled(false);
			panel.setBounds(new Rectangle(220, 240, 180, 25));
			jb1.setFont(new Font("Century Gothic",0, 14));
			jb2.setFont(new Font("Century Gothic",0, 14));
			jb1.setForeground(Color.white);
			jb2.setForeground(Color.white);
		

			
			ImageIcon img1=new ImageIcon("back.gif");
			img1.setImage(img1.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));
			doo= new JButton(img1);
			doo.setBounds(new Rectangle(100, 280, 130, 130));
			doo.setBorder(null);
			doo.setContentAreaFilled(false);
			doo.addActionListener(this);
			doo.setActionCommand("back");
			contentPane.add(doo);
			doo.setFont(new Font("Century Gothic",0,12 ));
			
			ImageIcon img2=new ImageIcon("xiayibu.gif");
			img2.setImage(img2.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));
			end = new JButton(img2);
			setLayout(null);
			end.setBounds(new Rectangle(300, 280, 130, 130));
			end.setBorder(null);
			end.setContentAreaFilled(false);
			end.addActionListener(this);
			end.setFont(new Font("Century Gothic",0,12 ));
			end.setActionCommand("next");
			contentPane.add(end);
			setVisible(true);
		}



		public void actionPerformed(ActionEvent evt) {
			String actionCommand = evt.getActionCommand();
			int id = 0;
			if (actionCommand.equals("next")){
				if(jb1.isSelected() == true){
					id = Insert.school(new School(name,country.getText(),city.getText(),1 ));
					if(id > 0){
						int checkValue = Insert.alumni(new Alumni(alumni.getStudentID(),alumni.getName(),alumni.getSex(),alumni.getMajor(),1,alumni.getGraYear(),id));
						if(checkValue == id){
							this.dispose();
							new chenggong();
						}
					}
				}else {
					id = Insert.school(new School(name,country.getText(),city.getText(),0 ));
					if(id > 0){
						int checkValue = Insert.alumni(new Alumni(alumni.getStudentID(),alumni.getName(),alumni.getSex(),alumni.getMajor(),1,alumni.getGraYear(),id));
						if(checkValue == id){
							this.dispose();
							new chenggong();
							}
						}
					}				
			}else if(actionCommand.equals("back")){
				this.dispose();
				new school(alumni);
			}		
		}
}	
