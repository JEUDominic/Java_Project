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

public class xuexiao extends JFrame implements ActionListener{


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
		JLabel jtf;
	
	
		private JPanel panel = new JPanel();
		private JPanel panel2 = new JPanel();
		private Object ActionListener;
		private JLabel backImage=null;
		
		public xuexiao(){
			
			
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
			
		
			label2= new JLabel();//name de zi
			setLayout(null);
			label2.setText("<html><p>No such school. Do you want to create it?</p></html>");
			label2.setBounds(new Rectangle(100, 30, 1200, 100));
			label2.setFont(new Font("Century Gothic",0, 18));
			label2.setForeground(Color.white);
			tf2= new JTextField(10);
			contentPane.add(label2);

			
			ImageIcon img1=new ImageIcon("back.gif");
			img1.setImage(img1.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));

			doo= new JButton(img1);
			doo.setBounds(new Rectangle(100, 120, 130, 130));
			doo.setBorder(null);//�ؼ��裺ȥ����ť�߿�
			 doo.setContentAreaFilled(false);//�ؼ��裺ȥ����ť�߿�

			doo.addActionListener(this);
			doo.setActionCommand("Registration");
			contentPane.add(doo);
			doo.setFont(new Font("Century Gothic",0,12 ));
			
			ImageIcon img2=new ImageIcon("chuangjian.gif");
			img2.setImage(img2.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));
			end = new JButton(img2);
			end.setBounds(new Rectangle(300, 120, 130, 130));
			end.setBorder(null);//�ؼ��裺ȥ����ť�߿�
			 end.setContentAreaFilled(false);//�ؼ��裺ȥ����ť�߿�
			end.setFont(new Font("Century Gothic",0,12 ));
			end.addActionListener(this);
			end.setActionCommand("end");
			contentPane.add(end);
			setVisible(true);
		}
		

		public void actionPerformed(ActionEvent evt) {
			String actionCommand = evt.getActionCommand();
			if (actionCommand.equals("Registration")){
				this.dispose();
				new zhaoxuexiao();

			}
			else if(actionCommand.equals("end")){
				this.dispose();
				new Schoolinfo();
			}
		}
	}