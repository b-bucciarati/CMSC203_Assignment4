
public class ManagementCompany {
	private int MAX_PROPERTY = 5;
	private double mgmFeePer; 
	private String name; 
	private Property[] properties; 
	private String taxID;
	private int MGMT_WIDTH = 10; 
	private int MGMT_DEPTH = 10; 
	private Plot plot;
	private static int index = 0; 
	
	//constructors: 
	//no argument constructor 
	public ManagementCompany() {
		name = "";
		taxID = "";
		mgmFeePer = 0;
		plot = new Plot(); 
		properties = new Property[MAX_PROPERTY];  
	}
	//parameterized constructor default plot
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee; 
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH); 
		properties = new Property[MAX_PROPERTY];
	}
	//parameterized constructor with plot
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee; 
		plot = new Plot(x, y, width, depth); 
		properties = new Property[MAX_PROPERTY];
	}
	
	//methods
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY; 
	}
	/**
	 * This method takes in a property object and will add to our properties array if following conditions are met:
	 * 1.) array isn't full 2.) property is not null 3.) plot is not contained by the MgmtCo plot 
	 * 4..) plot doesn't overlap any other property
	 * Create a boolean variable that will first check to see if the added property is encompassed by the managementCo property
	 * Create another boolean variable that will check to see that plot does not overlap any other property
	 * We iterate through our properties array to compare the plot with all other plots to check for overlap
	 * if even one plot is overlapped we end loop and our notOverlapped boolean remains false
	 * after pre checking encompass and overlap we check if array is full and if property given is null
	 * once all conditions are finally met we add property at index and then increment our index for the next time it is called
	 * @param property
	 * @return 
	 */
	public int addProperty(Property property) {
		Property propertyToAdd = new Property(property);
		Plot plotToAdd = propertyToAdd.getPlot(); 
		boolean isEncompassed = plot.encompasses(plotToAdd); 
		boolean notOverlapped = true;
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(properties[i] != null) {
				notOverlapped = plot.overlaps(plotToAdd);
				if(notOverlapped == false) {
					i = MAX_PROPERTY; 
				}
			}
		}
		if(index < MAX_PROPERTY && property != null && isEncompassed && notOverlapped) { 
			properties[index] = new Property(property); 
			index++; 
		} else if(index == MAX_PROPERTY) {
			return -1; 
		} else if(property == null) {
			return -2; 
		} else if(isEncompassed == false) {
			return -3; 
		} else if(notOverlapped == false) {
			return -4;
		}
		return index - 1; 
	}
	/**
	 * Overloaded addProperty method; this one will create a new instance of property with given parameters,
	 * then check to see if all conditions are met like in the previous method. No plot parameters are given so we create
	 * default plot
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return index - 1
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		Property propertyToAdd = new Property(name, city, rent, owner);
		Plot plotToAdd = propertyToAdd.setPlot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		boolean isEncompassed = plot.encompasses(plotToAdd);
		boolean Overlapped = false;
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(properties[i] != null) {
				Overlapped = plot.overlaps(plotToAdd);
				if(Overlapped == true) {
					i = MAX_PROPERTY; 
				}
			}
		}
		if(index < MAX_PROPERTY && propertyToAdd != null && isEncompassed && ! Overlapped) { 
			properties[index] = new Property(propertyToAdd); 
			index++; 
		} else if(index == MAX_PROPERTY) {
			return -1; 
		} else if(propertyToAdd == null) {
			return -2; 
		} else if(isEncompassed == false) {
			return -3; 
		} else if(Overlapped == true) {
			return -4;
		}
		return index - 1;
	}
	/**
	 * Third overloaded addProperty method; this one will create new instance of property with given parameters,
	 * as well as parameters to create a plot with the property. Check for conditions once again
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return index - 1 
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property propertyToAdd = new Property(name, city, rent, owner, x, y, width, depth);
		Plot plotToAdd = propertyToAdd.setPlot(x, y, width, depth);
		boolean isEncompassed = plot.encompasses(plotToAdd); 
		boolean Overlapped = false;
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(properties[i] != null) {
				Overlapped = plot.overlaps(plotToAdd);
				if(Overlapped == true) {
					i = MAX_PROPERTY; 
				}
			}
		}
		if(index < MAX_PROPERTY && propertyToAdd != null && isEncompassed && ! Overlapped) { 
			properties[index] = new Property(propertyToAdd); 
			index++; 
		} else if(index == MAX_PROPERTY) {
			return -1; 
		} else if(propertyToAdd == null) {
			return -2; 
		} else if(isEncompassed == false) {
			return -3; 
		} else if(Overlapped == true) {
			return -4;
		}
		return index - 1;
	}
	/**
	 * Iterate through our properties array, make sure they are not null, then we get the rent at index i and add it to our
	 * sumOfRents variable that will hold the sum of all rents. 
	 * @return sumOfRents
	 */
	public double totalRent() {
		double sumOfRents = 0; 
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(properties[i] != null) 
				sumOfRents += properties[i].getRentAmount(); 
		}
		return sumOfRents; 
	}
	/**
	 * Iterate through properties array, make sure they are not null. then make comparisons with each index and set variable
	 * biggestRent equal to the biggest one.
	 * @return
	 */
	public double maxRentProp() {
		double biggestRent = 0; 
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(properties[i] != null) {
				if(properties[i].getRentAmount() > biggestRent) 
					biggestRent = properties[i].getRentAmount();
			}
		}
		return biggestRent;
	}
	public Plot getPlot() {
		return plot; 
	}
	public String getName() {
		return name;
	}
	/**
	 * Iterate through properties array, make sure they are not null, then we create variable to compare to each index of
	 * the array. If index is bigger than our variable, we set our variable equal to that, and then also save the index at 
	 * which we found the bigger value. We do this until we reach the end of our array
	 * @return
	 */
	private int maxRentPropertyIndex() {
		double biggestRent = 0; 
		int index = 0; 
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(properties[i] != null) {
				if(properties[i].getRentAmount() > biggestRent) {
					biggestRent = properties[i].getRentAmount();
					index = i; 
				}
			}
		}
		return index; 
	}
	/**
	 * call our toString method in property to display information of our property at index i 
	 * @param i
	 * @return
	 */
	private String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}
	public String toString() {
		String allProperties = "List of the properties for "+name+", taxID: "+taxID+"\n";
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(properties[i] != null)
				allProperties += properties[i].toString() + "\n"; 
		}
		allProperties += "total Management Fee: " + mgmFeePer;
		return allProperties;
	}
}
