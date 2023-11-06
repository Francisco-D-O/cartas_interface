package m1_17;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

/**
* 
* @author franciscodieguez Se define una clase llamada Baraja que representa
*         una baraja de cartas.
*/
public class Baraja {

	/**
	 * Se declaran dos arreglos de cadenas (String[]) llamados numeros y palos.
	 * numeros contiene las etiquetas de las cartas (As, 2, 3, ..., Rey) y palos
	 * contiene los palos de las cartas (ESPADAS, COPAS, BASTOS, OROS). Estas
	 * matrices son públicas y se pueden acceder desde otras clases.
	 */
	public static final String[] numeros = { "As", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey" };
	public static final String[] palos = { "ESPADAS", "COPAS", "BASTOS", "OROS" };

	/**
	 * Se declara una lista de objetos Carta llamada cartas. Esta lista se
	 * inicializa como un ArrayList de Carta, que es una implementación de una lista
	 * dinámica.
	 */
	private List<Carta> cartasBaraja = new ArrayList<Carta>();

	/**
	 * Se inicia el constructor de la clase Baraja. Este constructor se encarga de
	 * inicializar la baraja de cartas.
	 */
	public Baraja() {

		/**
		 * Dentro del constructor, se utiliza un bucle anidado para iterar a través de
		 * todos los palos y números definidos previamente. Para cada combinación de
		 * palo y número, se crea una nueva instancia de la clase Carta y se agrega a la
		 * lista cartas.
		 */
		for (String palo : palos) {
			for (String numero : numeros) {
				cartasBaraja.add(new Carta(numero, palo));
			}
		}
	}

	/**
	 * Se define un método llamado getCarta que toma un índice como argumento y
	 * devuelve la carta en la posición especificada en la lista cartas. La lista es
	 * de tipo Carta, y se usa el método get de la lista para obtener la carta en la
	 * posición indicada.
	 * 
	 * @param posicion
	 * @return
	 */
	public Carta getCarta(int posicion) {
		return (Carta) cartasBaraja.get(posicion);

	}

	/**
	 * Se define un método llamado getMazo que crea una copia independiente del mazo
	 * de cartas actual. Primero, se crea una nueva lista llamada cartasAux que es
	 * una copia de la lista cartas. Luego, se crea un nuevo objeto Mazo y se
	 * recorre la lista cartasAux para añadir cada carta a ese mazo. Finalmente, se
	 * devuelve el objeto Mazo como resultado. Este método permite obtener una copia
	 * independiente de la baraja original sin compartir la referencia a la lista de
	 * cartas.
	 * 
	 * @return
	 */
	public Mazo getMazo() {

		List<Carta> cartasAux = new ArrayList<Carta>(cartasBaraja);
		Mazo m = new Mazo();
		for (Object carta : cartasAux) {
			/**
			 * anadir carta en un método que se crea en Mazo.java public void
			 * anadirCarta(Carta carta) { cartas.add(carta); }
			 */
			m.anadirCarta((Carta) carta);
		}
		return m;

	}

}
