package UI;
import java.awt.*; 
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class zhujiemian extends JFrame implements ActionListener{



	private JLabel label1=null;
	private JLabel label2=null;
	private JLabel label3=null;
	private JLabel backImage=null;
	private JTextField tf=null;
	private JPasswordField tf2=null;
	private JButton end=null;
	private JButton doo=null;
	private JButton tongji=null;

	
	
	public zhujiemian(){
		


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
		backImage.setBounds(new Rectangle(0, 0, 1000, 1000));

		
		
		
		label2= new JLabel();
		setLayout(null);
		label2.setText("<html><p>Welcome GIGI</p></html>");
		label2.setBounds(new Rectangle(80, 00, 1000, 250));
		label2.setFont(new Font("Century Gothic",0, 52));
		label2.setForeground(Color.white);
		tf= new JTextField(10);
		contentPane.add(label2);
		contentPane.add(tf);
		



		ImageIcon img1=new ImageIcon("anniu1.gif");
		img1.setImage(img1.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));

		doo= new JButton(img1);
		doo.setBounds(new Rectangle(80, 170, 130, 130));
		doo.setBorder(null);
		 doo.setContentAreaFilled(false);

		doo.addActionListener(this);
		doo.setActionCommand("tianjia");
		contentPane.add(doo);
		doo.setFont(new Font("Century Gothic",0,12 ));
		
		ImageIcon img2=new ImageIcon("anniu2.gif");
		img2.setImage(img2.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));
		end = new JButton(img2);
		end.setBounds(new Rectangle(220, 170, 130, 130));
		end.setBorder(null);
		 end.setContentAreaFilled(false);
		end.setFont(new Font("Century Gothic",0,12 ));
		end.addActionListener(this);
		end.setActionCommand("sousuo");
		contentPane.add(end);
		
		ImageIcon img3=new ImageIcon("tongji.gif");
		img3.setImage(img3.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
		tongji = new JButton(img3);
		tongji.setBounds(new Rectangle(360, 170, 130, 130));
		tongji.setBorder(null);
		tongji.setContentAreaFilled(false);
		tongji.setFont(new Font("Century Gothic",0,12 ));
		tongji.addActionListener(this);
		tongji.setActionCommand("tongji");
		contentPane.add(tongji);
		setVisible(true);
	}
	

	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();
		if (actionCommand.equals("sousuo")) {
			this.dispose();
			new sousuo();
			}
		else if(actionCommand.equals("tianjia")){
			this.dispose();
			new chuangkou2();

	}else if(actionCommand.equals("tongji")){
			this.dispose();
			new tongji(-1,1);

		}
			
	}
	

}

