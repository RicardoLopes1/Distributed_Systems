import java.net.*;
import java.io.*;
import java.util.Scanner;

public class UDPClient{
    public static void main(String args[]){
    	System.out.println("Digite a operação que deseja fazer (Exemlo: 1+1 ou 7*8 ): ");
		Scanner ler = new Scanner(System.in);
    	// messageUDP give message contents and destination hostname
		DatagramSocket aSocket = null;
		try {
			String messageUDP = ler.nextLine();
			System.out.println("Requisição: "+ messageUDP);

			aSocket = new DatagramSocket();    
			byte [] m = messageUDP.getBytes();
			InetAddress aHost = InetAddress.getByName("localhost");
			int serverPort = 6789;		                                                 
			DatagramPacket request =
			 	new DatagramPacket(m,  messageUDP.length(), aHost, serverPort);
			aSocket.send(request);// envia a mensagem pro servidor
			/* ********************** */
			byte[] buffer = new byte[150]; //tamanho do buffer
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
			aSocket.receive(reply);//recebe a resposta do servidor
			System.out.println("Resposta: " + new String(reply.getData()));
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
	}		      	
}
