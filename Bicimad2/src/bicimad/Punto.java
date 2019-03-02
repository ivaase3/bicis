package bicimad;

import java.io.Serializable;
import java.util.ArrayList;

public class Punto implements Serializable{

	String localizacion;
	ArrayList<Bicicleta> punto;
	int nDisponibles;
	int total;

	public Punto(String localizacion, int total) {
		this.punto = new ArrayList<>();
		this.nDisponibles = 0;
		this.localizacion = localizacion;
		this.total = total;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public ArrayList<Bicicleta> getPunto() {
		return punto;
	}

	public void setPunto(ArrayList<Bicicleta> punto) {
		this.punto = punto;
	}

	public int getnDisponibles() {
		return nDisponibles;
	}

	public void setnDisponibles(int nDisponibles) {
		this.nDisponibles = nDisponibles;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
