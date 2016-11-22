package Table;

public class School extends Organization{
	// Attributes...
	private String name;
	private String country;
	private String city;
	private int top100;// 1 for true, 0 for false...
	
	// Constructor...
	public School(String name, String country , String city, int top100){
		super(name,country,city);
		this.top100 = top100;	
	}
	
	// Methods...
	public void setTop100(char top100){ this.top100 = top100;}
	
	public int getTop100(){ return top100;}
}
