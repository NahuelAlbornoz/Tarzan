package tarzan;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Jungla {
	private List<Arbol> arboles;
	private List<Ruta> rutas;
	
	public Jungla(List<Arbol> arboles) {
		this.arboles = arboles;
		this.rutas = new ArrayList<Ruta>();
	}
	
	public List<Arbol> getArboles() {
		return arboles;
	}

	public void setArboles(List<Arbol> arboles) {
		this.arboles = arboles;
	}

	public List<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}

	private void ordenar() {
		Collections.sort(this.arboles);	
	}
	
	public void armar() {
		double distancia = 0;
		if((this.arboles.get(0).getX()<=0)&&(this.arboles.get(0).getY()<=0)&&(this.arboles.get(this.arboles.size()-1).getX()>=0)&&(this.arboles.get(this.arboles.size()-1).getY()>=0)){
			this.ordenar();
		}
		for(int i=0; i<this.arboles.size();i++) {
			for(int j=i; j<this.arboles.size(); j++) {
				if(i!=j){
					distancia = calcularDistancia(this.arboles.get(i),this.arboles.get(j));
					if(distancia<=50)
						rutas.add(new Ruta(this.arboles.get(i),this.arboles.get(j),distancia));
				}
			}
		}
	}
	
	public void ver() {
		for(int i=0; i<this.rutas.size();i++){
			System.out.println(this.rutas.get(i));
		}
	}
	
	private double calcularDistancia(Arbol a1, Arbol a2){
		return Math.floor(Math.sqrt(Math.pow(a1.getX()-a2.getX(), 2)+Math.pow(a2.getY()-a1.getY(), 2)));
	}

	@Override
	public String toString() {
		return "Jungla [arboles=" + arboles + ", rutas=" + rutas + "]";
	}
}