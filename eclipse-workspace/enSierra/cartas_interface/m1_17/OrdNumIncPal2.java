package m1_17;

import java.util.*;
//import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class OrdNumIncPal2 extends AlgoritmoOrdenacion {

	@Override
	public void ordenar(List<Carta> listaCartas) {
		listaCartas.sort(comparadorCartas());
	}

	/**
	 * clase anónima o una expresión lambda para implementar directamente la
	 * interfaz Comparator<Carta> y definir el orden dentro del mismo código donde
	 * se utiliza.
	 * 
	 * @return
	 * 
	 *         El Comparator es una interfaz funcional en Java que se utiliza para
	 *         comparar objetos y definir un orden específico entre ellos. En este
	 *         caso, el Comparator<Carta> se utiliza para comparar objetos de la
	 *         clase Carta y establecer un orden personalizado para ellos.
	 * 
	 *         La interfaz Comparator tiene un único método, llamado compare(), que
	 *         se utiliza para realizar la comparación entre dos objetos.
	 * 
	 *         El método compare() devuelve un número entero que indica la relación
	 *         de orden entre los objetos. Aquí está la firma del método compare():
	 *         java copy code int compare(T obj1, T obj2) obj1 y obj2 son los dos
	 *         objetos que se van a comparar. El método devuelve un número negativo
	 *         si obj1 es menor que obj2. El método devuelve cero si obj1 es igual a
	 *         obj2. El método devuelve un número positivo si obj1 es mayor que
	 *         obj2.
	 */

	private Comparator<Carta> comparadorCartas() {
		//anonima 
		return new Comparator<Carta>() {

			/**
			 * Ordenar las cartas por número de forma incremental y luego por palo
			 */

			@Override
			public int compare(Carta c1, Carta c2) {
				int valorNumerico1 = obtenerValorEsNumericos(c1.getNumero());
				int valorNumerico2 = obtenerValorEsNumericos(c2.getNumero());

				;

				/**
				 * Aquí se realiza la comparación basada en los valores numéricos. Si los
				 * valores numéricos de c1 y c2 son diferentes, las cartas se ordenan en orden
				 * ascendente por número. Si los valores numéricos son iguales, se realiza una
				 * comparación en orden alfabético inverso de los palos. La función
				 * compareToIgnoreCase() se utiliza para asegurarse de que la comparación no sea
				 * sensible a mayúsculas o minúsculas.
				 */

				if (valorNumerico1 != valorNumerico2) {
					return valorNumerico1 - valorNumerico2;

				} else

					// Ordenar por palo (en orden alfabético Inverso)

					return c1.getPalo().compareToIgnoreCase(c2.getPalo());

				/**
				 * Este código define un ordenamiento personalizado para las cartas, primero por
				 * número de forma ascendente y, en caso de empate, por palo en orden alfabético
				 * inverso. El método compare dentro del comparador personalizado se encarga de
				 * definir este criterio de ordenación.
				 * */
			}

		};

	}

	
}
