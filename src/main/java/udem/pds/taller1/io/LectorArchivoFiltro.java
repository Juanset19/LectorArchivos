/**
 * 
 */
package udem.pds.taller1.io;

import java.io.IOException;
import java.util.List;

import udem.pds.taller1.io.base.Lector;
import udem.pds.taller1.io.base.LecturaException;

/**
 *
 */
public class LectorArchivoFiltro extends LectorComplejo {

	private List<IFiltro> filtros;

	/**
	 * Constructor del lector con filtro
	 * 
	 * @param rutaArchivo
	 */
	public LectorArchivoFiltro(String rutaArchivo) {
		super(rutaArchivo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see udem.pds.taller1.io.LectorComplejo#cerrar()
	 */
	@Override
	public void cerrar() throws LecturaException {
		try {
			this.stream.close();
		} catch (IOException e) {
			throw new LecturaException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see udem.pds.taller1.io.LectorComplejo#leer()
	 */
	@Override
	public int leer() throws LecturaException {
		int caracter = 0;
		for (Lector lectorBase : lectoresBase) {
			caracter = lectorBase.leer();
			caracter = aplicarFiltros(caracter);
		}
		return caracter;
	}

	/**
	 * Aplica los filtros configurados del lector
	 * 
	 * @param caracter
	 * @return caracter convertido de acuerdo a los filtros
	 */
	private int aplicarFiltros(int caracter) {
		for (IFiltro filtro : filtros) {
			caracter = filtro.filtrar(caracter);
		}
		return caracter;
	}

	/**
	 * @return the filtros
	 */
	public List<IFiltro> getFiltros() {
		return filtros;
	}

	/**
	 * @param filtros
	 *            the filtros to set
	 */
	public void setFiltros(List<IFiltro> filtros) {
		this.filtros = filtros;
	}

}
