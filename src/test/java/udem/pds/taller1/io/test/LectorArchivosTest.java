package udem.pds.taller1.io.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import udem.pds.taller1.io.FiltroEspacioGuionBajo;
import udem.pds.taller1.io.FiltroMayusculaMinuscula;
import udem.pds.taller1.io.IFiltro;
import udem.pds.taller1.io.LectorArchivoFiltro;
import udem.pds.taller1.io.base.Lector;
import udem.pds.taller1.io.base.LectorArchivo;
import udem.pds.taller1.io.base.LecturaException;

public class LectorArchivosTest {

	private static final String TEST_FILE_PATH = "C:\\test\\UdeM\\udem_test_lector_archivos.txt";

	@Test
	public void testLectorSimple() {
		System.out.println("Lectura simple::");
		LectorArchivo lectorArchivo = new LectorArchivo(TEST_FILE_PATH);
		assertEquals("Prueba del Lector de Archivos", leer(lectorArchivo));
	}
	
	@Test
	public void testLectorMayusculaMinuscula(){
		System.out.println("Convertir mayúsculas a minúsulas::");
		LectorArchivoFiltro lectorArchivoFiltro = new LectorArchivoFiltro(TEST_FILE_PATH);
		LectorArchivo lectorArchivo = new LectorArchivo(TEST_FILE_PATH);
		FiltroMayusculaMinuscula filtroMayusculaMinuscula = new FiltroMayusculaMinuscula();
		lectorArchivoFiltro.setLectorBase(lectorArchivo);
		ArrayList<IFiltro> filtros = new ArrayList<IFiltro>();
		filtros.add(filtroMayusculaMinuscula);
		lectorArchivoFiltro.setFiltros(filtros);
		assertEquals("prueba del lector de archivos", leer(lectorArchivoFiltro));
	}
	
	@Test
	public void testLectorEspacioGuionBajo() {
		System.out.println("Convertir espacio a guión bajo::");
		LectorArchivoFiltro lectorArchivoFiltro = new LectorArchivoFiltro(TEST_FILE_PATH);
		LectorArchivo lectorArchivo = new LectorArchivo(TEST_FILE_PATH);
		FiltroEspacioGuionBajo filtroEspacioGuionBajo = new FiltroEspacioGuionBajo();
		lectorArchivoFiltro.setLectorBase(lectorArchivo);
		ArrayList<IFiltro> filtros = new ArrayList<IFiltro>();
		filtros.add(filtroEspacioGuionBajo);
		lectorArchivoFiltro.setFiltros(filtros);
		assertEquals("Prueba_del_Lector_de_Archivos", leer(lectorArchivoFiltro));
	}
	
	@Test
	public void testLectorMayusculaMinusculaGuionBajo(){
		System.out.println("Convertir mayúsculas a minúsulas y espacios a guión bajo::");
		LectorArchivoFiltro lectorArchivoFiltro = new LectorArchivoFiltro(TEST_FILE_PATH);
		LectorArchivo lectorArchivo = new LectorArchivo(TEST_FILE_PATH);
		FiltroMayusculaMinuscula filtroMayusculaMinuscula = new FiltroMayusculaMinuscula();
		FiltroEspacioGuionBajo filtroEspacioGuionBajo = new FiltroEspacioGuionBajo();
		lectorArchivoFiltro.setLectorBase(lectorArchivo);
		ArrayList<IFiltro> filtros = new ArrayList<IFiltro>();
		filtros.add(filtroEspacioGuionBajo);
		lectorArchivoFiltro.setFiltros(filtros);
		filtros.add(filtroMayusculaMinuscula);
		assertEquals("prueba_del_lector_de_archivos", leer(lectorArchivoFiltro));
	}

	/**
	 * Ejecuta la lectura de la interfaz lector
	 * 
	 * @param lector
	 * @return texto que lee de una archivo
	 */
	public String leer(Lector lector) {
		String texto = "";
		try {
			int i = 0;
			char c;
			while ((i = lector.leer()) != -1) {
				// converts integer to character
				c = (char) i;
				// prints character
				
				System.out.print(c);
				texto += c;
			}
			System.out.println();
		} catch (LecturaException e) {
			e.printStackTrace();
			fail();
		} finally {
			try {
				lector.cerrar();
			} catch (LecturaException e) {
				e.printStackTrace();
				fail();
			}
		}
		return texto;
	}

}
