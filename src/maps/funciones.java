package maps;

import java.awt.geom.Point2D;
import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;

import maps.java.*;


public class funciones {
	
	/*
	 * Devuelve las coordenadas geogr�ficas asociadas a la direcci�n postal enviada
	 */
	public static String getCoordenadas(String sitio){
		Geocoding ObjGeocod = new Geocoding();
		Point2D.Double resultadoCD = null;
		try {
			resultadoCD = ObjGeocod.getCoordinates(sitio);

		} catch (UnsupportedEncodingException | MalformedURLException e) {
			e.printStackTrace();
		}
		return resultadoCD.x + "," + resultadoCD.y;
	}
	/*
	 * Devuelve el conjunto de direcciones postales asociadas al punto geogr�fico (latitude/longitude)
	 * Nos devuelve:
	 * 		Calle, n�, C.P. Ciudad, Pais
	 * 		Barrio, C.P. Ciudad, Pais
	 * 		Atoche, Ciudad, Pais
	 * 		Distrito, Ciudad, Pais
	 * 		Ciudad, Pais
	 * 		C.P. Ciudad, Pais
	 * 		Ciudad, Pais
	 * 		�rea Metropolitalitana y Corredor del Henares, Ciudad, Pais
	 * 		Ciudad, Pais
	 * 		Provincio, Pais
	 * 		Pais
	 */
	public static void getDireccion(Double latitud, Double longitud){
		Geocoding ObjGeocod=new Geocoding();
		ArrayList<String> resultadoCI = null;
		try {
			resultadoCI = ObjGeocod.getAddress(latitud,longitud);
			for(String direccion:resultadoCI){
				System.out.println(direccion);
			}
		} catch (UnsupportedEncodingException | MalformedURLException e) {
			e.printStackTrace();
		}	
	}
	public static void main(String[] args) {
		System.out.println(getCoordenadas("Bilbao, adsndasds"));
		getDireccion(40.40044959, -3.688268601);
	}
}
