
public class Property {
	 private String propertyName; 
	 private String city;
	 private double rentAmount; 
	 private String ownerName;
	 private Plot plot; 
	 
	//no argument constructor
	public Property() {
		propertyName = ""; 
		city = "";
		rentAmount = 0;
		plot = new Plot(); 
	}	
	//copy constructor
	public Property(Property _property) {
		this.propertyName = _property.getPropertyName();
		this.city = _property.getCity();
		this.rentAmount = _property.getRentAmount();
		this.ownerName = _property.getOwnerName();
		plot = new Plot(_property.plot);
	}
	//parameterized constructor with no plot
	public Property(String propertyName, String city, double rentAmount, String ownerName) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount; 
		this.ownerName = ownerName; 
		plot = new Plot();
	}
	//parameterized constructor with plot
	public Property(String propertyName, String city, double rentAmount, String ownerName, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount; 
		this.ownerName = ownerName; 
		plot = new Plot(x, y, width, depth);
	}

	//setters
	public void setPropertyName(String propName) { 
		this.propertyName = propName; 
	}
	public void setCity(String propCity) {
		this.city = propCity;
	}
	public void setRentAmount(double rent) {
		this.rentAmount = rent;
	}
	public void setOwnerName(String name) {
		this.ownerName = name;
	}
	public Plot setPlot(int x, int y, int width, int depth) {
		plot = new Plot(x, y, width, depth);
		return plot; 
	}
	//getters
	public String getPropertyName() {
		return this.propertyName; 
	}
	public String getCity() {
		return this.city; 
	}
	public double getRentAmount() { 
		return this.rentAmount; 
	}
	public String getOwnerName() {
		return this.ownerName;
	}
	public Plot getPlot() {
		return this.plot; 
	}

	//to string
	public String toString() {
		return "Property Name: "+propertyName+"\nLocated in city "+city+"\nBelonging to: owner "+ownerName+"\nRent Amount: "+rentAmount;
	}
	

}
