package udem.pds.taller1.io;

/**
 * Se crea la interfaz IFiltro para establecer un contrato de filtro de caracteres. *
 */
public interface IFiltro {

	/**
	 * Filtra un caracter de acuerdo a unas reglas específicas
	 * 
	 * @param caracter
	 * @return caracter convertido
	 */
	public int filtrar(int caracter);
}
