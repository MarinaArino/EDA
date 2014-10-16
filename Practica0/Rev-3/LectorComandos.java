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
	
	private static int total;
	private ColeccionEstatica <String, Par<String, Integer>> Coleccion = null;
	
	/**
	 * Metodo constructor de la clase.
	 */
	public LectorComandos() {
		total = 0;
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
						total++;
						out.format("INSERCION: %s;%s%n", batalla, descripcion);
					}
				}
				else if(scan.nextLine().equals(MODIFICAR)){
					String batalla = scan.nextLine();
					int participantes = scan.nextInt();
					if(Coleccion.esta(batalla)){
						Coleccion.iniciarIterador();
						while(Coleccion.existeSiguiente()){
							Par<String, Par<String, Integer>> elemento = Coleccion.siguiente();
							if(elemento.getIden() == batalla){
								//elemento.modIn(in);
							}
						}
					}
				}
				else if(scan.nextLine().equals(ELIMINAR)){
					
				}
				else if(scan.nextLine().equals(ELIMINAR)){
					
				}
				else if(scan.nextLine().equals(BUSCAR)){
					
				}
				else if(scan.nextLine().equals(LISTAR)){
					
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
		lector.hacerOperaciones();
	}
}
