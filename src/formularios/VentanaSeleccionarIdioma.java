package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaSeleccionarIdioma extends JFrame {

	private static final long serialVersionUID = 3L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaSeleccionarIdioma() {
		
		setResizable(false);
		setTitle("Idioma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
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
				cambiarIdioma(comboIdiomas.getSelectedItem().toString());
				dispose();
			}
		});
		btnSeleccionar.setBounds(60, 100, 110, 25);
		contentPane.add(btnSeleccionar);
	}
	private void cambiarIdioma(String idioma) {
		switch(idioma) {
			case "Español":
				VentanaPrincipal.localizacion = new Locale.Builder().setLanguage("es").setRegion("ES").build();
				break;
			case "Ingles":
				VentanaPrincipal.localizacion = new Locale.Builder().setLanguage("en").setRegion("US").build();
				break;
			default:
				VentanaPrincipal.localizacion = Locale.getDefault();	
		}
	}
}
