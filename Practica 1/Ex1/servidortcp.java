import java.net.*;
import java.io.*;

public class servidortcp {
	public static void main(String argv[]) {
		ServerSocket socketEscolta;
		boolean fi = false;
		String missatge = "";

		try {
			socketEscolta = new ServerSocket(6001);
			while(1>0) {
				Socket socketClient = socketEscolta.accept();
				DataInputStream in = new DataInputStream(socketClient.getInputStream());
				DataOutputStream out = new DataOutputStream(socketClient.getOutputStream());	
				fi = false;

				while (!fi) {
					missatge = in.readUTF();
					// AVE
					if (missatge.startsWith("A")) {
						System.out.println(missatge);
						out.writeUTF(missatge);
						fi = true;
					}
					else {
						System.out.println("DES 0");
						out.writeUTF("DES 0");
					}
				}

				fi = false;
				while (!fi) {
					missatge = in.readUTF();
					if (missatge.startsWith("SEV")) {
						System.out.println("SEV -150");
						out.writeUTF("SEV -150");
					}						
					else if (missatge.startsWith("V")) {
						System.out.println("VAL -60");
						out.writeUTF("VAL -60");
					}
					else if (missatge.startsWith("SEG")) {
						System.out.println("SEG -30");
						out.writeUTF("SEG -30");
					}
					else if (missatge.startsWith("M")) {
						System.out.println("MAD 0");
						out.writeUTF("MAD 0");
					}
					else if (missatge.startsWith("Z")) {
						System.out.println("ZAR 85");
						out.writeUTF("ZAR 85");
					}
					else if (missatge.startsWith("T")) {
						System.out.println("TAR 180");
						out.writeUTF("TAR 180");
					}
					else if (missatge.startsWith("L")) {
						System.out.println("LLE 130");
						out.writeUTF("LLE 130");
					}
					else if (missatge.startsWith("B")) {
						System.out.println("BCN 205");
						out.writeUTF("BCN 205");
					}
					else if (missatge.startsWith("fi")) {
						System.out.println(missatge);
						out.writeUTF(missatge);
						in.close();
						out.close();
						socketClient.close();
						fi = true;
					} 
					else {
						System.out.println(missatge);
						out.writeUTF("DES 0");
					}
				}
			}
		} 
		catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
}
