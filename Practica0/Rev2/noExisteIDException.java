package practica0;

@SuppressWarnings("serial")
public class noExisteIDException extends Exception {
	
	public noExisteIDException(){
		super("No existe ningun Par con esta ID en la coleccion");
	}

}
