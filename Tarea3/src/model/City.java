package model;

public class City implements Comparable<City>{
	

	private String name;

	private int x;

	private int y;

	public City(String name, int x, int y) {
		this.name=name;
		this.x=x;
		this.y=y;
				
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}


	@Override

	public int compareTo(City o) {
		int x=0;
		if(this.name.compareTo(o.name)<0) {
			x=-1;
		}
		else if(this.name.compareTo(o.name)>0) {
			x=1;
		}
		return x;
		
	}
	
	@Override

	public String toString() {
		return name;
	}
	
	
	
}