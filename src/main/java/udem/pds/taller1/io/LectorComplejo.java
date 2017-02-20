/**
 * 
 */
package udem.pds.taller1.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import udem.pds.taller1.io.base.Lector;
import udem.pds.taller1.io.base.LecturaException;

/**
 * Clase lector compolejo que permite modificar la funcionalidad de lector sin afectar el componenente ya funcional.
 */
public abstract class LectorComplejo implements Lector {

	protected FileInputStream stream;
	protected List<Lector> lectoresBase;

	/**
	 * Constructor de un lector complejo
	 * 
	 * @param rutaArchivo
	 */
	public LectorComplejo(String rutaArchivo) {
		try {
			this.stream = new FileInputStream(rutaArchivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see udem.pds.taller1.io.base.Lector#cerrar()
	 */
	@Override
	public abstract void cerrar() throws LecturaException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see udem.pds.taller1.io.base.Lector#leer()
	 */
	@Override
	public abstract int leer() throws LecturaException;

	/**
	 * @return the lectoresBase
	 */
	public List<Lector> getLectoresBase() {
		return lectoresBase;
	}

	/**
	 * @param lectoresBase
	 *            the lectoresBase to set
	 */
	public void setLectoresBase(List<Lector> lectoresBase) {
		this.lectoresBase = lectoresBase;
	}

}
