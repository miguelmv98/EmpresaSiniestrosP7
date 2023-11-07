package formularios;

import java.awt.EventQueue;

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
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPrincipal {

	private JFrame frmFormularioReparacin;
	private JTextField txtCoste;
	private JTextField txtHoras;
	private JTextField txtFecha;
	private JTextField txtDescripcion;
	private JTextField txtDomicilio;
	
	static SiniestroTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tableModel = new SiniestroTableModel();
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmFormularioReparacin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	private void btnGuardarMouseClicked(MouseEvent e) {
		try {
			tableModel.addRow(new Siniestro (txtDomicilio.getText(),txtDescripcion.getText(), txtFecha.getText(), txtHoras.getText(), txtCoste.getText()));
			new VentanaTabla(tableModel).setVisible(true);
		} catch (FechaValidationException e1) {
			VentanaErrorDatos vent = new VentanaErrorDatos(e1.getMessage());
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
		frmFormularioReparacin = new JFrame();
		frmFormularioReparacin.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/shseguro.png")));
		frmFormularioReparacin.setTitle("Formulario Siniestro");
		frmFormularioReparacin.setResizable(false);
		frmFormularioReparacin.setBounds(100, 100, 450, 300);
		frmFormularioReparacin.setSize(500, 600);
		frmFormularioReparacin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmFormularioReparacin.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbDomicilio = new JLabel("Domicilio:");
		lbDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbDomicilio.setBounds(29, 85, 85, 13);
		panel.add(lbDomicilio);
		
		JLabel lbDescripcion = new JLabel("Descripción: ");
		lbDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lbDescripcion.setBounds(29, 156, 85, 13);
		panel.add(lbDescripcion);
		
		JLabel lbFecha = new JLabel("Fecha:");
		lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbFecha.setBounds(29, 345, 85, 13);
		panel.add(lbFecha);
		
		JLabel lbHoras = new JLabel("Horas:");
		lbHoras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbHoras.setBounds(29, 416, 85, 13);
		panel.add(lbHoras);
		
		JLabel lbCoste = new JLabel("Coste:");
		lbCoste.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbCoste.setBounds(231, 416, 85, 13);
		panel.add(lbCoste);
		
		JButton btnGuardar = new JButton("Guardar");
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
				validarCaracteres(e);
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
			
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(342, 488, 111, 30);
		panel.add(btnSalir);	
		
		JLabel lblNewLabel = new JLabel("Alta Reparación");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(29, 24, 198, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("A través del formulario podrás dar de alta una reparación del siniestro. ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(29, 52, 407, 13);
		panel.add(lblNewLabel_1);
	}
}
