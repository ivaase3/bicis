package bicimad;

import java.io.Serializable;

public class Bicicleta implements Serializable{

	int id;
	int carga;
	boolean disponible;

	public Bicicleta(int id) {
		this.id = id;
		this.carga = 100;
		this.disponible = true;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

}
