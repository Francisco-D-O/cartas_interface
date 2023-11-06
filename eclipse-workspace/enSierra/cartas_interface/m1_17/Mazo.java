package m1_17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {

	/**
	 * Se declara una lista de objetos Carta llamada cartasMazo. Esta lista es
	 * declarada con modificador de acceso protected, lo que significa que las
	 * clases que hereden de esta clase podrán acceder a esta lista directamente sin
	 * usar un método.
	 */
	protected List<Carta> cartasMazo;

	/**
	 * Variable de Instancia llamada algoritmo de tipo AlgoritmoOrdenacion. Se
	 * utiliza para almacenar un algoritmo de ordenación que se puede utilizar en el
	 * mazo. El motivo de esta línea es proporcionar la capacidad de ordenar las
	 * cartas de diferentes maneras utilizando algoritmos de ordenación
	 * personalizados.
	 */
	private AlgoritmoOrdenacion algoritmo;

	public void setAlgoritmo(AlgoritmoOrdenacion algoritmo) {
		this.algoritmo = algoritmo;

	}

	public void ordena() {

		if (algoritmo != null) {

			algoritmo.ordenar(cartasMazo);

		} else {
			System.out.println("No se ha especificado ningún algoritmo. ");
		}

	}

	/**
	 * Estas líneas corresponden al constructor de la clase Mazo. Aquí se realizan
	 * dos acciones:
	 *
	 * cartasMazo = new ArrayList<Carta>();: En esta línea, se inicializa una
	 * variable llamada cartasMazo como una nueva instancia de ArrayList<Carta>.
	 * Esto significa que se crea una lista vacía que contendrá objetos de tipo
	 * Carta. Esta lista se utiliza para almacenar las cartas en el mazo. algoritmo
	 * = null;: En esta línea, se inicializa una variable llamada algoritmo como
	 * null. Esta variable se utiliza para almacenar el algoritmo de ordenación que
	 * se aplicará a las cartas del mazo. Inicialmente, no se especifica ningún
	 * algoritmo, por lo que se establece como null. Posteriormente, a través del
	 * método setAlgoritmo, se puede asignar un algoritmo de ordenación específico a
	 * esta variable.
	 *
	 * En resumen, estas líneas del constructor se encargan de crear una lista vacía
	 * de cartas y de inicializar la variable algoritmo como null. El constructor se
	 * ejecuta cuando se crea una instancia de la clase Mazo, preparando así el mazo
	 * para futuras operaciones como añadir cartas, ordenarlas, etc.
	 */

	public Mazo() {
		cartasMazo = new ArrayList<Carta>();
		algoritmo = null;

	}

	/**
	 * Devuelve la carta de una posiciÛn dada
	 * 
	 * @param posicion La posiciÛn de la carta
	 * @return La carta de dicha posiciÛn
	 * @exception IllegalArgumentException si la posiciÛn no es v·lida en la lista
	 */
	public Carta getCarta(int posicion) {
		return cartasMazo.get(posicion);
	}

	/**
	 * AÒade una carta en el mazo en la posiciÛn dada. Las cartas que estan despuÈs
	 * de la posiciÛn dada avanzan una posiciÛn Esto es la definición del método
	 * insertarCarta. Toma dos parámetros: posicion, que es la posición en la que se
	 * insertará la carta, y carta, que es la carta que se insertará en el mazo.
	 *
	 * @param posicion PosiciÛn a aÒadir
	 * @param carta    Carta a aÒadir
	 * @exception IllegalArgumentException si la posiciÛn no es valida en la lista
	 */
	public void insertarCarta(int posicion, Carta carta) {

		/**
		 * Se crea una nueva lista llamada aux, que se utilizará para almacenar
		 * temporalmente las cartas que se deben mover en el proceso de inserción.
		 */
		List<Carta> aux = new ArrayList<>();

		/**
		 * Este bucle for itera desde el final del mazo hasta la posición posicion.
		 * Durante cada iteración, se extrae la carta en la posición actual (desde el
		 * final) del mazo y se agrega a la lista aux. Esto significa que las cartas que
		 * están en o después de la posición especificada se retiran del mazo y se
		 * almacenan temporalmente en aux.
		 */
		for (int i = cartasMazo.size() - 1; i >= posicion; i--) {
			// aux.add(cartasMazo.remove(i));
			aux.add(extraerCarta(i));
		}

		/**
		 * Después de retirar las cartas del mazo, se agrega la nueva carta (carta) en
		 * la posición especificada posicion en el mazo.
		 */
		cartasMazo.add(carta);

		/**
		 * Finalmente, se realiza otro bucle for para agregar las cartas que se habían
		 * retirado previamente (almacenadas en aux) nuevamente al mazo. Estas cartas se
		 * agregan en orden inverso,empieza por el final del mazo, esto se le indica con
		 * (int i=aux.size()-1;....) lo que significa que la última carta extraída será
		 * la primera en agregarse, y así sucesivamente. Esto asegura que las cartas se
		 * vuelvan a colocar en el mazo de manera ordenada en la posición especificada.
		 */
		for (int i = aux.size() - 1; i >= 0; i--) {
			cartasMazo.add(aux.get(i));
		}
	}

	/**
	 * Esta línea define el método extraerCarta que toma un argumento posicion, que
	 * representa la posición desde la cual se extraerá la carta del mazo. El método
	 * devuelve un objeto de tipo Carta, que es la carta extraída.
	 * 
	 * @param posicion
	 * @return
	 */
	public Carta extraerCarta(int posicion) {
		return cartasMazo.remove(posicion);
	}

	/**
	 * Esta línea define el método extraerCarta() sin argumentos que se utiliza para
	 * extraer la carta en la cima del mazo y devolverla. El método devuelve un
	 * objeto de tipo Carta, que es la carta extraída.
	 * 
	 * @return
	 */
	public Carta extraerCarta() {

		/**
		 * En esta línea, cartasMazo.size() - 1 se utiliza para calcular el índice de la
		 * última carta en el mazo. La función size() devuelve la cantidad de elementos
		 * en la lista cartasMazo, y al restar 1, se obtiene el índice de la última
		 * carta. Luego, se utiliza el método remove de la lista cartasMazo con este
		 * índice para eliminar la carta en la cima del mazo. La carta eliminada se
		 * devuelve como resultado del método.
		 */
		return cartasMazo.remove(cartasMazo.size() - 1);
	}

	/**
	 * AÒade una carta al final del mazo
	 * 
	 * @param carta Carta a aÒadir
	 */
	public void anadirCarta(Carta carta) {
		cartasMazo.add(carta);
	}

	/**
	 * Devuelve el número de cartas del mazo
	 * 
	 * @return número de cartas
	 */
	public int numCartas() {
		return cartasMazo.size();
	}

	/**
	 * En esta línea, se utiliza la clase Collections de Java para invocar el método
	 * estático shuffle(). El método shuffle() toma una lista, en este caso, la
	 * lista de cartas cartasMazo, y reorganiza aleatoriamente los elementos de la
	 * lista. Esto logra el efecto de barajar las cartas en el mazo, de modo que su
	 * orden original se mezcla de manera aleatoria.
	 */
	public void barajar() {
		Collections.shuffle(cartasMazo);
	}

	@Override
	public String toString() {
		return "" + cartasMazo;
	}

}
