package Table;

public class Organization{
	// Attributes...
	private String name;
	private String country;
	private String city;
	
	// Constructor...
	public Organization(String name, String country , String city){
		this.name = name;
		this.country = country;
		this.city = city;
	}
	
	// Methods...
	public void setName(String name){ this.name = name;}
	public void setCountry(String country){ this.country = country;}
	public void setCity(String city){this.city = city;}
	
	public String getName(){ return name;}
	public String getCountry(){ return country;}
	public String getCity(){ return city;}
}
	
