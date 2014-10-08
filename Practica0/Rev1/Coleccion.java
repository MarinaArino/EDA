package practica0;

public interface Coleccion<Id, In> {
	
	/**
	 * Si en c no hay ningún par con identificador id, devuelve la colección resultante de añadir el par (id, info)
	 * a c.
	 * En caso contrario, devuelve la coleccion resultante de cambiar la informacion asociada a id en c por info. 
	 */
	void meter(Id identificador, In informacion);
	/**
	 * Devuelve verdad si y solo si en c hay algun par (id, info) para algun valor de info
	 */
	boolean esta(Id identificador);
	/**
	 * Dado un identificador id, devuelve la información asociada a él en c.
	 * Parcial: no definida si id no está en c.
	 */
	In obtenerInformacion(Id identificador);
	/**
	 * Si en c hay un par con indentificador id, devuelve la colección resultante de borrar ese par. 
	 * En caso contrario, devuelve una colección igual a c.
	 */
	void borrar(Id identificador);
	/**
	 * Devuelve el nº de pares en la colección
	 */
	int tamaño();
	/**
	 * Devuelve verdad si y sólo si c no tiene ningún par
	 */
	boolean esVacia();
	
	
	/**
	 * Devuelve un String con la información de todos los pares (identificador, información)
	 * almacenados en la colección, separando los pares entre sí
	 * con saltos de línea. 
     * En cada par, el identificador y la información estarán separados por un ";"}
	 * @return String con la información de todos los pares (identificador, información).
	 */
	String listar();
	

}
