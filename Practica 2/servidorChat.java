package practica2;

import java.io.*;
import java.util.*;
import java.net.*;

public class servidorChat {
	static List<Cliente> clientes = new ArrayList<Cliente>();

	public static void main(String[] args) throws IOException {
		// Socket que el server escucha + puerto
		final int puerto = 6000;
		ServerSocket serverSocket = new ServerSocket(puerto);
		
		int count = 0;
		
		while(true) {
			count++; 
			
			// Aceptamos lo que venga
			Socket cs = serverSocket.accept();
			
			// Obtener el input y output Stream
			DataInputStream inputStream = new DataInputStream(cs.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(cs.getOutputStream());
			
			Cliente cliente = new Cliente(cs, "user"+count , inputStream, outputStream);
			
			Thread tr = new Thread(cliente);
			
			clientes.add(cliente);
			
			tr.start();
			
		}

		

	}

	static class Cliente implements Runnable {
		Scanner Scanner = new Scanner(System.in);
		private String nombreCliente;
		DataInputStream inputStream;
		DataOutputStream outputStream;
		Socket socket;
		Boolean online;

		public Cliente(Socket socket, String nombreCliente, DataInputStream inputStream,
				DataOutputStream outputStream) {
			this.inputStream = inputStream;
			this.outputStream = outputStream;
			this.nombreCliente = nombreCliente;
			this.socket = socket;
			this.online = true;
			;
		}

		@Override
		public void run() {
			String msg;

			while (true) {
				try {
					// Mensaje que recibe el server
					msg = inputStream.readUTF();
					System.out.println(msg);

					if (msg == "/s") {
						this.socket.close();
						break;
					}

					for (Cliente client : servidorChat.clientes) {
						if (client.online) {
							client.outputStream.writeUTF(this.nombreCliente + " : " + msg);
							break;
						}
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// Cerramos input y output
			try {
				// Cerrar el input y output Stream
				this.inputStream.close();
				this.outputStream.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
