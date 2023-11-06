package m1_17;


public class Main {

	public static void main(String[] args) {

		Baraja baraja = new Baraja();
		Mazo mazo = baraja.getMazo();
		System.out.println("La primera línea impresa es el Mazo sin un Orden. \n "
				+ " " + mazo.toString() );

		System.out.println("\n");

		
		mazo.setAlgoritmo(new OrdPalNumInc());
		mazo.ordena();
		System.out.println("La segunda línea ordenada por Palo y como segundo criterio "
		+ " los números en  orden ascendente. \n " 
		+mazo.toString());
		System.out.println("\n");
		
		mazo.setAlgoritmo(new OrdPalNumDec());
		mazo.ordena();
		System.out.println("La tercera línea ordena primero por número de forma descendente y, "
				+ " luego por palo en orden alfabético, "
				+ " realizando la comparación de forma inversa \n  " + mazo.toString());
		System.out.println("\n");
	
		mazo.setAlgoritmo(new OrdNumIncPal2());
		mazo.ordena();
		System.out.println(" La cuarta línea ordena primero por número en "
				+ " orden ascendente y despúes ordena por palo  \n " +mazo.toString());
		System.out.println("\n");
		// Me muestra las cartas del mazo una vez pasadas por el método barajar.
		mazo.barajar();
		System.out.println(" Esta línea muestra el mazo después de barajarlo. \n " +mazo.toString());
	}

	// TODO Apéndice de método generado automáticamente

}

