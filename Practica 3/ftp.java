package ftp;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
public class ftp {
	public static final String ipServer = "192.168.1.54";
	public static final String user = "caldeiro";
	public static final String passw = "qwert!\"·45";

	public static void main(String[] args) throws SocketException, IOException {
		FTPClient cliente = new FTPClient();
		String servFTP = "192.168.1.54";
		System.out.println("Nos conectamos a: " + servFTP);

		String usuario = "testftp";
		String clave = "123456";

		try {
			cliente.connect(servFTP, 21);
			boolean login = cliente.login(user, passw);
			if (login)
				System.out.println("Login correcto...");
			else {
				System.out.println("Login Incorrecto...");
				cliente.disconnect();
				System.exit(1);
			}

			/// Imprimir contenido del directorio actual
			System.out.println("Directorio actual: "
					+ cliente.printWorkingDirectory());
			FTPFile[] files = cliente.listFiles();
			System.out.println("Ficheros en el directorio actual:"
					+ files.length);
	
			String tipos[] = {"Fichero", "Directorio","Enlace simb."};
			
			for (int i = 0; i < files.length; i++) {
				System.out.println("\t" + files[i].getName() + " " + files[i].getSize());
			}
			
			// Delete
			cliente.deleteFile("prueba1.txt");
			
			// Rename
			cliente.rename("prueba2.txt", "pruebaRenamed.txt");
			
			boolean logout = cliente.logout();
			if (logout)
				System.out.println("Logout del servidor FTP...");
			else
				System.out.println("Error al hacer Logout...");
			
			cliente.disconnect();
			System.out.println("Desconectado...");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
