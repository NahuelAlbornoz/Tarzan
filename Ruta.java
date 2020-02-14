package tarzan;

public class Ruta {
	private Arbol origen;
	private Arbol destino;
	private double distancia;
	
	public Ruta(Arbol origen, Arbol destino, double distancia) {
		this.origen = origen;
		this.destino = destino;
		this.distancia = distancia;
	}

	public Arbol getOrigen() {
		return origen;
	}

	public void setOrigen(Arbol origen) {
		this.origen = origen;
	}

	public Arbol getDestino() {
		return destino;
	}

	public void setDestino(Arbol destino) {
		this.destino = destino;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public String toString() {
		return "Origen=" + origen + ", Destino=" + destino+ ", Distancia=" + distancia;
	}	
}