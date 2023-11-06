package m1_17;

import java.util.List;



/**
 * Esta línea define la declaración de la clase AlgoritmoOrdenacion. La clase es
 * abstracta, lo que significa que no se pueden crear instancias directas de
 * esta clase, sino que se utiliza como una clase base para otras clases
 * concretas que heredarán de ella. Esta clase proporcionará un marco para
 * implementar diferentes algoritmos de ordenación.
 * 
 * @author franciscodieguez
 *
 */
public abstract class AlgoritmoOrdenacion {

	/**
	 * Aquí se define un método ordenar que toma una lista de objetos Carta como
	 * parámetro. La implementación real de este método debe proporcionarse en las
	 * subclases que hereden "extends", de AlgoritmoOrdenacion. Este método se
	 * utiliza para ordenar las cartas de acuerdo con un algoritmo de ordenación
	 * específico.
	 * 
	 * @param cartas
	 */
	public void ordenar(List<Carta> cartas) {

	}

	/**
	 * Aquí se declara un método compare.Es un método abstracto para definir cómo se
	 * comparan dos cartas en una subclase específica. No se proporciona una
	 * implementación esta será realizada en las clases que "extends" de esta.
	 * 
	 * @param c1
	 * @param c2
	 * @return
	 */
	public int compare(Carta c1, Carta c2) {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}

	/**
	 * Este método obtenerValorEsNumericos toma un número en forma de cadena
	 * (String) y devuelve su valor numérico. Por ejemplo, "As" se convierte en 1,
	 * "Sota" en 11, "Caballo" en 12 y "Rey" en 13. Si no es un número ni uno de los
	 * valores especiales, devuelve 0.
	 */
	protected int obtenerValorEsNumericos(String numero) {

		/**
		 * Aquí comienza un bloque try-catch. El código intenta convertir el número de
		 * cadena en un entero utilizando Integer.parseInt(numero). Si tiene éxito, el
		 * valor numérico se devuelve. Si no puede convertirlo a un entero válido, se
		 * lanza una excepción de NumberFormatException y se maneja dentro del bloque
		 * catch. java
		 * 
		 */
		try {
			return Integer.parseInt(numero);
		} catch (NumberFormatException e) {
			switch (numero) {
			
			case "Sota":
				return 11;
			case "Caballo":
				return 12;
			case "Rey":
				return 13;
			default:
				return 0;
			}
		}
	}

}
