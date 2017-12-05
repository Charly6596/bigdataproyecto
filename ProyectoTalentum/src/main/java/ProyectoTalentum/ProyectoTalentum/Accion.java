package ProyectoTalentum.ProyectoTalentum;

import org.javatuples.Pair;

import java.util.Date;

import ProyectoTalentum.ProyectoTalentum.Usuario;



public class Accion {
	
	private Pair<Double, Double> coordenadas = new Pair<Double, Double>(null, null);
	 
	private Date FechaInicio;//Cambiar a string si dan por saco
	private Date FechaFin;

	private String FotoInicio;
	private String FotoFin;
	
	private boolean Validada;
	
	private Usuario[] grupo = new Usuario[10];

	/**
	 * 
	 * @param coordenadas
	 * @param fechaInicio
	 * @param fotoInicio
	 * @param grupo
	 */
	public Accion(Pair<Double, Double> coordenadas, Date fechaInicio,
			String fotoInicio, Usuario[] grupo) {
		super();
		this.coordenadas = coordenadas;
		FechaInicio = fechaInicio;
		FotoInicio = fotoInicio;
		this.grupo = grupo;
	}
	
	

}
