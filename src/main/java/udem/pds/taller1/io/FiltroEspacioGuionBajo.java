/**
 * 
 */
package udem.pds.taller1.io;

/**
 * Convierte un espacio a guion bajo
 */
public class FiltroEspacioGuionBajo implements IFiltro {

	/**
	 * Constructor por defecto
	 */
	public FiltroEspacioGuionBajo() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see udem.pds.taller1.io.IFiltro#filtrar(int)
	 */
	@Override
	public int filtrar(int caracter) {
		if(caracter == 32) {
			return 95;
		} else {
			return caracter;
		}
	}

}
