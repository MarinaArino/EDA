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
	
	
	public LectorComandos() {
	}
		
	public void hacerOperaciones() {
		try {
			Scanner scan = new Scanner(new File(FICH_ENTRADA));
			PrintStream out = new PrintStream(FICH_SALIDA);
			while (scan.hasNextLine()) {
				//Tratar cada instruccion
				
			}
			{
		catch (FileNotFoundException e) {
			System.err.println("Error: no existe fichero de entrada " + FICH_ENTRADA);
		}
        }

 
	public static void main(String[] args) {
		LectorComandos lector = new LectorComandos();
		lector.hacerOperaciones();
	}
}
