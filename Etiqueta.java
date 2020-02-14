package tarzan;

public class Etiqueta {
	private char nodo_origen;
	private double costo_acumulado;
	private int iteracion;
	
	public Etiqueta(char n_origen, double c_acumulado,  int i) {
		this.nodo_origen = n_origen;
		this.costo_acumulado = c_acumulado;
		this.iteracion = i;
	}

	public char getNodo_origen() {
		return nodo_origen;
	}

	public void setNodo_origen(char nodo_origen) {
		this.nodo_origen = nodo_origen;
	}

	public double getCosto_acumulado() {
		return costo_acumulado;
	}

	public void setCosto_acumulado(double costo_acumulado) {
		this.costo_acumulado = costo_acumulado;
	}

	public int getIteracion() {
		return iteracion;
	}

	public void setIteracion(int iteracion) {
		this.iteracion = iteracion;
	}

	@Override
	public String toString() {
		return "Etiqueta [nodo_origen=" + nodo_origen + ", costo_acumulado="
				+ costo_acumulado + ", iteracion=" + iteracion + "]";
	}	
}