package practica0;
import practica0.noExisteIDException;

public interface Coleccion<Id, In> {
	
	public void meter(Id id, In info);
	
	public boolean esta(Id id);
	
	public In obtenerInformacion (Id id) throws noExisteIDException;
	
	public void borrar(Id id);
	
	public int tamaño();
	
	public boolean esVacia();
	
	/**
	 * Devuelve un String con la información de todos los pares (identificador, información)
	 * almacenados en la colección, separando los pares entre sí
	 * con saltos de línea. 
         * En cada par, el identificador y la información estarán separados por un “;”}
	 * @return String con la información de todos los pares (identificador, información).
	 */
	public String listar();
	
	//Devuelve un objeto Par que contiene Id y In y avanza el iterador
	public Par<Id, In> siguiente() throws NoHaySiguienteException;
	

}
