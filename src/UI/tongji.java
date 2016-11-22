package UI;

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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Operation.Search;
import Table.Company;
import Table.Alumni;
import Table.Organization;
import Table.School;

import Operation.Insert;
import Operation.Search;
import Operation.Count;
import Operation.Validation;



import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.demo.PieChartDemo1;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class tongji extends JFrame implements ActionListener{

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
		private int year;
		private int page; //1 for all, 2 for school, 3 for company, 4 for china, 5 for oversea...
		JLabel jtf;
		ChartPanel piechart;
		ChartPanel piechart2;
		Container contentPane = getContentPane();
		private JPanel panel = new JPanel();
		private JPanel panel2 = new JPanel();
		private Object ActionListener;
		
		
		public  tongji(int year,int page){
			


			
			super("DOUBLKING");
			this.year = year;
			this.page = page;
			Container container = super.getContentPane();
			setSize(1000,600);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			

			

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
			
			
			


			JMenuBar selectYear = new JMenuBar();//zuo xia la cai dan
			jc = new JComboBox();
			getContentPane().add(selectYear);
			String[] arry = new String[5];
			

			arry[0] = "All Students";
			arry[1] = "Company";
			arry[2] = "School";
			arry[3] = "Oversea";
			arry[4] = "China";
			for(int i = 0;i<5;i++ ){
				contentPane.add(jc);
				jc.addItem(arry[i]);
			}
	       
			
			jc.setFont(new Font("Century Gothic",0, 16));
			jc.setBounds(new Rectangle(250, 45, 200, 25));
			
			JMenuBar select = new JMenuBar();//zuo xia la cai dan
			jc2 = new JComboBox();
			getContentPane().add(select);
			String[] array = new String[13];	


			array[0] = "All Years";
			jc2.addItem(array[0]);
	        for (int i=2005; i <= 2016; i++) {
	            array[i-2004] = Integer.toString(i);
	            contentPane.add(jc2);
	            jc2.addItem(array[i-2004]);
	        }
	       
	        setLayout(null);
			jc2.setFont(new Font("Century Gothic",0, 16));
			jc2.setBounds(new Rectangle(500, 45, 200, 25));
		
			label2= new JLabel();//Graduation Year de zi
			setLayout(null);
			label2.setText("<html><p>Selected in :</p></html>");
			label2.setBounds(new Rectangle(100, 10, 150, 100));
			label2.setFont(new Font("Century Gothic",0, 16));
			label2.setForeground(Color.white);
			tf= new JTextField(10);
			contentPane.add(label2);
			contentPane.add(tf);		
			
			ImageIcon img1=new ImageIcon("back.gif");
			img1.setImage(img1.getImage().getScaledInstance(120,60,Image.SCALE_DEFAULT));

			doo= new JButton(img1);
			setLayout(null);
			doo.setBounds(new Rectangle(250, 420, 130, 130));
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
			end.setBounds(new Rectangle(600, 420, 130, 130));
			end.setBorder(null);
			end.setContentAreaFilled(false);
			end.setFont(new Font("Century Gothic",0,12 ));
			end.addActionListener(this);
			end.setActionCommand("next");
			contentPane.add(end);
			
	        if( page == 1){
	        	drawPanel1_1();// home school company
	        	drawPanel1_2();// oversea china
	        }else if( page == 2){// School
	        	drawPanel2_1();// top100 not top100
	        	drawPanel2_2();// oversea china
	        }else if(page == 3){// company
	        	drawPanel3_1();// china oversea
	        }else if(page == 4){// china
	        	drawPanel4_1();// school company
	        }else if(page == 5){// oversea
	        	drawPanel5_1();//school company
	        }
	        
	        setVisible(true);
			
		
				
		}
		

		public void actionPerformed(ActionEvent evt) {
			String actionCommand = evt.getActionCommand();
			String s = jc2.getSelectedItem().toString(); 
			String ss = jc.getSelectedItem().toString(); 
			if (actionCommand.equals("next")) {
				if(s.equals("All Years")){
					if(ss.equals("All Students")){
						this.dispose();
						new tongji(-1,1);
					}
					if(ss.equals("School")){
						this.dispose();
						new tongji(-1,2);
					}else if(ss.equals("Company")){
						this.dispose();
						new tongji(-1,3);
					}else if(ss.equals("China")){
						this.dispose();
						new tongji(-1,4);
					}else if(ss.equals("Oversea")){
						this.dispose();
						new tongji(-1,5);
					}
						
				}else{
					if(ss.equals("All Students")){
						this.dispose();
						int a = Integer.parseInt(s);
						new tongji(a,1);
					}
					if(ss.equals("School")){
						this.dispose();
						int a = Integer.parseInt(s);
						new tongji(a,2);
					}else if(ss.equals("Company")){
						this.dispose();
						int a = Integer.parseInt(s);
						new tongji(a,3);
					}else if(ss.equals("China")){
						this.dispose();
						int a = Integer.parseInt(s);
						new tongji(a,4);
					}else if(ss.equals("Oversea")){
						this.dispose();
						int a = Integer.parseInt(s);
						new tongji(a,5);
					}
					
				
				}
				
			}else if(actionCommand.equals("back")){
				this.dispose();
				new zhujiemian();
			}		
		}
		public void drawPanel1_1(){
			String title =  "Anylysis Graduation's Destination in " ;
			if(year == -1){
				 title = title + "all year";
			}else{
				 title = title + year;
			}
			JFreeChart chart = ChartFactory.createPieChart3D(title, getDataset1_1(),
	                true, false, false);
	        PiePlot piePlot = (PiePlot) chart.getPlot();
	        DecimalFormat df = new DecimalFormat("0.00%");
	        NumberFormat nf = NumberFormat.getInstance();

	        StandardPieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
	                "{0} {2}",                   //鑾峰緱StandardPieSectionLabelGenerator瀵硅薄,鐢熸垚鐨勬牸寮忥紝{0}琛ㄧずsection鍚嶏紝
	                //{1}琛ㄧずsection鐨勫�硷紝{2}琛ㄧず鐧惧垎姣斻�傚彲浠ヨ嚜瀹氫箟   
	                nf, df);
	        piePlot.setLabelGenerator(generator);// Set bai fen bi...
	        piePlot.setLabelFont(new Font("榛戜綋", Font.ITALIC, 20));

	        // When there is no data in database..
	        piePlot.setNoDataMessage("There is no satiesfied data in database.");
	        piePlot.setCircular(false);
	        piePlot.setLabelGap(0.02D);

	        
	        piePlot.setIgnoreZeroValues(true);

	        panel = new ChartPanel(chart, true);
	        chart.getTitle().setFont(new Font("Century Gothic", Font.BOLD, 18));
	        chart.getLegend().setItemFont(new Font("Century Gothic", Font.BOLD, 20));
	        panel.setBounds(new Rectangle(50, 100, 400, 300));
	        contentPane.add(panel);
		}
		
		
		public DefaultPieDataset getDataset1_1() {
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("Company",Count.company(-1, year));
	        dataset.setValue("School", Count.school(-1, year));
	        dataset.setValue("Home", Count.home(year));
	        return dataset;
	    }
		
		public void drawPanel1_2(){
			String title = "Anylysis Not At Home Graduation's Destination in ";
			if(year == -1){
				 title = title + "all year";
			}else{
				 title = title + year;
			}
			JFreeChart chart2 = ChartFactory.createPieChart3D(title, getDataset1_2(),
	                true, false, false);
	        PiePlot piePlot2 = (PiePlot) chart2.getPlot();
	        DecimalFormat df2 = new DecimalFormat("0.00%");
	        NumberFormat nf2 = NumberFormat.getInstance();

	        StandardPieSectionLabelGenerator generator2 = new StandardPieSectionLabelGenerator(
	                "{0} {2}",                   //鑾峰緱StandardPieSectionLabelGenerator瀵硅薄,鐢熸垚鐨勬牸寮忥紝{0}琛ㄧずsection鍚嶏紝
	                //{1}琛ㄧずsection鐨勫�硷紝{2}琛ㄧず鐧惧垎姣斻�傚彲浠ヨ嚜瀹氫箟   
	                nf2, df2);
	        piePlot2.setLabelGenerator(generator2);// Set bai fen bi...
	        piePlot2.setLabelFont(new Font("榛戜綋", Font.ITALIC, 20));

	        // When there is no data in database..
	        piePlot2.setNoDataMessage("There is no satiesfied data in database.");
	        piePlot2.setCircular(false);
	        piePlot2.setLabelGap(0.02D);

	        
	        piePlot2.setIgnoreZeroValues(true);

	        panel2 = new ChartPanel(chart2, true);
	        chart2.getTitle().setFont(new Font("Century Gothic", Font.BOLD, 18));
	        chart2.getLegend().setItemFont(new Font("Century Gothic", Font.BOLD, 20));
	        panel2.setBounds(new Rectangle(500, 100, 400, 300));
	        contentPane.add(panel2);
		}
		
		public DefaultPieDataset getDataset1_2() {
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("Oversea",Count.company(1, year) + Count.school(1, year));
	        dataset.setValue("China", Count.company(0, year) + Count.school(0, year));
	        return dataset;
	    }
		
		public void drawPanel2_1(){
			String title = "Anylysis At School Graduation's Destination in ";
			if(year == -1){
				 title = title + "all year";
			}else{
				 title = title + year;
			}
			JFreeChart chart = ChartFactory.createPieChart3D(title, getDataset2_1(),
	                true, false, false);
	        PiePlot piePlot = (PiePlot) chart.getPlot();
	        DecimalFormat df = new DecimalFormat("0.00%");
	        NumberFormat nf = NumberFormat.getInstance();

	        StandardPieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
	                "{0} {2}",                   //鑾峰緱StandardPieSectionLabelGenerator瀵硅薄,鐢熸垚鐨勬牸寮忥紝{0}琛ㄧずsection鍚嶏紝
	                //{1}琛ㄧずsection鐨勫�硷紝{2}琛ㄧず鐧惧垎姣斻�傚彲浠ヨ嚜瀹氫箟   
	                nf, df);
	        piePlot.setLabelGenerator(generator);// Set bai fen bi...
	        piePlot.setLabelFont(new Font("榛戜綋", Font.ITALIC, 20));

	        // When there is no data in database..
	        piePlot.setNoDataMessage("There is no satiesfied data in database.");
	        piePlot.setCircular(false);
	        piePlot.setLabelGap(0.02D);

	        
	        piePlot.setIgnoreZeroValues(true);

	        panel = new ChartPanel(chart, true);
	        chart.getTitle().setFont(new Font("Century Gothic", Font.BOLD, 18));
	        chart.getLegend().setItemFont(new Font("Century Gothic", Font.BOLD, 20));
	        panel.setBounds(new Rectangle(80, 100, 400, 300));
	        contentPane.add(panel);
		}
		
		
		public DefaultPieDataset getDataset2_1() {
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("Top 100",Count.top100(1, year));
	        dataset.setValue("Not Top 100", Count.school(0, year));
	        return dataset;
	    }
		
		public void drawPanel2_2(){
			String title = "Anylysis  At School Graduation's Destination in ";
			if(year == -1){
				 title = title + "all year";
			}else{
				 title = title + year;
			}
			JFreeChart chart2 = ChartFactory.createPieChart3D(title, getDataset1_2(),
	                true, false, false);
	        PiePlot piePlot2 = (PiePlot) chart2.getPlot();
	        DecimalFormat df2 = new DecimalFormat("0.00%");
	        NumberFormat nf2 = NumberFormat.getInstance();

	        StandardPieSectionLabelGenerator generator2 = new StandardPieSectionLabelGenerator(
	                "{0} {2}",                   //鑾峰緱StandardPieSectionLabelGenerator瀵硅薄,鐢熸垚鐨勬牸寮忥紝{0}琛ㄧずsection鍚嶏紝
	                //{1}琛ㄧずsection鐨勫�硷紝{2}琛ㄧず鐧惧垎姣斻�傚彲浠ヨ嚜瀹氫箟   
	                nf2, df2);
	        piePlot2.setLabelGenerator(generator2);// Set bai fen bi...
	        piePlot2.setLabelFont(new Font("榛戜綋", Font.ITALIC, 20));

	        // When there is no data in database..
	        piePlot2.setNoDataMessage("There is no satiesfied data in database.");
	        piePlot2.setCircular(false);
	        piePlot2.setLabelGap(0.02D);

	       
	        piePlot2.setIgnoreZeroValues(true);

	        panel2 = new ChartPanel(chart2, true);
	        chart2.getTitle().setFont(new Font("Century Gothic", Font.BOLD, 18));
	        chart2.getLegend().setItemFont(new Font("Century Gothic", Font.BOLD, 20));
	        panel2.setBounds(new Rectangle(500, 100, 400, 300));
	        contentPane.add(panel2);
		}
		
		public DefaultPieDataset getDataset2_2() {
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("Oversea",Count.school(1, year));
	        dataset.setValue("China", Count.school(0, year));
	        return dataset;
	    }
		
		public void drawPanel3_1(){
			String title = "Anylysis In Company Graduation's Destination in ";
			if(year == -1){
				 title = title + "all year";
			}else{
				 title = title + year;
			}
			JFreeChart chart = ChartFactory.createPieChart3D(title, getDataset3_1(),
	                true, false, false);
	        PiePlot piePlot = (PiePlot) chart.getPlot();
	        DecimalFormat df = new DecimalFormat("0.00%");
	        NumberFormat nf = NumberFormat.getInstance();

	        StandardPieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
	                "{0} {2}",                   //鑾峰緱StandardPieSectionLabelGenerator瀵硅薄,鐢熸垚鐨勬牸寮忥紝{0}琛ㄧずsection鍚嶏紝
	                //{1}琛ㄧずsection鐨勫�硷紝{2}琛ㄧず鐧惧垎姣斻�傚彲浠ヨ嚜瀹氫箟   
	                nf, df);
	        piePlot.setLabelGenerator(generator);// Set bai fen bi...
	        piePlot.setLabelFont(new Font("榛戜綋", Font.ITALIC, 20));

	        // When there is no data in database..
	        piePlot.setNoDataMessage("There is no satiesfied data in database.");
	        piePlot.setCircular(false);
	        piePlot.setLabelGap(0.02D);

	        
	        piePlot.setIgnoreZeroValues(false);

	        panel = new ChartPanel(chart, true);
	        chart.getTitle().setFont(new Font("Century Gothic", Font.BOLD, 18));
	        chart.getLegend().setItemFont(new Font("Century Gothic", Font.BOLD, 20));
	        panel.setBounds(new Rectangle(80, 100, 400, 300));
	        contentPane.add(panel);
		}
		
		
		public DefaultPieDataset getDataset3_1() {
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("Oversea",Count.company(1, year));
	        dataset.setValue("China", Count.company(0, year));
	        return dataset;
	    }
		
		public void drawPanel4_1(){
			String title = "Anylysis In China Not At Home Graduation's Destination in ";
			if(year == -1){
				 title = title + "all year";
			}else{
				 title = title + year;
			}
			JFreeChart chart = ChartFactory.createPieChart3D(title, getDataset4_1(),
	                true, false, false);
	        PiePlot piePlot = (PiePlot) chart.getPlot();
	        DecimalFormat df = new DecimalFormat("0.00%");
	        NumberFormat nf = NumberFormat.getInstance();

	        StandardPieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
	                "{0} {2}",                   //鑾峰緱StandardPieSectionLabelGenerator瀵硅薄,鐢熸垚鐨勬牸寮忥紝{0}琛ㄧずsection鍚嶏紝
	                //{1}琛ㄧずsection鐨勫�硷紝{2}琛ㄧず鐧惧垎姣斻�傚彲浠ヨ嚜瀹氫箟   
	                nf, df);
	        piePlot.setLabelGenerator(generator);// Set bai fen bi...
	        piePlot.setLabelFont(new Font("榛戜綋", Font.ITALIC, 20));

	        // When there is no data in database..
	        piePlot.setNoDataMessage("There is no satiesfied data in database.");
	        piePlot.setCircular(false);
	        piePlot.setLabelGap(0.02D);

	        
	        piePlot.setIgnoreZeroValues(true);

	        panel = new ChartPanel(chart, true);
	        chart.getTitle().setFont(new Font("Century Gothic", Font.BOLD, 18));
	        chart.getLegend().setItemFont(new Font("Century Gothic", Font.BOLD, 20));
	        panel.setBounds(new Rectangle(80, 100, 400, 300));
	        contentPane.add(panel);
		}
		
		
		public DefaultPieDataset getDataset4_1() {
			
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("School",Count.school(0, year) );
	        dataset.setValue("Company",Count.company(0, year));
	        return dataset;
	    }
		
		public void drawPanel5_1(){
			String title = "Anylysis Oversea Not At Home Graduation's Destination in ";
			if(year == -1){
				 title = title + "all year";
			}else{
				 title = title + year;
			}
			JFreeChart chart = ChartFactory.createPieChart3D(title, getDataset5_1(),
	                true, false, false);
	        PiePlot piePlot = (PiePlot) chart.getPlot();
	        DecimalFormat df = new DecimalFormat("0.00%");
	        NumberFormat nf = NumberFormat.getInstance();

	        StandardPieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
	                "{0} {2}",                   //鑾峰緱StandardPieSectionLabelGenerator瀵硅薄,鐢熸垚鐨勬牸寮忥紝{0}琛ㄧずsection鍚嶏紝
	                //{1}琛ㄧずsection鐨勫�硷紝{2}琛ㄧず鐧惧垎姣斻�傚彲浠ヨ嚜瀹氫箟   
	                nf, df);
	        piePlot.setLabelGenerator(generator);// Set bai fen bi...
	        piePlot.setLabelFont(new Font("榛戜綋", Font.ITALIC, 20));

	        // When there is no data in database..
	        piePlot.setNoDataMessage("There is no satiesfied data in database.");
	        piePlot.setCircular(false);
	        piePlot.setLabelGap(0.02D);

	        
	        piePlot.setIgnoreZeroValues(true);

	        panel = new ChartPanel(chart, true);
	        chart.getTitle().setFont(new Font("Century Gothic", Font.BOLD, 18));
	        chart.getLegend().setItemFont(new Font("Century Gothic", Font.BOLD, 20));
	        panel.setBounds(new Rectangle(80, 100, 400, 300));
	        contentPane.add(panel);
		}
		
		
		public DefaultPieDataset getDataset5_1() {
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("School",Count.school(1, year) );
	        dataset.setValue("Company",Count.company(1, year));
	        return dataset;
	    }
		
		public ChartPanel getPieChartPanel() {
		        return piechart;
		 }
}