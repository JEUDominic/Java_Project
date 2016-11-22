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

public class zhaoxuexiao extends JFrame implements ActionListener{


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
		private JTextArea tf3=null;
		private JButton end=null;
		private JButton doo=null;
		private JRadioButton jb1 = new JRadioButton("Name");
		private JRadioButton jb2 = new JRadioButton("City");
		private JRadioButton jb3 = new JRadioButton("Country");

		JLabel jtf;
	
	
		private JPanel panel = new JPanel();
		private JPanel panel2 = new JPanel();
		private Object ActionListener;
		private JLabel backImage=null;
		
		
		public  zhaoxuexiao(){
			


			
			super("DOUBLKING");
			Container container = super.getContentPane();
			setSize(550,350);
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
			
			label2= new JLabel();
			setLayout(null);
			label2.setText("<html><p>Search by </p></html>");
			label2.setBounds(new Rectangle(200, 0, 400, 100));
			label2.setFont(new Font("Century Gothic",0, 32));
			label2.setForeground(Color.white);
			contentPane.add(label2);
			
			label3= new JLabel();
			setLayout(null);
			label3.setBounds(new Rectangle(0, 50, 100, 25));
			
			panel.setLayout(new GridLayout(1, 3));
			ButtonGroup group = new ButtonGroup();
			group.add(this.jb1);
			group.add(this.jb3);
			group.add(this.jb2);
			panel.add(this.jb1);
			panel.add(this.jb3);
			panel.add(this.jb2);
			container.add(panel);
			panel.setBounds(new Rectangle(90, 90, 400, 25));
			jb1.setForeground(Color.white);
			jb2.setForeground(Color.white);
			jb3.setForeground(Color.white);
			jb1.setFont(new Font("Century Gothic",0, 26));
			jb2.setFont(new Font("Century Gothic",0, 26));
			jb3.setFont(new Font("Century Gothic",0, 26));
			panel.setOpaque(false);
			jb1.setBorder(null);
			jb2.setBorder(null);
			jb2.setContentAreaFilled(false);
			jb1.setContentAreaFilled(false);
			jb3.setBorder(null);
			jb3.setContentAreaFilled(false);
		
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
			end.setActionCommand("next");
			contentPane.add(end);
			setVisible(true);
				
		}
		

		public void actionPerformed(ActionEvent evt) {
			String actionCommand = evt.getActionCommand();
			if (actionCommand.equals("next")) {
				if(jb1.isSelected()){
					int a=2; // name...
					this.dispose();
					new searchSch(a);
				}else if(jb2.isSelected()){
					int a=1;// city...
					this.dispose();
					new searchSch(a);				
				}else if(jb3.isSelected()){
					int a=3;// country...
					this.dispose();
					new searchSch(a);					
				}
			}else if(actionCommand.equals("back")){
				this.dispose();
				new sousuo();
		}		
	}
}

