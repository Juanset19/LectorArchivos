/**
 * 
 */
package udem.pds.taller1.io;

/**
 * Convierte un caracter de mayúscula a minúscula
 */
public class FiltroMayusculaMinuscula implements IFiltro {

	/**
	 * Constructor por defecto
	 */
	public FiltroMayusculaMinuscula() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see udem.pds.taller1.io.IFiltro#filtrar(int)
	 */
	@Override
	public int filtrar(int caracter) {
		if (65 <= caracter && caracter <= 90) {
			return caracter += 32;
		} else {
			return caracter;
		}
	}

}
