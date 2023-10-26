package dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import javax.swing.table.AbstractTableModel;

public class SiniestroTableModel extends AbstractTableModel
{
	String[] nombresColumnas = { "Domicilio", "Descripción", "Fecha", "Horas", "Coste" };
	Object[][] datos = { { "Prueba", "Prueba mas laraga", LocalDate.of( 2023 , Month.OCTOBER , 26 ), LocalTime.of(9, 20), 100 } };
	
	public SiniestroTableModel(){};
	public int getColumnCount() {return nombresColumnas.length; }
	public int getRowCount() { return datos.length; }
	public Object getValueAt(int row, int col) {return datos[row][col];}
	public String getColumnName(int columnIndex) { return nombresColumnas[columnIndex];}
}
