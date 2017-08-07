package logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jorge Silva Borda
 */
public class Logger {

    File archivo;

    public Logger() {

    }

    public Logger(File archivo) {
	this.archivo = archivo;
    }

    public Logger(String rutaArchivo) {
	this.archivo = new File(rutaArchivo);
    }

    public void log(String mensaje) {
	FileWriter fichero = null;
	PrintWriter pw = null;
	try {
	    fichero = new FileWriter(this.archivo.getAbsolutePath(), true);
	    pw = new PrintWriter(fichero);
	    pw.println(mensaje);
	} catch (IOException ex) {
	    System.out.println("No se puede escribir el fichero de log.");
	    System.out.println(ex);
	} finally {
	    try {
		if (null != fichero) {
		    fichero.close();
		}
	    } catch (IOException ex) {
		System.out.println("No se pudo cerrar el escritor del fichero de log.");
		System.out.println(ex);
	    }
	}
    }

    public void log(Exception e) {
	FileWriter fichero = null;
	PrintWriter pw = null;
	try {
	    fichero = new FileWriter(this.archivo.getAbsolutePath(), true);
	    pw = new PrintWriter(fichero);
	    pw.println(e.toString());
	} catch (IOException ex) {
	    System.out.println("No se puede escribir el fichero de log.");
	    System.out.println(ex);
	} finally {
	    try {
		if (null != fichero) {
		    fichero.close();
		}
	    } catch (IOException ex) {
		System.out.println("No se pudo cerrar el escritor del fichero de log.");
		System.out.println(ex);
	    }
	}
    }
}
