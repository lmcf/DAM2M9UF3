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
				if (missatge.startsWith("A")) {
					System.out.println("AVE");
					missatgeServidor = "AVE";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
				}
				else if (missatge.startsWith("SEV")) {
					System.out.println("SEV -150");
					missatgeServidor = "SEV -150";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
				}						
				else if (missatge.startsWith("V")) {
					System.out.println("VAL -60");
					missatgeServidor = "VAL -60";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
				}
				else if (missatge.startsWith("SEG")) {
					System.out.println("SEG -30");
					missatgeServidor = "SEG -30";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
				}
				else if (missatge.startsWith("M")) {
					System.out.println("MAD 0");
					missatgeServidor = "MAD 0";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
				}
				else if (missatge.startsWith("Z")) {
					System.out.println("ZAR 85");
					missatgeServidor = "ZAR 85";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
				
				}
				else if (missatge.startsWith("T")) {
					System.out.println("TAR 180");
					missatgeServidor = "tar 180";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
					
				}
				else if (missatge.startsWith("L")) {
					System.out.println("LLE 130");
					missatgeServidor = "LLE 130";
					missatgeServidor_bytes = missatgeServidor.getBytes();
					paquetServidor = new DatagramPacket(missatgeServidor_bytes,missatgeServidor.length(),address,port);
				        socket.send(paquetServidor);
					
				}
				else if (missatge.startsWith("B")) {
					System.out.println("BCN 205");
					missatgeServidor = "BCN 205";
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
					missatgeServidor = "DES 0";
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
