package tarzan;

public class Arbol implements Comparable<Arbol>{
	private Etiqueta etiqueta;
	private char nombre;
	private int x;
	private int y;
	
	public Arbol(char nombre, int x, int y) {
		this.nombre = nombre;
		this.x = x;
		this.y = y;
		etiqueta = new Etiqueta('-',0, 0);
	}
	
	public char getNombre() {
		return nombre;
	}

	public void setNombre(char nombre) {
		this.nombre = nombre;
	}

	public Etiqueta getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
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
	public int compareTo(Arbol a) {
		if(this.getX()>a.getX())
			return 1;
		if(this.getX()<a.getX())
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return "Arbol [etiqueta=" + etiqueta + ", nombre=" + nombre + ", x=" + x + ", y=" + y + "]";
	}
}