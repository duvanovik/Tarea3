package model;

public class Highway implements Comparable<Highway>{

	private String name;
	

	public Highway(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
	@Override

	public int compareTo(Highway o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	public String toString() {
		return name; 
	} 
	
	
}