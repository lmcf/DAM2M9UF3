package practica2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.omg.CORBA.portable.UnknownException;

public class usera {
	final static int puerto = 6000;
	
	public static void main(String[] args) throws IOException, UnknownException{
			Scanner scanner = new Scanner(System.in);
			
			// Conexion con el servidor 
			Socket socket  = new Socket("localhost", puerto);
			
			// Obtenemos el input y el output
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			
			// Thread para enviar msg
			Thread enviarMensaje = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(true)
					{
						String msgOut = scanner.nextLine();
						
						try {
							// Enviamos msg
							outputStream.writeUTF(msgOut);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}
			});
			
			// Thread para leer
			Thread leerMensaje = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(true) {
						try {
							// Leer 
							String msgIn = inputStream.readUTF();
							System.out.println(msgIn);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					
				}
			});
			
			enviarMensaje.start();
			leerMensaje.start();
	}
}
