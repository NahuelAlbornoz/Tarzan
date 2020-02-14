package tarzan;
import java.util.List;
import java.util.ArrayList;


public class RutaMinima {
	private Arbol origen;
	private Arbol destino;
	
	public RutaMinima(Arbol origen, Arbol destino){
		this.origen = origen;
		this.destino = destino;
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

	@Override
	public String toString() {
		return "Dijkstra [origen=" + origen + ", destino=" + destino + "]";
	}
	
	private int HallarMenorCosto(int i, List<Arbol> arb){ //Retono el num de posicion de nodo con el menor valor de costo acumulado
		boolean band = true;
		double min = 0.0;
		int indice_nodo = 0;
		for(int j=i+1; j<arb.size(); j++){
			if((band==true)&&((arb.get(j).getEtiqueta().getCosto_acumulado()>0))){
				band=false;
				min = arb.get(j).getEtiqueta().getCosto_acumulado();
				indice_nodo = j;
			}
			else if((arb.get(j).getEtiqueta().getCosto_acumulado()<min)&&(arb.get(j).getEtiqueta().getCosto_acumulado()>0)){
				min = arb.get(j).getEtiqueta().getCosto_acumulado();
				indice_nodo = j;
			}
		}
		return indice_nodo;
	}
	
	public List<Arbol> encontrarCaminoMinimo(Jungla j){
		int i;
		int arbol;
		List<Arbol> salida = new ArrayList<Arbol>(); //Para imprimir en el archivo los arboles que pertecen a la ruta minima
		Arbol orig = this.origen; // Nodo puntero para continuar recorriendo el grafo
		salida.add(orig);
		for(i=0; i<j.getArboles().size();i++){// Recorre los nodos que no voy a usar (para comparar)
			if(orig.equals(j.getArboles().get(i)))
				break;//Omite los nodos que no son origen y son anteriores a éste
		}
		//Fin 1er For (1ra parte)---> para arboles
		//Recorre nodo a nodo
		for(arbol=i; arbol<j.getArboles().size();arbol++){  
			for(int ruta=0; ruta<j.getRutas().size(); ruta++){// Recorre todas las aristas adyacentes
				if(orig.equals(j.getRutas().get(ruta).getOrigen())){
					//etiqueta cada nodo destino
					double peso_nodo_anterior = j.getRutas().get(ruta).getOrigen().getEtiqueta().getCosto_acumulado();
					// Si el costo acumulado para ese nodo es menor al peso que tenia anteriormente (que no sea = 0)
				if(j.getRutas().get(ruta).getDestino().getEtiqueta().getCosto_acumulado()==0)	
					j.getRutas().get(ruta).getDestino().setEtiqueta(new Etiqueta(j.getRutas().get(ruta).getOrigen().getNombre(),j.getRutas().get(ruta).getDistancia()+peso_nodo_anterior,j.getRutas().get(ruta).getOrigen().getEtiqueta().getIteracion()+1));
				else if(j.getRutas().get(ruta).getDistancia()+peso_nodo_anterior<j.getRutas().get(ruta).getDestino().getEtiqueta().getCosto_acumulado())
					j.getRutas().get(ruta).getDestino().setEtiqueta(new Etiqueta(j.getRutas().get(ruta).getOrigen().getNombre(),j.getRutas().get(ruta).getDistancia()+peso_nodo_anterior,j.getRutas().get(ruta).getOrigen().getEtiqueta().getIteracion()+1));
				}
			}
			//Fin 2do For ---> para vertices
			//Hallar la arista de menor peso. Pasa como parametro el indice del nodo origen
			
			int indice_aux = HallarMenorCosto(arbol,j.getArboles());
			orig = j.getArboles().get(indice_aux);
			salida.add(orig);
			if(this.destino.equals(orig)){
				//System.out.println("Fin Dijkstra");
				break;
			}
		} //Fin 1er For (2da parte)---> para arboles
	  
		return salida;
	}
}