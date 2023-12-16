package formularios;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import dominio.SiniestroTableModel;

import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;
import java.awt.BorderLayout;

public class VentanaTabla extends JFrame {

	private static final long serialVersionUID = 1L;
	JTable table;
	SiniestroTableModel tableModel;
	static ResourceBundle mensajes;

	/**
	 * Create the frame.
	 */
	public VentanaTabla(SiniestroTableModel tableModel,ResourceBundle mensajes) {
		VentanaTabla.mensajes = mensajes;
		initialize(tableModel);
	}

	private void initialize(SiniestroTableModel tableModel) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/shseguro.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		getContentPane().setLayout(new BorderLayout(5, 5));
		
		table = new JTable(tableModel);
		table.setFillsViewportHeight(false);
		table.setAutoCreateRowSorter(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);
		
		JButton btnCerrar = new JButton(mensajes.getString("salirT"));
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}
		});
		getContentPane().add(btnCerrar, BorderLayout.SOUTH);
	}
	
	private void cerrar() 
	{
		this.dispose();
	}
	
}