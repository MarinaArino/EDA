package practica0;

public class Par <T, K> {
	private T identificador;
	private K informacion;
	/**
	 * Metodo constructor de la clase.
	 * 
	 */
	public Par(T id, K in){
		this.identificador = id;
		this.informacion = in;
	}
	
	/**
	 * Cambia el parametro identificador por [id].
	 */
	public void modId(T id){
		this.identificador = id;
	}
	/**
	 * Cambia el parametro informacion por [in].
	 */
	public void modIn(K in){
		this.informacion = in;
	}
	/**
	 * Devuelve el identificador asociado al objeto.
	 */
	public T getIden(){
		return identificador;
	}
	/**
	 * Devuelve la informacion asociada al objeto.
	 */
	public K getInfor(){
		return informacion;
	}
	
	@Override
	public String toString(){
		return identificador.toString() + ";" + informacion.toString();
	}

}
