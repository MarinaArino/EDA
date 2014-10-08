package practica0;

public class ColeccionEstatica<Id, In> implements Coleccion<Id, In> {
	private static final int MAX = 100;

	private Id[] identificadores;
	private In[] informaciones;
	private int total;
	private int indice;

	@SuppressWarnings("unchecked")
	public ColeccionEstatica() {
		this.total = 0;
		this.indice = 0;
		this.identificadores = (Id[]) new Object[MAX];
		this.informaciones = (In[]) new Object[MAX];
	}

	
	@Override
	public void meter(Id identificador, In informacion) {

		if (!esta(identificador)) {
			identificadores[total] = identificador;
			informaciones[total] = informacion;
			total++;
		} else {
			int indice = 0;
			while (indice < total) {
				if (identificadores[indice].equals(identificador)) {
					informaciones[indice] = informacion;
				} else {
					indice++;
				}
			}
		}
	}

	
	@Override
	public boolean esta(Id identificador) {
		int indice = 0;
		boolean encontrado = false;
		while (indice < total && !encontrado) {
			if (identificadores[indice].equals(identificador)) {
				encontrado = true;
			} else {
				indice++;
			}
		}
		return encontrado;
	}

	
	@Override
	public In obtenerInformacion(Id identificador) throws noExisteIDException {
		int indice = 0;
		boolean encontrado = false;
		while (indice < total && !encontrado) {
			if (identificadores[indice].equals(identificador)) {
				encontrado = true;
			} else {
				indice++;
			}
		}
		if(encontrado){
			return informaciones[indice];
		}
		else{
			throw new noExisteIDException();
		}
	}

	
	@Override
	public void borrar(Id identificador) {
		if (esta(identificador)) {
			int indice = 0;
			boolean encontrado = false;
			while (!encontrado) {
				if (identificadores[indice].equals(identificador)) {
					identificadores[indice] = null;
					informaciones[indice] = null;
					encontrado = true;
				} else {
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
		while (existeSiguiente()) {
			try {
				listado += siguiente().toString() + "\n";
			} catch (NoHaySiguienteException e) {
				System.out.println(e);
			}
		}

		return listado;
	}

	
	public void iniciarIterador() {
		indice = 0;
	}

	
	public boolean existeSiguiente() {
		return indice < total;
	}

	
	@Override
	public Par<Id, In> siguiente() throws NoHaySiguienteException {
		if (existeSiguiente()) {
			Par<Id, In> siguiente = new Par<Id, In>(identificadores[indice],
					informaciones[indice]);
			indice++;
			return siguiente;
		} else {
			throw new NoHaySiguienteException();
		}
	}
}
