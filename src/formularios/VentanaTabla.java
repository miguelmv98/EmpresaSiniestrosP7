package formularios;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import dominio.SiniestroTableModel;

import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaTabla extends JFrame {

	private static final long serialVersionUID = 1L;
	JTable table;
	SiniestroTableModel tableModel;

	/**
	 * Create the frame.
	 */
	public VentanaTabla(SiniestroTableModel tableModel) {
		initialize(tableModel);
	}

	private void initialize(SiniestroTableModel tableModel) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/shseguro.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		getContentPane().setLayout(null);
		
		table = new JTable(tableModel);
		table.setFillsViewportHeight(false);
		table.setAutoCreateRowSorter(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(5, 5, 1175, 600);
		getContentPane().add(scrollPane);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}
		});
		btnCerrar.setBounds(5, 610, 1175, 45);
		getContentPane().add(btnCerrar);
	}
	
	private void cerrar() 
	{
		this.dispose();
	}
	
}