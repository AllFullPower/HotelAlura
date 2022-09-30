package cr.com.aluraHotel.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class NacionalidadNumeroController {
	private Map<List<String>, List<String>> nacionalidadNumero = new HashMap<>();
	private char comillas = 34;
	private String ruta = ".\\data\\nacionality\\Paises-Numero.csv";
	private List<String> nacionalidaes = new ArrayList<>();
	private List<String> numeros = new ArrayList<>();
	
	public Map<String, String> leerArchivoMap() {
		Map<String, String> resultado = new HashMap<>(); 
		File file = new File(ruta);	
		try(final Scanner scanner = new Scanner(file)) {
			String linea;
			while(scanner.hasNext() && (linea = scanner.nextLine()) != null) {
				String[] objetosSeparados = linea.split(",");
				if(objetosSeparados.length == 0);
				else{
					nacionalidaes.add(objetosSeparados[0]);
					numeros.add(objetosSeparados[1]);
					resultado.put(objetosSeparados[0], objetosSeparados[1]);
				}
			}
		this.nacionalidadNumero.put(nacionalidaes, numeros);
		
		scanner.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	
	public String getNumero(String nacionalidad) {
		return leerArchivoMap().get(nacionalidad);
	}


	public Object[] leerArchivoNacionalidad() {
		leerArchivoMap();
		String[] resultado = new String[nacionalidaes.size()];
		for(int i = 0; i < this.nacionalidaes.size(); i++) {
			resultado[i] = nacionalidaes.get(i);
		}

		return resultado;
	}

	
}
