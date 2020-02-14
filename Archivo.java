package tarzan;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Archivo {
	Scanner input;
	PrintWriter output;
	String nombre_in;
	String nombre_out;
	
	public Archivo(String nomb_in, String nomb_out) {
		this.nombre_in = nomb_in;
		this.nombre_out = nomb_out;
	}
	
	public void leer() {
		try{
			input = new Scanner(new File(this.nombre_in));
		}catch(Exception e){
			System.out.println("No existe el archivo");
		}
	}
	
	public void escribir(List<Arbol> arboles, Jungla jungla){
		try{
			output = new PrintWriter(new File(this.nombre_out));
			int indice = arboles.size()-1;
			char nodo = arboles.get(indice).getNombre();
			char origen = arboles.get(indice).getEtiqueta().getNodo_origen();
			if(origen=='-'){
				output.print("NO HAY RUTA");
			}
			else {
				ArrayList<Character> nomb_nodos = new ArrayList<Character>();
				nomb_nodos.add(nodo);
				for(int i=indice; i>=0; i--){
					if(origen==arboles.get(i).getNombre()){
						indice = i;
						origen = arboles.get(indice).getEtiqueta().getNodo_origen();
						nodo = arboles.get(indice).getNombre();
						nomb_nodos.add(nodo);
					}
				}
		
				Collections.sort(nomb_nodos); // Ordena los nodos. desde el origen a destino
				// Imprime en el archivo de salida recorriendo todos los arboles originales
				for(int a=0; a<nomb_nodos.size();a++){ 
					for(int j=0; j<jungla.getArboles().size();j++){
						if(nomb_nodos.get(a)==jungla.getArboles().get(j).getNombre()){
							this.output.print(jungla.getArboles().get(j).getX());
							this.output.print(" ");
							this.output.println(jungla.getArboles().get(j).getY());
						}
					}
				}	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		cerrar(1);
	}

	public List<Arbol> llenar() {
		List<Arbol> arboles = new ArrayList<Arbol>();
		int i = 0;
		int cantidad_lineas = 0;
		while(this.input.hasNext()){
			cantidad_lineas++;
			int ascii = i + 65;
			int x = input.nextInt();
			int y = input.nextInt();
			if((x>=-10000)&&(x<=10000)&&(y>=-10000)&&(y<=10000)){
				arboles.add(new Arbol((char)ascii,x,y));
				i++;
			}
			if(cantidad_lineas==1000)
				break;
		}
		cerrar(0);
		return arboles;
	}
	
	private void cerrar(int id){
		if(id==0)
			this.input.close();	
		if(id==1)
			this.output.close();	
	}
}