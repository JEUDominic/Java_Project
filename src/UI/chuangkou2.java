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

public class chuangkou2 extends JFrame implements ActionListener{

		private int id;
		private JLabel label1=null;
		private JLabel label2=null;
		private JLabel label3=null;
		private JLabel label4=null;
		private JLabel label5=null;
		private JLabel label6=null;
		private JTextField tf6=null;
		private JTextField tf5=null;
		private JTextField tf4=null;
		private JTextField tf=null;
		private JTextField name=null;
		private JTextField studentID=null;
		private JTextField major=null;
		private JTextField state=null;
		private JButton end=null;
		private JButton doo=null;
		private JComboBox jc =null;
		private JComboBox jc2=null;
		private JRadioButton male = new JRadioButton("male",  true);
		private JRadioButton female = new JRadioButton("female", true);
		private JRadioButton jb3 = new JRadioButton("School");
		private JRadioButton jb4 = new JRadioButton("Company");
		private JRadioButton jb5 = new JRadioButton("At home");
		private JLabel backImage=null;
		private Container container = null;
		private Container contentPane  = null;
	
		private JPanel panel = new JPanel();
		private JPanel panel2 = new JPanel();
		private Object ActionListener;
		
		public  chuangkou2(int i){
			super("DOUBLKING");
			setLocationRelativeTo(null);
			if(i ==  1){
				
				container = super.getContentPane();
				setSize(550,550);
				setLocationRelativeTo(null);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				

				contentPane = getContentPane();

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
				
				label2= new JLabel();//name de zi
				setLayout(null);
				label2.setText("<html><p>Already have student with same student ID.</p></html>");
				label2.setBounds(new Rectangle(100, 0, 500, 100));
				label2.setFont(new Font("Century Gothic",0, 16));
				label2.setForeground(Color.white);
				tf= new JTextField(10);
				contentPane.add(label2);
				contentPane.add(tf);
			}
			
			yemian();
		}
		public  chuangkou2(){
			
			super("DOUBLKING");
			
			
			container = super.getContentPane();
			setSize(550,500);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			

			contentPane = getContentPane();

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
			yemian();
		
				
		}
		
		public void yemian(){
			
			
			
			label2= new JLabel();//name de kuang
			label2.setBounds(new Rectangle(100, 80, 1000, 25));
			name= new JTextField(20);
			contentPane.add(label2);
			contentPane.add(name);
			name.setBounds(new Rectangle(200, 70, 200, 25));
		
			label2= new JLabel();//name de zi
			setLayout(null);
			label2.setText("<html><p>Name</p></html>");
			label2.setBounds(new Rectangle(100, 30, 120, 100));
			label2.setFont(new Font("Century Gothic",0, 24));
			label2.setForeground(Color.white);
			tf= new JTextField(10);
			contentPane.add(label2);
			contentPane.add(tf);


			label1= new JLabel();//ID de kuang
			label1.setBounds(new Rectangle(100, 80, 1000, 25));
			studentID= new JTextField(11);
			contentPane.add(label1);
			contentPane.add(studentID);
			studentID.setBounds(new Rectangle(200, 120, 200, 25));
		
			label2= new JLabel();//ID de zi
			label2.setText("<html><p>ID</p></html>");
			label2.setBounds(new Rectangle(100, 80, 120, 100));
			label2.setFont(new Font("Century Gothic",0, 24));
			label2.setForeground(Color.white);
			tf= new JTextField(10);
			contentPane.add(label2);
			contentPane.add(tf);
		
			label3= new JLabel();//gender de kuang
			label3.setBounds(new Rectangle(100, 80, 1000, 25));
			
			panel.setLayout(new GridLayout(1, 3));
			ButtonGroup group = new ButtonGroup();
			group.add(this.male);
			group.add(this.female);
			panel.add(this.male);
			panel.add(this.female);
			container.add(panel);
			panel.setOpaque(false);
/* ********************************************************************** */
/* */			male.setBorder(null);									   //
/* */			female.setBorder(null);									   //
/* */			female.setContentAreaFilled(false);						   //
/* */			male.setContentAreaFilled(false);                          //
/* */			panel.setBounds(new Rectangle(220, 170, 200, 25));		   //
/* */			male.setFont(new Font("Century Gothic",0, 18));			   //
/* */			female.setFont(new Font("Century Gothic",0, 18));		   //
/* */			male.setForeground(Color.white);						   //
/* */			female.setForeground(Color.white);						   //
/* ********************************************************************** */		
			label2= new JLabel();//gender de zi
			label2.setText("<html><p>Gender</p></html>");
			label2.setBounds(new Rectangle(100, 130, 120, 100));
			label2.setFont(new Font("Century Gothic",0, 24));
			label2.setForeground(Color.white);
			tf= new JTextField(10);
			contentPane.add(label2);
			contentPane.add(tf);
		
			
			label4= new JLabel();//Major de kuang
			label4.setBounds(new Rectangle(100, 80, 1000, 25));
			major= new JTextField(50);
			contentPane.add(label4);
			contentPane.add(major);
			major.setBounds(new Rectangle(200, 220, 200, 25));

		
			label2= new JLabel();//major de zi
			label2.setText("<html><p>Major</p></html>");
			label2.setBounds(new Rectangle(100, 180, 120, 100));
			label2.setFont(new Font("Century Gothic",0, 24));
			label2.setForeground(Color.white);
			tf= new JTextField(10);
			contentPane.add(label2);
			contentPane.add(tf);
			
			label5= new JLabel();//Graduation Year de kuang
			label5.setBounds(new Rectangle(100, 80, 1000, 25));
			tf5= new JTextField(10);
			contentPane.add(label5);
			contentPane.add(tf5);
			


			JMenuBar menuBar = new JMenuBar();//zuo xia la cai dan
			jc = new JComboBox();
			getContentPane().add(menuBar);
			String[] arry = new String[12];
			


			int i=2005;
	        for (i=2005; i <= 2016; i++) {
	            arry[i-2005] = Integer.toString(i);
	            contentPane.add(jc);
	            jc.addItem(arry[i-2005]);
	        }
	       
			setVisible(true);
			
			jc.setFont(new Font("Century Gothic",0, 16));
			jc.setBounds(new Rectangle(250, 270, 120, 25));
		
			label2= new JLabel();//Graduation Year de zi
			label2.setText("<html><p>Graduation Year</p></html>");
			label2.setBounds(new Rectangle(100, 230, 120, 100));
			label2.setFont(new Font("Century Gothic",0, 16));
			label2.setForeground(Color.white);
			tf= new JTextField(10);
			contentPane.add(label2);
			contentPane.add(tf);
			
			label6= new JLabel();//Graduation Destination de kuang
			JMenuBar menuBar2 = new JMenuBar();//zuo xia la cai dan

			getContentPane().add(menuBar);
			jc2 = new JComboBox();


	        contentPane.add(jc2);
	        jc2.addItem("School");
	        jc2.addItem("Company");
	        jc2.addItem("At home");
						
			jc2.setFont(new Font("Century Gothic",0, 16));
			jc2.setBounds(new Rectangle(250, 320, 120, 25));
			
			label2= new JLabel();//Graduation Destination de zi
			label2.setText("<html><p>Graduation Destination</p></html>");
			label2.setBounds(new Rectangle(100, 280, 120, 100));
			label2.setFont(new Font("Century Gothic",0, 16));
			label2.setForeground(Color.white);
			tf= new JTextField(10);
			contentPane.add(label2);
			contentPane.add(tf);
			
			ImageIcon img1=new ImageIcon("back.gif");
			img1.setImage(img1.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));

