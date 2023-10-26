package dominio;

import java.time.LocalDate;

public class Siniestro {

	
	private String domicilio;
	private String descripcion;
	private LocalDate fecha; 
	private int horas;
	private double coste;
	
	
	public Siniestro() {};
	
	public Siniestro(String domicilio, String descripcion, LocalDate fecha, int horas, double coste) {
		super();
		this.domicilio = domicilio;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.horas = horas;
		this.coste = coste;
	}

	public String getDomicilio() { return domicilio; }
	public void setDomicilio(String domicilio) { this.domicilio = domicilio; }
	
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	
	public LocalDate getFecha() { return fecha; }
	public void setFecha(LocalDate fecha) { this.fecha = fecha; }
	
	public int getHoras() { return horas; }
	public void setHoras(int horas) { this.horas = horas; }
	
	public double getCoste() { return coste; }
	public void setCoste(double coste) { this.coste = coste; }
}
