
public class Plot {
	private int x; 
	private int y; 
	private int width;
	private int depth; 
	
	//no arguments constructor
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1; 
	}
	//copy constructor
	public Plot(Plot p) {
		this.x = p.getX();
		this.y = p.getY();
		this.width = p.getWidth();
		this.depth = p.getDepth(); 
	}
	//parameterized constructor
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth; 
	}
	
	//setter methods
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y; 
	}
	public void setWidth(int width) {
		this.width = width; 
	}
	public void setDepth(int depth) {
		this.depth = depth; 
	}

	//getter methods 
	public int getX() { 
		return this.x; 
	}
	public int getY() {
		return this.y; 
	}
	public int getWidth() {
		return this.width; 
	}
	public int getDepth() {
		return this.depth; 
	}
	/**
	 * this compares to plot objects to see if one's coordinates are within anothers
	 * we take their coordinates and compare to see if they are within the coordinates of a different plot. if they are in between then they are overlap
	 * if they are not in between or just on the outside, then they are not overlapping
	 * @param _plot
	 * @return
	 */
	public boolean overlaps(Plot _plot) {
		boolean doesOverlaps = false; 
		int leftXCoordinate = _plot.getX();
		int rightXCoordinate = _plot.getX() + _plot.getWidth();
		int topYCoordinate = _plot.getY();
		int botYCoordinate = _plot.getY() + _plot.getDepth();
		//if the x point is in between another plots x 
		if(this.x >= leftXCoordinate && leftXCoordinate > this.x + this.width) {
			if(this.y <= topYCoordinate && topYCoordinate < this.y + this.depth)
				doesOverlaps = true;
		}

		if(rightXCoordinate < this.x && rightXCoordinate > this.x + this.width) {
			if(this.y > botYCoordinate && botYCoordinate > this.y + this.depth )
				doesOverlaps = true; 
		}
		return doesOverlaps; 
	}
	/**
	 * This method checks to see if one plot is within another's. We check their coordinates again like previously, only this time we return true or false
	 * based on if they are in between said coordinates
	 * @param _plot
	 * @return
	 */
	public boolean encompasses(Plot _plot) {
		boolean doesEncompass = false; 
		
		if(this.x < _plot.getX() && this.x + this.width > _plot.getX() + _plot.getWidth()) {
			if(this.y < _plot.getY() && this.y + this.depth > _plot.getY() + _plot.getWidth()) {
				doesEncompass = true;
			}
		}
		return doesEncompass; 
	}
	//overloaded to string method
	public String toString() {
		return "Upper left: ("+x+","+y+"); Width: "+width+" Depth: "+depth; 
	}
	
}
