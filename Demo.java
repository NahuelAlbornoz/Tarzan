package tarzan;

public class Demo {
	public static void main(String[] args) {
		double inicio = System.currentTimeMillis();
		Archivo a1 = new Archivo("tarzan.in","tarzan.out");
		a1.leer(); 
		Jungla j1 = new Jungla(a1.llenar());
		RutaMinima d1 = new RutaMinima(j1.getArboles().get(0),j1.getArboles().get(j1.getArboles().size()-1));
		j1.armar();
		a1.escribir(d1.encontrarCaminoMinimo(j1), j1);
		double fin = System.currentTimeMillis();
		double tiempo = fin-inicio;
		System.out.println("Tiempo ejecucion = "+tiempo+" mili-segundos");
	}
}