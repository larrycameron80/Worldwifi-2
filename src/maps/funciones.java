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
	 * 		Plaza Puerta del Sol, 6, 28013 Madrid, Espa�a
	 * 		Puerta del Sol, 28013 Madrid, Espa�a
	 * 		Sol, Madrid, Espa�a
	 * 		28013 Madrid, Espa�a
	 * 		Centro, Madrid, Espa�a
	 * 		Madrid, Espa�a
	 * 		Madrid, Espa�a
	 * 		�rea Metropolitalitana y Corredor del Henares, Madrid, Espa�a
	 * 		Madrid, Espa�a
	 * 		Comunidad de Madrid, Espa�a
	 * 		Espa�a
	 */
	public static String getDireccion(Double latitud, Double longitud){
		String d = null;
		Geocoding ObjGeocod=new Geocoding();
		ArrayList<String> resultadoCI = null;
		try {
			resultadoCI = ObjGeocod.getAddress(latitud,longitud);
			for(String direccion:resultadoCI){
				System.out.println(direccion);
				d = ""+ direccion;
			}
		} catch (UnsupportedEncodingException | MalformedURLException e) {
			e.printStackTrace();
		}	

		
		return d;
	}
	public static void main(String[] args) {
		System.out.println(getCoordenadas("Bilbao, adsndasds"));
		System.out.println(getDireccion(40.40044959, -3.688268601));
	}
}
