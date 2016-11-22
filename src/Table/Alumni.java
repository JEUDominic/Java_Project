package Table;

public class Alumni {
	// Attributes for Alumni...
	private String name;
	private String studentID;
	private int sex; // 1 for man, 0 for woman...
	private String major;
	private int graYear;
	private int state;// 0 for home, 1 for school, 2 for company...
	private int id;
	
	// Constructor...
	public Alumni(String studentID, String name, int sex, String major, int state, int graYear, int id){
		this.name = name;
		this.studentID = studentID;
		this.sex = sex;
		this.major = major;
		this.graYear = graYear;
		this.state = state;
		this.id = id;
	}
	public Alumni(String studentID, String name, int sex, String major, int state, int graYear){
		this.name = name;
		this.studentID = studentID;
		this.sex = sex;
		this.major = major;
		this.graYear = graYear;
		this.state = 0;
		this.id = 0;
	}
	
	// Methods...
	public void setStudentID(String studentID){ this.studentID = studentID;}
	public void setName(String name){ this.name = name;}
	public void setSex(int sex){ this.sex = sex;}
	public void setMajor(String major){ this.major = major;}
	public void setState(int state){this.state = state;}
	public void setGraYear(int graYear){this.graYear = graYear;}
	public void setID(int id){this.id = id;}
	
	public String getStudentID(){ return studentID;}
	public String getName(){ return name;}
	public int getSex(){ return sex;}
	public String getMajor(){ return major;}
	public int getState(){ return state;}
	public int getGraYear(){ return graYear;}
	public int getID(){return id;}
	
	
}
