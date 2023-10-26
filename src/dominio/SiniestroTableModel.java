package dominio;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class SiniestroTableModel extends AbstractTableModel
{
	String[] nombresColumnas = { "Domicilio", "Descripción", "Fecha", "Horas", "Coste" };
	ArrayList<Siniestro> siniestros=new ArrayList<Siniestro>();
	
	public SiniestroTableModel(){};
	public int getColumnCount() {return nombresColumnas.length; }
	public int getRowCount() { return siniestros.size(); }
	public String getColumnName(int columnIndex) { return nombresColumnas[columnIndex];}
	
	public Object getValueAt(int row, int col) {
		switch(col){
			case 0: return siniestros.get(row).getDomicilio();
			case 1: return siniestros.get(row).getDescripcion();
			case 2: return siniestros.get(row).getFecha();
			case 3: return siniestros.get(row).getHoras();
			case 4: return siniestros.get(row).getCoste();
			default : return null;
		}
	}
	public void addRow(Siniestro siniestro) { siniestros.add(siniestro); }
	
}
