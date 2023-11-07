package dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Siniestro {

	
	private String domicilio;
	private String descripcion;
	private LocalDate fecha; 
	private int horas;
	private double coste;
	private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter
	            .ofPattern("dd/MM/yyyy");

	public Siniestro() {};
	
	public Siniestro(String domicilio, String descripcion, String fecha, String horas, String coste) throws FechaValidationException {
		super();
		this.domicilio = domicilio;
		this.descripcion = descripcion;
		validateFecha(fecha);
		this.fecha = LocalDate.parse(fecha, DATE_FORMATTER);
		this.horas = Integer.parseInt(horas);
		this.coste = Double.parseDouble(coste);
	}
	
	
	public String getDomicilio() { return domicilio; }
	public void setDomicilio(String domicilio) { this.domicilio = domicilio; }
	
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	
	public LocalDate getFecha() { return fecha; }
	public void setFecha(String fecha) throws FechaValidationException 
	{
		validateFecha(fecha);
		this.fecha = LocalDate.parse(fecha, DATE_FORMATTER);
	}
	public void setFecha(LocalDate fecha) 
	{
		this.fecha = fecha;
	}
	
	private void validateFecha(String fecha) throws FechaValidationException
	{
		if(!fecha.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) 
		{
			throw new FechaValidationException("Formato de fecha incorrecto, el formato debe ser 'dd/MM/yyyy'");		
		}
	}
	
	public int getHoras() { return horas; }
	public void setHoras(int horas) { this.horas = horas; }
	

	public double getCoste() { return coste; }
	public void setCoste(double coste) { this.coste = coste; }
}
