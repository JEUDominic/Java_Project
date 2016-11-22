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
public class schbiaoge extends JFrame implements ActionListener{


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
		private School[] school = null;
	
	
		private JPanel panel = new JPanel();
		private JPanel panel2 = new JPanel();
		private Object ActionListener;
		private JLabel backImage=null;
		
		

		public schbiaoge(School[] school){
			
			
			super("DOUBLKING");
			this.school = school;
			
			Container container = super.getContentPane();
			setSize(550,500);
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
			label2.setText("<html><p>Schools Satisfied Condition:</p></html>");
			label2.setBounds(new Rectangle(20, 0, 1200, 100));
			label2.setFont(new Font("Century Gothic",0, 18));
			label2.setForeground(Color.white);
			contentPane.add(label2);
			
			label3 = new JLabel();// biaoge
			setLayout(null);
			String html = new String("<html><table broder=\"1\"> <tr> <td>School Name | </td> <td> School Country  | </td> <td> School City  | </td> <td>top100</td> </tr>");
			int i = 0;
			do{
				html = html + "<tr> <td>" + school[i].getName() + "</td> <td> " + school[i].getCountry() + " </td> <td>" + school[i].getCity() + "</td> <td>";;
				if(school[i].getTop100() == 1){
					html = html + "Yes</td></tr>";
				}else{
					html = html + "No</td></tr>";
				}
				i++;
			}while(school[i] != null);
			html = html + "</html>";
			label3.setText(html);
			label3.setBounds(new Rectangle(20, 80, 1200, 100));
			label3.setFont(new Font("Century Gothic",0, 18));
			label3.setForeground(Color.white);
			contentPane.add(label3);
			
			ImageIcon img1=new ImageIcon("back.gif");
			img1.setImage(img1.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));

			doo= new JButton(img1);
			doo.setBounds(new Rectangle(300, 330, 130, 130));
			doo.setBorder(null);
			doo.setContentAreaFilled(false);
			setLayout(null);
			doo.addActionListener(this);
			doo.setActionCommand("back");
			contentPane.add(doo);
			doo.setFont(new Font("Century Gothic",0,12 ));
			
			
			setVisible(true);
		}
		

		public void actionPerformed(ActionEvent evt) {
			String actionCommand = evt.getActionCommand();
			if (actionCommand.equals("back")){
				this.dispose();
				new zhujiemian();

			}
		}
	}