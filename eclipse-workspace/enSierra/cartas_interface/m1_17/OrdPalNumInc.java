package m1_17;

import java.util.Comparator;
import java.util.List;



public class OrdPalNumInc extends AlgoritmoOrdenacion {

	/**
	 * Sobrescritura del método ordenar que pertenece a la clase padre
	 * AlgoritmoOrdenacion. Este método toma una lista de cartas (List<Carta>
	 * listaCartas) y lo ordenará utilizando el criterio de orden definido en el
	 * comparador de cartas.
	 */
	@Override
	public void ordenar(List<Carta> listaCartas) {
		listaCartas.sort(comparadorCartas());
	}

	/**
	 * Declaración de un método privado llamado comparadorCartas que devuelve un
	 * objeto Comparator<Carta>. Este método se utiliza para crear un comparador
	 * personalizado que define el criterio de ordenación para las cartas.
	 * 
	 * @return
	 */
	private Comparator<Carta> comparadorCartas() {

		/**
		 * Creación de una instancia anónima de la interfaz Comparator que compara
		 * objetos de tipo Carta. Esto permite definir una implementación personalizada
		 * del método compare dentro de las llaves.
		 */
		return new Comparator<Carta>() {

			/**
			 * Implementación del método compare para comparar dos cartas c1 y c2. Dentro de
			 * este método se define el criterio de ordenación.
			 */
			@Override
			public int compare(Carta c1, Carta c2) {

				/**
				 * Se compara el palo de la carta c1 con el palo de la carta c2 utilizando el
				 * método compareTo(). Esto establece un orden lexicográfico, es decir, ordena
				 * los palos alfabéticamente.
				 */
				int resultadoPalo = c1.getPalo().compareTo(c2.getPalo());

				/**
				 * El método devuelve cero si obj1 es igual a obj2. Si no hay un empate en los
				 * palos, se devuelve el resultado de la comparación de palos, lo que significa
				 * que las cartas se ordenarán primero por palo.
				 */
				if (resultadoPalo != 0) {
					return resultadoPalo;
				}

				/**
				 * Aquí se obtienen los valores numéricos de las cartas c1 y c2 llamando al
				 * método obtenerValorEsNumericos(). Este método se utiliza para asignar valores
				 * numéricos a las cartas, como 2, 3, 4, ..., 10, Sota, Caballo y Rey.
				 */
				int valorC1 = obtenerValorEsNumericos(c1.getNumero());
				int valorC2 = obtenerValorEsNumericos(c2.getNumero());

				// Ordenar por valor numérico de menor a mayor.

				
				return valorC1 - valorC2;
			}
		};
	}

	/*
	 * private int obtenerValorNumerico(String numero) { try { return
	 * Integer.parseInt(numero); } catch (NumberFormatException e) { // El número no
	 * es un valor numérico, asignar valores para Sota, Caballo y Rey switch
	 * (numero) {
	 * 
	 * case "Sota": return 8; case "Caballo": return 9; case "Rey": return 10;
	 * default: return 0; } } }
	 */

}

//ESTE METODO ORDENA String en orden ALFABÉTICO, NO FUNCIONA PARA ORDENAR STRING CON LA CONSIDERACION DE NUMEROS. 
//SEGUIR BUSCANDO......
/*
 * @Override public void ordenar(List<Carta> listaCartas) {
 * Collections.sort(listaCartas, (carta1,carta2)-> { int paloComparacion =
 * carta1.getPalo().compareTo(carta2.getPalo()); if (paloComparacion != 0) {
 * return paloComparacion; }
 * 
 * return carta1.getNumero().compareTo(carta2.getNumero());
 * 
 * }); }
 * 
 * /*public int comparadorCarta(Carta c1, Carta c2) { // Comparador de cartas
 * usado en el algoritmo de ordenaciÛn return 0; }
 */
