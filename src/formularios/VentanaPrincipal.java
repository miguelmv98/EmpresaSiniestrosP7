package formularios;

import javax.swing.JFrame;

import dominio.FechaValidationException;
import dominio.Siniestro;
import dominio.SiniestroTableModel;
import formularios.VentanaPrincipal;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCoste;
	private JTextField txtHoras;
	private JTextField txtFecha;
	private JTextField txtDescripcion;
	private JTextField txtDomicilio;
	static Locale localizacion;
	static ResourceBundle mensajes;
	static SiniestroTableModel tableModel;


	/**
	 * Create the application.
	 */
	public VentanaPrincipal(Locale localizacion, ResourceBundle mensajes) {
		VentanaPrincipal.localizacion = localizacion;
		VentanaPrincipal.mensajes = mensajes;
		initialize();
		System.out.print(localizacion);
		tableModel = new SiniestroTableModel(localizacion,mensajes);
	}

	private void btnGuardarMouseClicked(MouseEvent e) {
		try {
			tableModel.addRow(new Siniestro (txtDomicilio.getText(),txtDescripcion.getText(), txtFecha.getText(), txtHoras.getText(), txtCoste.getText(), localizacion, mensajes));
			
			txtDomicilio.setText("");
	        txtDescripcion.setText("");
	        txtFecha.setText("");
	        txtHoras.setText("");
	        txtCoste.setText("");
	        
			new VentanaTabla(tableModel,mensajes).setVisible(true);
		} catch (FechaValidationException e1) {
			VentanaErrorDatos  vent = new VentanaErrorDatos(e1.getMessage(), mensajes);
			vent.setVisible(true);
		}
		
	}
	
	private void validarCaracteres(KeyEvent e) {
		char c = e.getKeyChar();
		
		if (Character.isAlphabetic(c)) {
			e.consume();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/shseguro.png")));
		this.setTitle(mensajes.getString("titulo"));
		this.setResizable(false);
		this.setBounds(100, 100, 450, 300);
		this.setSize(500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbDomicilio = new JLabel(mensajes.getString("domicilio"));
		lbDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbDomicilio.setBounds(29, 85, 85, 13);
		panel.add(lbDomicilio);
		
		JLabel lbDescripcion = new JLabel(mensajes.getString("descripcion"));
		lbDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lbDescripcion.setBounds(29, 156, 85, 13);
		panel.add(lbDescripcion);
		
		JLabel lbFecha = new JLabel(mensajes.getString("fecha"));
		lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbFecha.setBounds(29, 345, 85, 13);
		panel.add(lbFecha);
		
		JLabel lbHoras = new JLabel(mensajes.getString("horas"));
		lbHoras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbHoras.setBounds(29, 416, 85, 13);
		panel.add(lbHoras);
		
		JLabel lbCoste = new JLabel(mensajes.getString("coste"));
		lbCoste.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbCoste.setBounds(231, 416, 85, 13);
		panel.add(lbCoste);
		
		JButton btnGuardar = new JButton(mensajes.getString("guardar"));
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Redireccionar a Ventana Tabla y pasar objeto de siniestro ***
				btnGuardarMouseClicked(e);
			}
		});
		btnGuardar.setBounds(221, 488, 111, 30);
		panel.add(btnGuardar);
		
		txtCoste = new JTextField();
		// Permite al usuario ingresar solo números
		txtCoste.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		txtCoste.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCoste.setBounds(231, 432, 222, 34);
		panel.add(txtCoste);
		txtCoste.setColumns(10);
		// Permite al usuario ingresar solo números
		txtHoras = new JTextField();
		txtHoras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
			 
		});
		txtHoras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtHoras.setBounds(29, 432, 192, 34);
		panel.add(txtHoras);
		txtHoras.setColumns(10);

		//convert String to LocalDate
		txtFecha = new JTextField();
		txtFecha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validarCaracteres(e);
			}
		});
		txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		//localDateFecha = LocalDate.parse(txtFecha.getText(), formatter);
		txtFecha.setBounds(29, 361, 426, 34);
		panel.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDescripcion.setBounds(29, 174, 426, 146);
		panel.add(txtDescripcion);
		txtDescripcion.setColumns(1);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDomicilio.setBounds(29, 102, 426, 34);
		panel.add(txtDomicilio);
		txtDomicilio.setColumns(10);
		
		JButton btnSalir = new JButton(mensajes.getString("salir"));
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(342, 488, 111, 30);
		panel.add(btnSalir);	
		
		JLabel lblNewLabel = new JLabel(mensajes.getString("subtitulo"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(29, 24, 198, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(mensajes.getString("contexto"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(29, 52, 407, 13);
		panel.add(lblNewLabel_1);
	}
}
