package practica0;

public class Par <T, K> {
	private T identificador;
	private K informacion;
	
	public Par(T id, K in){
		this.identificador = id;
		this.informacion = in;
	}
	
	public void modId(T id){
		this.identificador = id;
	}
	
	public void modIn(K in){
		this.informacion = in;
	}
	
	@Override
	public String toString(){
		return identificador.toString() + ";" + informacion.toString();
	}

}
