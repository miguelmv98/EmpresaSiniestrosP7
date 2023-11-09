package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class VentanaErrorDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	JLabel lblMensajeError;

	/**
	 * Create the frame.
	 */
	public VentanaErrorDatos(String mensajeError) {
		initialize();
		setMensajeError(mensajeError);
	}

	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 150);
		getContentPane().setLayout(null);
		
		lblMensajeError = new JLabel("");
		lblMensajeError.setBounds(10, 10, 366, 64);
		getContentPane().add(lblMensajeError);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(150, 82, 85, 21);
		getContentPane().add(btnNewButton);
	}
	
	private void setMensajeError(String mensajeError) 
	{ 
		lblMensajeError.setText(mensajeError );
	}
}
