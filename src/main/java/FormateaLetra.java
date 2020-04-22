
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("all")

public class FormateaLetra extends javax.swing.JFrame implements ActionListener, ChangeListener {

	JTextArea cancion = new JTextArea();
	String separador;
	String os;
	private JTextField paso;

	JTextArea letra = new JTextArea();

	public FormateaLetra() {
		setTitle("Formatea Letra");

		os = System.getProperty("os.name");

		separador = Metodos.saberSeparador(os);

		initComponents();
		this.setVisible(true);

	}

	private void initComponents() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		setResizable(false);

		JButton btnNewButton = new JButton("");

		btnNewButton.setIcon(new ImageIcon(FormateaLetra.class.getResource("/imagenes/converter.png")));

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					int pasoCorte = Integer.parseInt(paso.getText());

					if (!letra.getText().isEmpty() && pasoCorte > 0) {

						cancion.setText(Metodos.formatearCancion(letra.getText(), pasoCorte));

					}

					else {

						Metodos.mensaje("Debes insertar el texto y poner un número mayor a cero", 3);
					}
				}

				catch (Exception e1) {
					Metodos.mensaje("Debes insertar el texto y poner un número mayor a cero", 3);

				}
			}

		});

		JScrollPane scrollPane = new JScrollPane((Component) null);

		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		paso = new JTextField();
		paso.setHorizontalAlignment(SwingConstants.CENTER);
		paso.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nº palabras a cortar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setToolTipText("Pon aqui la letra de la cancion");
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JButton btnNewButton_1 = new JButton("");

		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Metodos.copiarAlPortapapeles(cancion.getText());
			}

		});

		btnNewButton_1.setIcon(new ImageIcon(FormateaLetra.class.getResource("/imagenes/copy.png")));

		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon(FormateaLetra.class.getResource("/imagenes/clean.png")));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancion.setText("");
			}
		});

		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				letra.setText("");
			}

		});

		btnNewButton_1_1_1.setIcon(new ImageIcon(FormateaLetra.class.getResource("/imagenes/clean.png")));

		JButton btnNewButton_1_2 = new JButton("");

		btnNewButton_1_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					Metodos.crearFichero(new File(".").getCanonicalPath() + separador + "resultado.txt",
							cancion.getText(), false);
				} catch (IOException e1) {
					//
				}
			}

		});

		btnNewButton_1_2.setIcon(new ImageIcon(FormateaLetra.class.getResource("/imagenes/txt.png")));

		JLabel lblNewLabel_1 = new JLabel("Insertar texto");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(80).addComponent(lblNewLabel_1,
												GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addGap(50)
												.addGroup(layout
														.createParallelGroup(Alignment.TRAILING)
														.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 248,
																Short.MAX_VALUE)
														.addComponent(scrollPane_1, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
												.addGap(33)
												.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout
														.createSequentialGroup()
														.addGroup(layout.createParallelGroup(Alignment.TRAILING)
																.addComponent(btnNewButton_1_1,
																		GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
																.addComponent(btnNewButton_1, Alignment.LEADING,
																		GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
																.addComponent(btnNewButton_1_1_1, Alignment.LEADING,
																		GroupLayout.PREFERRED_SIZE, 48,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(18)
														.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 45,
																GroupLayout.PREFERRED_SIZE)
														.addGap(36))
														.addGroup(layout.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblNewLabel).addComponent(paso,
																		GroupLayout.PREFERRED_SIZE, 138,
																		GroupLayout.PREFERRED_SIZE)))
												.addGap(15)))
								.addGap(15))
						.addGroup(layout.createSequentialGroup().addContainerGap(424, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGap(39)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
				.addGap(26)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
								.addComponent(paso, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
								.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 42,
										GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(layout.createSequentialGroup().addGap(70).addComponent(scrollPane,
								GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(11)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 48,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE))
								.addGap(23).addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 42,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(30)));
		letra.setFont(new Font("Monospaced", Font.PLAIN, 16));

		scrollPane_1.setViewportView(letra);
		cancion.setFont(new Font("Monospaced", Font.PLAIN, 16));

		scrollPane.setViewportView(cancion);
		getContentPane().setLayout(layout);
		setSize(new Dimension(514, 447));
		setLocationRelativeTo(null);
	}

	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
