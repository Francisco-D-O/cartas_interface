package m1_17;

import java.util.Objects;



/*
 * Creamos la clase carta con dos variables de instacia, this. del tipo String y 
 * creamos el constructor con el mismo nombre que la 
 * Clase Carta, con dos parámetros(String numero, String palo). 
 * Cabe salientar que estos nombres coinciden con las variables de estancia pero solo 
 * es un nombre puesto por mi, ya que funcionarían igual siendo n, o p, por ejemplo.
 */
public class Carta {

	private final String numero;
	private final String palo;

	public Carta(String numero, String palo) {
		this.numero = numero;
		this.palo = palo;
	}

	/**
	 * Devuelve el numero, método getter lo que obliga a tener un return; en este
	 * caso nos devolverá el valor almacenado en la copia de la variable de
	 * instancia que apuntará al Objeto correspondiente cuando se cree, el cual
	 * almacenará un valor en su copia de la variable y la devolverá con el método.
	 */

	public String getNumero() {

		return numero;

	}

	/**
	 * Devuelve el palo
	 */

	public String getPalo() {
		return palo;
	}

	/**
	 * Lo que se está haciendo es utilizar el método Objects.hash() para calcular un
	 * valor hash combinado de las propiedades numero y palo de la carta. En otras
	 * palabras, se está tomando en consideración el número y el palo de la carta
	 * para calcular el hash de la carta como un todo. La ventaja de usar
	 * `Objects.hash()` es que este método de Java simplifica la tarea de calcular
	 * un valor hash combinado. En lugar de tener que realizar operaciones
	 * matemáticas y combinar manualmente los valores hash de las propiedades
	 * individuales (como se hace en el código comentado), `Objects.hash()` hace
	 * esto de manera más sencilla y eficiente.
	 * 
	 * En resumen, esta línea de código calcula el hash de la carta basándose en sus
	 * propiedades `numero` y `palo`, y devuelve un valor entero que representa la
	 * carta de manera única en función de esas propiedades.
	 * 
	 */
	@Override
	public int hashCode() {

		/*
		 * int hash = 5; hash = 47 * hash + (this.numero != null ?
		 * this.numero.hashCode() : 0); hash = 47 * hash + (this.numero != null ?
		 * this.palo.hashCode() : 0); return hash;
		 */
		return Objects.hash(numero, palo);

	}

	/**
	 * El método equals(Object obj) en la clase Carta se utiliza para comparar si
	 * dos objetos Carta son iguales. Utiliza las propiedades numero y palo de ambas
	 * cartas para determinar su igualdad. La ventaja de esta implementación es que
	 * es concisa y evita la anidación de múltiples instrucciones if
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Carta other = (Carta) obj;
		/*
		 * if(this.numero != other.numero) { return false; } if (this.palo !=
		 * other.palo) { return false; } return false;
		 */

		return Objects.equals(numero, other.numero) && Objects.equals(palo, other.palo);
	}

	@Override
	public String toString() {
		return numero + " " + palo;
	}

}

