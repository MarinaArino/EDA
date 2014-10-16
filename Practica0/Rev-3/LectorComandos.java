package practica0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class LectorComandos {
	private static final String INTRO = "i";
	private static final String MODIFICAR = "m";
	private static final String ELIMINAR = "e";
	private static final String BUSCAR = "b";
	private static final String LISTAR = "l";
	
	private static final String FICH_ENTRADA = "entrada.txt";
	private static final String FICH_SALIDA = "salida.txt";
	
	private ColeccionEstatica <String, Par<String, Integer>> Coleccion = null;
	
	/**
	 * Metodo constructor de la clase.
	 */
	public LectorComandos() {
		Coleccion = new ColeccionEstatica<String, Par<String, Integer>>();
 	}
		
	/**
	 * Lee el texto y realiza las operaciones descritas en el.
	 * @throws NoHaySiguienteException 
	 */
	public void hacerOperaciones() throws NoHaySiguienteException {
		try {
			Scanner scan = new Scanner(new File(FICH_ENTRADA));
			PrintStream out = new PrintStream(FICH_SALIDA);
			while (scan.hasNextLine()) {
				if(scan.nextLine().equals(INTRO)){
					String batalla = scan.nextLine();
					String descripcion = scan.nextLine();
					//La informacion de la batalla ya se encuentra en 
					//coleccion.
					if(Coleccion.esta(batalla)){
						out.format("INSERCION DESECHADA: %s;%s%n", batalla, descripcion);
					}
					//La informacion no se encuentra. La metemos y despues informamos
					//en el fichero de salida.
					else{
						Par<String, Integer> informacion = new Par<String, Integer>(descripcion, 0);
						Coleccion.meter(batalla, informacion);
						out.format("INSERCION: %s;%s%n", batalla, descripcion);
					}
				}
				else if(scan.nextLine().equals(MODIFICAR)){
					String batalla = scan.nextLine();
					int participantes = scan.nextInt();
					//Creamos el objeto Integer para poder añadir luego al Par
					Integer parti = new Integer(participantes);
					if(Coleccion.esta(batalla)){
						//Recorremos la coleccion en busca del objeto a modificar
						Coleccion.iniciarIterador();
						boolean encontrado = false;
						while(Coleccion.existeSiguiente() && !encontrado){
							Par<String, Par<String, Integer>> elemento = Coleccion.siguiente();
							if(elemento.getIden().equals(batalla)){
								//Recuperamos la informacion y unicamente cambiamos el numero de participantes
								Par <String, Integer> informacion = elemento.getInfor();
								Par <String, Integer> nuevaInfor = new Par<String, Integer>
								(informacion.getIden(), parti);
								//Actualizamos la informacion en la coleccion
								elemento.modIn(nuevaInfor);
								encontrado = true;
							}
							else{
								Coleccion.siguiente();
							}
						}
						//Escribimos en el fichero de salida.
						out.format("MODIFICACION: %s;%d%n", batalla, participantes);
					}
					else{
						out.format("MODIFICACION DESECHADA: %s;%d%n", batalla, participantes);
					}
				}
				else if(scan.nextLine().equals(ELIMINAR)){
					String batalla = scan.nextLine();
					if(Coleccion.esta(batalla)){
						try{
							//Recuperamos la informacion para escribirla en el fichero de salida
							Par <String, Integer> informacion = Coleccion.obtenerInformacion(batalla);
							out.format("ELIMINACION: %s;%s%n", batalla, informacion.toString());
							Coleccion.borrar(batalla);
						}
						catch(noExisteIDException e){
							//Ya sabemos que esta, asi que no hacemos nada.
						}
					}
					else{
						out.format("ELIMINACION DESECHADA: %s%n", batalla);
					}
				}
				else if(scan.nextLine().equals(BUSCAR)){
					String batalla = scan.nextLine();
					if(Coleccion.esta(batalla)){
						try{
							//Recuperamos la informacion para escribirla en el fichero de salida
							Par <String, Integer> informacion = Coleccion.obtenerInformacion(batalla);
							out.format("BUSQUEDA CON EXITO: %s;%s%n", batalla, informacion.toString());
						}
						catch(noExisteIDException e){
							//Ya sabemos que esta, asi que no hacemos nada.
						}
					}
					else{
						out.format("BUSQUEDA SIN EXITO: %s%n", batalla);
					}
				}
				else if(scan.nextLine().equals(LISTAR)){
					out.format("TOTAL: %d%n", Coleccion.tamaño());
					out.format("%s", Coleccion.listar());
				}
			}
			scan.close();
			out.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("Error: no existe fichero de entrada " + FICH_ENTRADA);
		}
    }

 
	public static void main(String[] args) {
		LectorComandos lector = new LectorComandos();
		try {
			lector.hacerOperaciones();
		} catch (NoHaySiguienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
