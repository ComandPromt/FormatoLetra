import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public abstract class Metodos {

	public static String saberSeparador(String os) {
		if (os.equals("Linux")) {
			return "/";
		} else {
			return "\\";
		}
	}

	public static void crearFichero(String ruta, String texto, boolean carpeta) throws IOException {

		File archivo = new File(ruta);

		if (carpeta) {

			if (!archivo.exists()) {
				archivo.mkdir();
			}

		}

		else {

			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

			try {
				bw.write(texto);
			}

			finally {
				bw.close();
			}
		}
	}

	public static void mensaje(String mensaje, int titulo) {

		String tituloSuperior = "";

		int tipo = 0;

		switch (titulo) {

		case 1:
			tipo = JOptionPane.ERROR_MESSAGE;
			tituloSuperior = "Error";

			break;

		case 2:
			tipo = JOptionPane.INFORMATION_MESSAGE;
			tituloSuperior = "Informacion";

			break;

		case 3:
			tipo = JOptionPane.WARNING_MESSAGE;
			tituloSuperior = "Advertencia";

			break;

		default:
			break;

		}

		JLabel alerta = new JLabel(mensaje);

		alerta.setFont(new Font("Arial", Font.BOLD, 18));

		JOptionPane.showMessageDialog(null, alerta, tituloSuperior, tipo);

	}

	public static void copiarAlPortapapeles(String texto) {

		Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();

		StringSelection testData;

		testData = new StringSelection(texto);

		c.setContents(testData, testData);
	}

	public static String formatearCancion(String letra, int paso) {

		letra = letra.replace("  ", " ");

		int contador = 0;

		LinkedList<Integer> indices = new LinkedList();

		int indice = letra.indexOf(" ");

		String cancion = letra;

		String song = "";

		while (indice != -1) {

			++contador;

			indice = letra.indexOf(" ");

			if (contador % paso == 0 && indice > -1) {

				letra = letra.substring(indice + 1, letra.length());

				letra = letra.replace("@", " ");

				indices.add(indice);

			}

			else {

				letra = letra.replaceFirst(" ", "@");

			}

		}

		int guardo = 0;

		for (int i = 1; i < indices.size(); i++) {
			guardo = indices.get(i) + indices.get(--i);
			indices.set(++i, guardo + 1);
		}

		indices.add(cancion.length());

		int hasta = 0;

		song += cancion.substring(0, indices.get(0)) + "\n";

		for (int i = 0; i < indices.size(); i++) {

			++i;

			if (i < indices.size()) {
				hasta = indices.get(i);
			}

			else {
				hasta = 0;
			}

			--i;

			if (hasta != 0) {
				song += cancion.substring(indices.get(i) + 1, hasta) + "\n";

			}

		}

		return song;

	}

}
