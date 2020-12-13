package structures;

import java.io.Serializable;

public class NodoMatriz<T> implements Serializable{
	
	private T value;

	/**
	 * @param value
	 */
	public NodoMatriz(T value) {
		super();
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}


	
}
