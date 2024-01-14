package dominio;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import formularios.VentanaPrincipal;

public class Siniestro {

	static Locale localizacion;
	static ResourceBundle mensajes;
	private String domicilio;
	private String descripcion;
	private LocalDate fecha; 
	private int horas;
	private double coste;
	private String importeLocale;
	private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter
	            .ofPattern("dd/MM/yyyy");

	public Siniestro() {};
	
	public Siniestro(String domicilio, String descripcion, String fecha, String horas, String coste, Locale localizacion,ResourceBundle mensajes) throws FechaValidationException {
		super();
		Siniestro.localizacion = localizacion;
		Siniestro.mensajes = mensajes;
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
			throw new FechaValidationException(mensajes.getString("error"));		
		}
	}
	
	public int getHoras() { return horas; }
	public void setHoras(int horas) { this.horas = horas; }
	

	public String getCoste() { 
		NumberFormat formatoCoste = NumberFormat.getCurrencyInstance(localizacion);
		importeLocale = formatoCoste.format(coste);
		return importeLocale; 
	}
	public void setCoste(double coste) { this.coste = coste; }
}
