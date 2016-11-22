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
public class orgbiaoge extends JFrame implements ActionListener{


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
		private int state;
		private Organization o = null;
	
	
		private JPanel panel = new JPanel();
		private JPanel panel2 = new JPanel();
		private Object ActionListener;
		private JLabel backImage=null;
		
		public orgbiaoge(Organization o, int state){
			
			
			super("DOUBLKING");
			this.o = o;
			this.state = state;
			
		
			Container container = super.getContentPane();
			setSize(650,400);
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
			

		
			label1= new JLabel();//zhuangtai de zi
			label2= new JLabel();//zhuangtai de zi
			label3= new JLabel();//zhuangtai de zi
			label4= new JLabel();//zhuangtai de zi
			label5= new JLabel();//zhuangtai de zi
			label6= new JLabel();//zhuangtai de zi
			setLayout(null);
			 if(state == 1){
				 School school = (School)o;
			 
				label1.setText("<html><p>The Information about "+school.getName()+" </p></html>");
				label1.setBounds(new Rectangle(100, 0, 1200, 50));
				label1.setFont(new Font("Century Gothic",0, 18));
				label1.setForeground(Color.white);
				contentPane.add(label1);
				
				label2.setText("School Name: " + school.getName());
				label2.setBounds(new Rectangle(100, 50, 1200, 50));
				label2.setFont(new Font("Century Gothic",0, 18));
				label2.setForeground(Color.white);
				contentPane.add(label2);
				
				label3.setText("School country: " + school.getCountry());
				label3.setBounds(new Rectangle(100, 100, 1200, 50));
				label3.setFont(new Font("Century Gothic",0, 18));
				label3.setForeground(Color.white);
				contentPane.add(label3);
				
				label4.setText("School City: " + school.getCity());
				label4.setBounds(new Rectangle(100, 150, 1200, 50));
				label4.setFont(new Font("Century Gothic",0, 18));
				label4.setForeground(Color.white);
				contentPane.add(label4);
				
				if(school.getTop100() == 1){
					label5.setText("Top 100? : Yes" );
				}else{
					label5.setText("Top 100? : no" );
				}
				label5.setBounds(new Rectangle(100, 200, 1200, 50));
				label5.setFont(new Font("Century Gothic",0, 18));
				label5.setForeground(Color.white);
				contentPane.add(label5);
				
				ImageIcon img1=new ImageIcon("back.gif");
				img1.setImage(img1.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));

				doo= new JButton(img1);
				doo.setBounds(new Rectangle(400, 270, 130, 130));
				doo.setBorder(null);
				doo.setContentAreaFilled(false);

				doo.addActionListener(this);
				doo.setActionCommand("back");
				contentPane.add(doo);
				doo.setFont(new Font("Century Gothic",0,12 ));
							
				setVisible(true);
			}else if(state == 2){
				
			
				label1.setText("<html><p>The Information about "+o.getName()+" </p></html>");
				label1.setBounds(new Rectangle(100, 0, 1200, 50));
				label1.setFont(new Font("Century Gothic",0, 18));
				label1.setForeground(Color.white);
				contentPane.add(label1);
				
				label2.setText("Company Name: " + o.getName());
				label2.setBounds(new Rectangle(100, 50, 1200, 50));
				label2.setFont(new Font("Century Gothic",0, 18));
				label2.setForeground(Color.white);
				contentPane.add(label2);
				
				label3.setText("Company Country: " + o.getCountry());
				label3.setBounds(new Rectangle(100, 100, 1200, 50));
				label3.setFont(new Font("Century Gothic",0, 18));
				label3.setForeground(Color.white);
				contentPane.add(label3);
				
				label4.setText("Company City: " + o.getCity());
				label4.setBounds(new Rectangle(100, 150, 1200, 50));
				label4.setFont(new Font("Century Gothic",0, 18));
				label4.setForeground(Color.white);
				contentPane.add(label4);
				
				ImageIcon img1=new ImageIcon("back.gif");
				img1.setImage(img1.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));

				doo= new JButton(img1);
				doo.setBounds(new Rectangle(400, 220, 130, 130));
				doo.setBorder(null);
				doo.setContentAreaFilled(false);

				doo.addActionListener(this);
				doo.setActionCommand("back");
				contentPane.add(doo);
				doo.setFont(new Font("Century Gothic",0,12 ));
				
				setVisible(true);
			}
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			if (actionCommand.equals("back")){
				this.dispose();
				new zhujiemian();

			}
		}
};