			doo= new JButton(img1);
			doo.setBounds(new Rectangle(100, 350, 130, 130));
			doo.setBorder(null);
			 doo.setContentAreaFilled(false);

			doo.addActionListener(this);
			doo.setActionCommand("back");
			contentPane.add(doo);
			doo.setFont(new Font("Century Gothic",0,12 ));
			
			ImageIcon img2=new ImageIcon("xiayibu.gif");
			img2.setImage(img2.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));
			end = new JButton(img2);
			end.setBounds(new Rectangle(300, 350, 130, 130));
			end.setBorder(null);
			 end.setContentAreaFilled(false);
			end.setFont(new Font("Century Gothic",0,12 ));
			end.addActionListener(this);
			end.setActionCommand("next");
			contentPane.add(end);
			setVisible(true);
		}

		public void actionPerformed(ActionEvent evt) {
			String actionCommand = evt.getActionCommand();
			String s = jc2.getSelectedItem().toString(); 
			if (actionCommand.equals("next")) {
				int checkStudent = Validation.alumniCheck(studentID.getText());
				if( checkStudent == 1){
					this.dispose();
					new chuangkou2(1);
				}else{
				if(s.equals("At home")){
						this.dispose();
						if(male.isSelected()){
							Alumni alumni = new Alumni(studentID.getText(),name.getText(),1,major.getText(),0,Integer.parseInt(jc.getSelectedItem().toString()));
							if(Insert.alumni(alumni) >= 0) 
								new chenggong();
							
						}else{
							Alumni alumni = new Alumni(studentID.getText(),name.getText(),0,major.getText(),0,Integer.parseInt(jc.getSelectedItem().toString()));
							if(Insert.alumni(alumni) >= 0) 
								new chenggong();
						}
						
						
				}else if(s.equals("Company")){
					if(male.isSelected()){
						Alumni alumni = new Alumni(studentID.getText(),name.getText(),1,major.getText(),0,Integer.parseInt(jc.getSelectedItem().toString()));
						this.dispose();
						new company(alumni);	
					}else{
						
						Alumni alumni = new Alumni(studentID.getText(),name.getText(),0,major.getText(),0,Integer.parseInt(jc.getSelectedItem().toString()));
						this.dispose();
						new company(alumni);	
					}
				}else if(s.equals("School")){
					if(male.isSelected()){
						Alumni alumni = new Alumni(studentID.getText(),name.getText(),1,major.getText(),0,Integer.parseInt(jc.getSelectedItem().toString()));
						this.dispose();
						new school(alumni);	
					}else{
						
						Alumni alumni = new Alumni(studentID.getText(),name.getText(),0,major.getText(),0,Integer.parseInt(jc.getSelectedItem().toString()));
						this.dispose();
						new school(alumni);	
					}
				}
				
				}
			}else if(actionCommand.equals("back")){
				this.dispose();
				new zhujiemian();
			}		
		}
}
