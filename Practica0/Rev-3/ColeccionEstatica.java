package practica0;

public class ColeccionEstatica<Id, In> implements Coleccion<Id, In> {
	private static final int MAX = 100;

	private Par<Id, In>[] Tabla;
	private int total;
	private static int iterador;
	
	@SuppressWarnings("unchecked")
	public ColeccionEstatica() {
		this.total = 0;
		this.Tabla = (Par[]) new Object[MAX];
	}

	@Override
	public void meter(Id identificador, In informacion) {
		if (!esta(identificador)) {
			Par<Id, In> nuevo = new Par<Id, In>(identificador, informacion);
			Tabla[total] = nuevo;
			total++;
		} else {
			int indiceOtro = 0;
			while (indiceOtro < total) {
				if (Tabla[indiceOtro].equals(identificador)) {
					Tabla[indiceOtro].modIn(informacion);
				} else {
					indiceOtro++;
				}
			}
		}
	}

	
	@Override
	public boolean esta(Id identificador) {
		int indiceOtro = 0;
		boolean encontrado = false;
		while (indiceOtro < total && !encontrado) {
			if (Tabla[indiceOtro].equals(identificador)) {
				encontrado = true;
			} else {
				indiceOtro++;
			}
		}
		return encontrado;
	}

	
	@Override
	public In obtenerInformacion(Id identificador) throws noExisteIDException {
		int indiceOtro = 0;
		boolean encontrado = false;
		while (indiceOtro < total && !encontrado) {
			if (Tabla[indiceOtro].equals(identificador)) {
				encontrado = true;
			} else {
				indiceOtro++;
			}
		}
		if(encontrado){
			return Tabla[indiceOtro].getInfor();
		}
		else{
			throw new noExisteIDException();
		}
	}

	
	@Override
	public void borrar(Id identificador) {
		if (esta(identificador)) {
			int indiceOtro = 0;
			boolean encontrado = false;
			while (!encontrado) {
				if (Tabla[indiceOtro].equals(identificador)) {
					Tabla[indiceOtro] = null;
					encontrado = true;
				} else {
					indiceOtro++;
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
		iterador = 0;
	}

	
	public boolean existeSiguiente() {
		return iterador < total;
	}

	
	@Override
	public Par<Id, In> siguiente() throws NoHaySiguienteException {
		if (existeSiguiente()) {
			Par <Id, In> siguiente = Tabla[iterador];
			iterador++;
			return siguiente;
		} else {
			throw new NoHaySiguienteException();
		}
	}
}
