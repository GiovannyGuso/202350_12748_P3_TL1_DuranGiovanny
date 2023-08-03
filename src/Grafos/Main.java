package Grafos;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		GrafoMatriz grafo = new GrafoMatriz(); 
		menu(grafo);
	}
	public static void menu(GrafoMatriz grafo) {
		int contadorVertices = 0;
		String nomb;
		Scanner leer = new Scanner(System.in);
		System.out.println("*************************************************");
		System.out.println("            Menú principal      ");
		System.out.println("*************************************************");
		System.out.println("op 1 Ingresar vértices");
		System.out.println("op 2 Conectar vertices");
		System.out.println("op 3 Verificar si un vertice es adyacente con otro");
		System.out.println("op 4 Ver todas las adyacencias de un vértice");
		System.out.println("op 5. Salir");
		int op = leer.nextInt();
		leer.nextLine(); 
		switch (op) {
		case 1:
			System.out.println("*************************************************");
			System.out.println("          Creación de vértices (nodos)");
			System.out.println("Ingrese cuántos vértices va a crear:");
			int nVertices = leer.nextInt();
			leer.nextLine(); 
			int totalVertices = nVertices + contadorVertices;
			while (nVertices < 0 || nVertices > 20 ) {
				System.out.println("*************************************************");
				System.out.println("Valor Ingresado Incorrecto, No puede ingresar un número negativo o mayores a 20");
				System.out.println("\n");
				System.out.println("Ingrese nuevamente, cuántos vértices va a crear:");
				nVertices = leer.nextInt();
			}

			for (int i = 0; i < nVertices; i++) {
				int verticesTotales = contadorVertices + 1;
				System.out.println("*************************************************");
				System.out.println("          Creación del grafo número " + verticesTotales);
				System.out.println("Ingrese el nombre de referencia para el vértice:");
				nomb = leer.nextLine();
				grafo.nuevoVertice(nomb.trim());
				System.out.println("Se creó correctamente");
				System.out.println("\n");
				contadorVertices = contadorVertices + 1;
			}                        
			menu(grafo);
			break;
		case 2:
			int verticesTotales = contadorVertices + 1;
			System.out.println("////////////////////////////////////////////////////");
			System.out.println("      Conectar vértices (" + verticesTotales + ": grafos totales)");
			System.out.println("Ingrese el nombre del vértice a conectar:");
			String vertice1 = leer.nextLine();
			System.out.println("Ingrese el nombre del vértice a conectar con " + vertice1);
			String vertice2 = leer.nextLine();
			try {
				grafo.nuevoArco(vertice1, vertice2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			menu(grafo);
			break;
		case 3:
			System.out.println("////////////////////////////////////////////////////");
			System.out.println("      Verificar si un vértice es adyacente");
			System.out.println("Ingrese el nombre del vértice a verificar:");
			String vertice = leer.nextLine();
			System.out.println("Ingrese el nombre del vértice a verificar con:" + vertice);
			String verticeVerificar = leer.nextLine();
			try {
				System.out.println(grafo.adyacente(vertice, verticeVerificar));                  
			} catch (Exception e) {
				e.printStackTrace();
			}
			menu(grafo);
			break;
		case 4:
			System.out.println("////////////////////////////////////////////////////");
			System.out.println("  Buscar todos las adyacencias de un vértice");
			System.out.println("Ingrese el nombre del vértice a buscar sus adyacencias:");
			String verticeBuscar = leer.nextLine();
			try {
				List<Vertice> nodosConectadosA = grafo.nodosConectados(verticeBuscar);
				System.out.println("Nodos conectados a ("+verticeBuscar+")");
				for (Vertice v : nodosConectadosA) {
					System.out.println(v.nomVertice());
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			menu(grafo);
			break;
		case 5:
			System.out.println("////////////////////////////////////////////////////");
			System.out.println("           Muchas gracias, salio de la aplicacion");
			break;
		}
	}
}

