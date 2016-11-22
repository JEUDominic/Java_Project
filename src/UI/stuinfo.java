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
public class stuinfo extends JFrame implements ActionListener{


		private JLabel label2=null;
		private JTextField tf=null;
		private JTextField tf2=null;
		private JButton end=null;
		private JButton doo=null;
	
	
		private JLabel backImage=null;
		
		public stuinfo(){
			
			
			super("DOUBLKING");
			Container container = super.getContentPane();
			setSize(550,300);
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
			
			label2= new JLabel();//studentID de kuang
			label2.setBounds(new Rectangle(100, 50, 1000, 25));
			tf= new JTextField(10);
			contentPane.add(label2);
			contentPane.add(tf);
			tf.setBounds(new Rectangle(200, 80, 200, 25));
			String s = label2.getText(); 
		
			label2= new JLabel();//studenetID de zi
			setLayout(null);
			label2.setText("<html><p>Please input the Student ID: </p></html>");
			label2.setBounds(new Rectangle(100, 0, 1200, 100));
			label2.setFont(new Font("Century Gothic",0, 18));
			label2.setForeground(Color.white);
			tf2= new JTextField(10);
			contentPane.add(label2);
			contentPane.add(tf2);

			
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
			
			ImageIcon img2=new ImageIcon("xiayibu.gif");
			img2.setImage(img2.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));
			end = new JButton(img2);
			end.setBounds(new Rectangle(300, 120, 130, 130));
			end.setBorder(null);
			end.setContentAreaFilled(false);
			end.setFont(new Font("Century Gothic",0,12 ));
			end.addActionListener(this);
			end.setActionCommand("search");
			contentPane.add(end);
			setVisible(true);
		}
		

		public void actionPerformed(ActionEvent evt) {
			String actionCommand = evt.getActionCommand();
			String s=tf.getText().trim();
			if (actionCommand.equals("back")){
				this.dispose();
				new sousuo();
				

			}
			else if(actionCommand.equals("search")){
				Alumni alumni = Search.alumni(s);
					this.dispose();
					new stubiaoge(alumni);
				
			}
		}
	}