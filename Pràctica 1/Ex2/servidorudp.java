package ex2;

import java.net.*;
import java.io.*;

public class servidorudp {

	public static void main(String argv[]) {

		DatagramSocket socket;
		String missatge = "";
		String missatgeServidor = "";
	        byte[] missatge_bytes;
	        byte[] missatgeServidor_bytes;
	        DatagramPacket paquet;
	        DatagramPacket paquetServidor;
		InetAddress address;
		int port = 0;
		

		try {
			socket = new DatagramSocket(6000);

			while(1>0) {
				missatge_bytes = new byte[256];
				paquet = new DatagramPacket(missatge_bytes,256);
				socket.receive(paquet);

				missatge = new String(missatge_bytes).trim();
       			address = paquet.getAddress();
		         port = paquet.getPort();
		         
				if (missatge.startsWith("H")) {
					System.out.println("HELLO");
					missatgeServidor = "HELLO";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
				}
				else if (missatge.startsWith("REF")) {
					System.out.println("REF");
					missatgeServidor = "Refresc 2";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
				}						
				else if (missatge.startsWith("PAT")) {
					System.out.println("PAT");
					missatgeServidor = "Patates fregides 3";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
				}
				else if (missatge.startsWith("CRO")) {
					System.out.println("CRO");
					missatgeServidor = "Corissant 1";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
				}
				else if (missatge.startsWith("BOC")) {
					System.out.println("BOC");
					missatgeServidor = "Entrepa 2";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
				}
				else if (missatge.startsWith("ENS")) {
					System.out.println("ENS");
					missatgeServidor = "Ensaladilla 4";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
				
				}
				else if (missatge.startsWith("CAF")) {
					System.out.println("CAF");
					missatgeServidor = "cafe 1";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
					
				}
				
				else if (missatge.startsWith("fi")) {
					System.out.println(missatge);
					missatgeServidor = "fi";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
				} 
				else {
					System.out.println(missatge);
					missatgeServidor = "ERROR";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
			
				}
			}
		} 
		catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
}
