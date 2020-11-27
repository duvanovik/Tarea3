package model;

public class Highway implements Comparable<Highway>{

	/**
	 * Variable name, que representa el nombre de la carretera
	 */
	private String name;
	
	/**
	 * Constructor de la clase Highway
	 * @param name El nombre de la carretera.
	 */
	public Highway(String name) {
		this.name=name;
	}

	
	/**
	 * Metodo que retorna un string, el cual pertenece al nombre de la carretera
	 * @return Retorna una cadena de texto que representa el nombre de la carretera.
	 */
	public String getName() {
		return name;
	}


	/**
	 * Metodo que permite modificar el nombre de la carretera
	 * @param name El nombre por el cual se va a reemplazar el actual.
	 */
	public void setName(String name) {
		this.name = name;
	}


	
	@Override
	/**
	 * Metodo que compara las carreteras.
	 */
	public int compareTo(Highway o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	/**
	 * Metodo toString de la carretera que retorna una cadena de texto que representa el nombre de la carretera.
	 */
	public String toString() {
		return name; 
	} 
	
	
}