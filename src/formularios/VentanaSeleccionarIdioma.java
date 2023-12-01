package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.SiniestroTableModel;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaSeleccionarIdioma {

	private JFrame frmVentanaSeleccionarIdioma;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSeleccionarIdioma window = new VentanaSeleccionarIdioma();
					window.frmVentanaSeleccionarIdioma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaSeleccionarIdioma() {
		
		initialize();
	}

	private void initialize() {

		frmVentanaSeleccionarIdioma = new JFrame();
		frmVentanaSeleccionarIdioma.setResizable(false);
		frmVentanaSeleccionarIdioma.setTitle("Idioma");
		frmVentanaSeleccionarIdioma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVentanaSeleccionarIdioma.setBounds(100, 100, 240, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frmVentanaSeleccionarIdioma.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarIdioma = new JLabel("Seleccionar idioma de la aplicación");
		lblSeleccionarIdioma.setBounds(15, 30, 210, 15);
		contentPane.add(lblSeleccionarIdioma);
		
		JComboBox comboIdiomas = new JComboBox();
		comboIdiomas.setModel(new DefaultComboBoxModel(new String[] {"Español", "Ingles"}));
		comboIdiomas.setBounds(20, 50, 190, 20);
		contentPane.add(comboIdiomas);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Locale localizacion = obtenerLocale(comboIdiomas.getSelectedItem().toString());
				VentanaPrincipal ventana = new VentanaPrincipal(localizacion,ResourceBundle.getBundle("MisDatos",localizacion));
				frmVentanaSeleccionarIdioma.dispose();
				ventana.setVisible(true);
			}
		});
		btnSeleccionar.setBounds(60, 100, 110, 25);
		contentPane.add(btnSeleccionar);
	}
	private Locale obtenerLocale(String idioma) {
		switch(idioma) {
			case "Español":
				return new Locale.Builder().setLanguage("es").setRegion("ES").build();
			case "Ingles":
				return new Locale.Builder().setLanguage("en").setRegion("US").build();
			default:
				return Locale.getDefault();	
		}
	}
}
