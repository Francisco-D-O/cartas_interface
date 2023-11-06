package m1_17;



import java.util.Comparator;
import java.util.List;

public class OrdPalNumDec extends AlgoritmoOrdenacion {

	/**
	 * Esta línea ordena la lista de cartas listaCartas utilizando el comparador de
	 * cartas comparadorCartas(). El método sort de la lista ordenará las cartas de
	 * acuerdo con el criterio especificado en el comparador.
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
		return new Comparator<Carta>() {

			/**
			 * Creación de una instancia anónima de la interfaz Comparator que compara
			 * objetos de tipo Carta. Esto permite definir una implementación personalizada
			 * del método compare dentro de las llaves.
			 */
			@Override
			public int compare(Carta c2, Carta c1) {

				/**
				 * Implementación del método compare para comparar dos cartas, c1 y c2. los
				 * nombres de las variables c1 y c2 están intercambiados en comparación con
				 * OrdPalNumInc.Las cartas se comparan de manera inversa, de manera descendente
				 * en lugar de ascendente.
				 */
				int resultadoPalo = c2.getPalo().compareTo(c1.getPalo());

				/**
				 * Al igual que en OrdPalNumInc, esta parte verifica si la comparación de los
				 * palos no resultó en un empate (cuando resultadoPalo no es igual a 0). Si no
				 * hay un empate en los palos, se devuelve el resultado de la comparación de
				 * palos, lo que significa que las cartas se ordenarán primero por palo.
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

				/**
				 * Finalmente, se compara el valor numérico de la carta c1 con el valor numérico
				 * de la carta c2. El resultado de esta comparación determina el orden de las
				 * cartas numéricamente, pero en este caso, ordena de manera descendente, de
				 * mayor a menor.
				 * 
				 */
				return valorC1 - valorC2;
			}
		};
	}

	/*
	 * private int obtenerValorNumerico(String numero) {
	 * 
	 * /** En Java, el bloque try-catch se utiliza para manejar excepciones. En este
	 * caso, estamos utilizando el método Integer.parseInt(numero) para convertir un
	 * String en un número entero (int). Sin embargo, si el String no puede ser
	 * convertido a un número válido, se lanza una excepción de tipo
	 * NumberFormatException. El bloque try-catch permite capturar esta excepción y
	 * realizar acciones específicas en caso de que ocurra. En este caso, el bloque
	 * catch (NumberFormatException e) indica que se capturará la excepción
	 * NumberFormatException y se asignará a la variable e. Dentro del bloque catch,
	 * se proporciona un manejo para la excepción. En este caso, se utiliza un
	 * switch para asignar valores numéricos a los números de tipo String que no
	 * pueden ser convertidos directamente. Los casos son "Sota", "Caballo" y "Rey",
	 * que corresponden a valores específicos (8, 9 y 10 respectivamente). Si el
	 * número no coincide con ninguno de estos casos, se devuelve un valor
	 * predeterminado de 0.
	 * 
	 * ME LLAMA LA ATENCION QUE "As" NO PRECISE DE ESTE PARSEO PARA SER
	 * IDENTIFICADA.
	 * 
	 * EN RESUMEN, este bloque de código intenta convertir un String en un número
	 * entero utilizando Integer.parseInt(). Si tiene éxito, devuelve el número
	 * convertido. Si ocurre una excepción NumberFormatException, se maneja dentro
	 * del bloque catch y se asignan valores específicos para ciertos String que no
	 * pueden ser convertidos directamente. Esta técnica es útil cuando trabajamos
	 * con datos mixtos, como números y palabras, y necesitamos asignarles valores
	 * numéricos para realizar operaciones de comparación o cálculos.
	 */

	/*
	 * try { return Integer.parseInt(numero); } catch (NumberFormatException e) { //
	 * El número no es un valor numérico, asignar valores para Sota, Caballo y Rey
	 * switch (numero) {
	 * 
	 * case "Sota": return 8; case "Caballo": return 9; case "Rey": return 10;
	 * default: return 0; } } }
	 */

}

