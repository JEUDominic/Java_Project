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
public class stubiaoge extends JFrame implements ActionListener{


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
		private JTextField tf2=null;
		private JTextField tf3=null;
		private JButton end=null;
		private JButton doo=null;
		private Alumni alumni = null;
		private Organization o = null;
		private int state;
	
		private JPanel panel = new JPanel();
		private JPanel panel2 = new JPanel();
		private Object ActionListener;
		private JLabel backImage=null;
		
		public stubiaoge(Alumni  alumni){
			
			
			super("DOUBLKING");
			this.alumni = alumni;
	
			Container container = super.getContentPane();
			setSize(650,600);
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
			

		
			label1= new JLabel();//xuesheng de zi
			label2= new JLabel();//xuesheng de zi
			label3= new JLabel();//xuesheng de zi
			label4= new JLabel();//xuesheng de zi
			label5= new JLabel();//xuesheng de zi
			label6= new JLabel();//xuesheng de zi
			setLayout(null);
			if(alumni == null){
				label1.setText("<html><p>There is no such student in database.</p></html>");
				label1.setBounds(new Rectangle(100, 0, 1200, 100));
				label1.setFont(new Font("Century Gothic",0, 18));
				label1.setForeground(Color.white);
				contentPane.add(label1);


				
				ImageIcon img1=new ImageIcon("back.gif");
				img1.setImage(img1.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));

				doo= new JButton(img1);
				doo.setBounds(new Rectangle(100, 120, 130, 130));
				doo.setBorder(null);
				doo.setContentAreaFilled(false);

				doo.addActionListener(this);
				doo.setActionCommand("back");
				contentPane.add(doo);
				doo.setFont(new Font("Century Gothic",0,12 ));

				setVisible(true);
			}else{
				label1.setText("<html><p>This student went to school after graduation.</p></html>");
				label1.setBounds(new Rectangle(100, 0, 1200, 50));
				label1.setFont(new Font("Century Gothic",0, 18));
				label1.setForeground(Color.white);
				contentPane.add(label1);
				
				label2.setText("Student Name: " + alumni.getName());
				label2.setBounds(new Rectangle(100, 50, 1200, 50));
				label2.setFont(new Font("Century Gothic",0, 18));
				label2.setForeground(Color.white);
				contentPane.add(label2);
				
				label3.setText("Student ID: " + alumni.getStudentID());
				label3.setBounds(new Rectangle(100, 100, 1200, 50));
				label3.setFont(new Font("Century Gothic",0, 18));
				label3.setForeground(Color.white);
				contentPane.add(label3);
				
				if(alumni.getSex() == 1){
					label4.setText("Student gender: Male");
				}else{
					label4.setText("Student gender: Female");
				}
				label4.setBounds(new Rectangle(100, 150, 1200, 50));
				label4.setFont(new Font("Century Gothic",0, 18));
				label4.setForeground(Color.white);
				contentPane.add(label4);
				
				label6.setText("Graduation Year: " + alumni.getGraYear());
				setLayout(null);
				label6.setBounds(new Rectangle(100, 200, 1200, 50));
				label6.setFont(new Font("Century Gothic",0, 18));
				label6.setForeground(Color.white);
				contentPane.add(label6);	
				label6= new JLabel();//name de zi
				setLayout(null);
				label6.setBounds(new Rectangle(100, 200, 500, 100));
				label6.setFont(new Font("Century Gothic",0, 16));
				label6.setForeground(Color.white);
				tf= new JTextField(10);
				contentPane.add(label6);
				contentPane.add(tf);
				
				this.state = alumni.getState();
				if(alumni.getState() == 0){
					label5.setText("Grduation Destination: Home");
					label5.setBounds(new Rectangle(100, 250, 1200, 50));
					label5.setFont(new Font("Century Gothic",0, 18));
					label5.setForeground(Color.white);
					contentPane.add(label5);
					
				}else if(alumni.getState() == 1){
					label5.setText("Grduation Destination: School");
					label5.setBounds(new Rectangle(100, 250, 1200, 50));
					label5.setFont(new Font("Century Gothic",0, 18));
					label5.setForeground(Color.white);
					contentPane.add(label5);
		
					o = Search.orgnization(alumni.getID(), alumni.getState());
					label6.setText("School Name: " + o.getName());
					label6.setBounds(new Rectangle(100, 300, 1200, 50));
					label6.setFont(new Font("Century Gothic",0, 18));
					label6.setForeground(Color.white);
					contentPane.add(label6);
					
					end = new JButton("More information");
					end.setBounds(new Rectangle(100, 350 , 200, 20));
					end.setBorder(null);
					//end.setForeground(Color.white);
					//end.setContentAreaFilled(false);
					end.addActionListener(this);
					end.setActionCommand("more");
					contentPane.add(end);
					end.setFont(new Font("Century Gothic",0,16 ));
							
				}else if(alumni.getState() == 2){
					label5.setText("Grduation Destination: Company");
					label5.setBounds(new Rectangle(100, 250, 1200, 50));
					label5.setFont(new Font("Century Gothic",0, 18));
					label5.setForeground(Color.white);
					contentPane.add(label5);
					
					o = Search.orgnization(alumni.getID(), alumni.getState());
					label6.setText("Company Name: " + o.getName());
					label6.setBounds(new Rectangle(100, 300, 1200, 50));
					label6.setFont(new Font("Century Gothic",0, 18));
					label6.setForeground(Color.white);
					contentPane.add(label6);
					
					end = new JButton("More information");
					end.setBounds(new Rectangle(100, 350 , 200, 20));
					end.setBorder(null);
					//end.setForeground(Color.white);
					//end.setContentAreaFilled(false);
					setLayout(null);
					end.addActionListener(this);
					end.setActionCommand("more");
					contentPane.add(end);
					end.setFont(new Font("Century Gothic",0,16 ));
				}
				
				
				
				
				
				ImageIcon img1=new ImageIcon("back.gif");
				img1.setImage(img1.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));

				doo= new JButton(img1);
				doo.setBounds(new Rectangle(400, 400 , 130, 130));
				doo.setBorder(null);
				doo.setContentAreaFilled(false);

				doo.addActionListener(this);
				doo.setActionCommand("back");
				contentPane.add(doo);
				doo.setFont(new Font("Century Gothic",0,12 ));
							
				setVisible(true);
			
			}
			
		}
		

		public void actionPerformed(ActionEvent evt) {
			String actionCommand = evt.getActionCommand();
			if (actionCommand.equals("back")){
				this.dispose();
				new zhujiemian();

			}else if (actionCommand.equals("more")){
				this.dispose();
				new orgbiaoge(o,state);

			}
		}
	}