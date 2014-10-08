package practica0;

@SuppressWarnings("serial")
public class NoHaySiguienteException extends Exception {
	
	public NoHaySiguienteException() {
		super("No hay par siguiente en la coleccion");
	}
}
