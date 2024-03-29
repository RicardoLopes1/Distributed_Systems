package Questao01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {
	public static void main(String[] args) {
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket(6789);
			byte[] buffer = new byte[1000];
			while (true) {
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(),
						request.getPort());
				aSocket.send(reply);
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}
