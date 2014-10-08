package practica0;

public class ColeccionEstatica<Id, In> implements Coleccion<Id,In>{
	
	/* Datos privados del objeto */
	private static final int MAX = 100;
	private Id[] identificadores;
	private In[] informaciones;
	private int total;
	private int indice;
	
	/**
	 * Crea una coleccion vacia, sin pares.
	 */
	public ColeccionEstatica(){
		total = 0;
		identificadores = (Id[]) new Object[MAX];
		informaciones = (In[]) new Object[MAX];
	}
	
	
	@Override 
	public void meter(Id identificador, In informacion) {
		if(!esta(identificador)){
			identificadores[total] = identificador;
			informaciones[total] = informacion;
			total++;
		}
		else{
		    int indice = 0;
		    while(indice < total){
			if(identificadores[indice].equals(identificador){
				informaciones[indice] = informacion;
		        }
			else{
			    indice++;
			}
		    }
		}	
	}




	@Override
	public boolean esta(Id identificador) {
	    int indice = 0;
	    boolean encontrado = false;
	    while(indice < total && !encontrado){
		if(identificadores[indice].equals(identificador)){
		    encontrado = true;
		}
		else{
		    indice++;
		}
	    }
	    return encontrado;
	}




	@Override
	public In obtenerInformacion(Id identificador) {
	    int indice = 0;
	    boolean encontrado = false;
	    while(indice < total && !encontrado){
		if(identificadores[indice].equals(identificador)){
		    encontrado = true;
		}
		else{
		    indice++;
		}
	    }
	    return informaciones[indice];
	}




	@Override
	public void borrar(Id identificador) {
	    if(esta(identificador)){
		int indice = 0;
		boolean encontrado = false;
		while(!encontrado){
		    if(identificadores[indice].equals(identificador)){
			indentificadores[indice] = null;
			informaciones[indice] = null;
			encontrado = true;
		    }
		    else{
			indice++;
		    }
		}
	    }	
	}




	@Override
	public int tamaño() {
	    return total;
	}




	@Override
	public boolean esVacia() {
	    return total == 0;
	}




	@Override
	public String listar() {
		String listado = "";
		
		iniciarIterador();
		while (haySiguiente()) {
			try {
				listado += siguiente().toString() + "\n";
			} catch (NoHaySiguienteException e) {
			        
			}
		}		
			
		return listado;
	}
	private void iniciarIterador(){
	    indice = 0;
	}

	private boolean haySiguiente(){
	    return indice < total;
	}
}
