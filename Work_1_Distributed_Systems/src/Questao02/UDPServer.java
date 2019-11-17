import FirstP.Calculadora4Operacoes;

import java.net.*;
import java.io.*;
public class UDPServer{
    public static void main(String args[]){
		String resposta = "";
    	DatagramSocket aSocket = null;
		try{
	    	aSocket = new DatagramSocket(6789);
					// create socket at agreed port
			byte[] buffer = new byte[150];
 			while(true){
 				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
  				aSocket.receive(request);//mensagem recebida aqui

				if (buffer.length != 0) {
					String s = new String(buffer);
					char[] cArray = s.toCharArray();
					char op = 'f';
					Double n1 = 0.0;
					Double n2 = 0.0;


					for (int i = 0; i < cArray.length; i++) {
						if (cArray[i] == '+' || cArray[i] == '-' || cArray[i] == '*' || cArray[i] == '/') {
							op = cArray[i];
							String s1 = s.substring(0, s.indexOf(cArray[i]));//captura o primeiro operando antes da operação
							String s2 = s.substring(s.indexOf(cArray[i]) + 1, cArray.length);//captura o segundo operando antes da operação
							n1 = Double.parseDouble(s1);//casting do primeiro operando
							n2 = Double.parseDouble(s2);////casting do segundo operando
							break;

						}
					}
					Calculadora4Operacoes calc = new Calculadora4Operacoes();
					Double result = 0.0;

					switch (op) {
						case '+':
							result = calc.soma(n1, n2);
							resposta = Double.toString(result);
							break;
						case '-':
							result = calc.subtracao(n1, n2);
							resposta = result.toString();
							break;
						case '*':
							result = calc.multiplic(n1, n2);
							resposta = String.valueOf(result);
							break;
						case '/':
							if (n2 == 0.0)
								resposta = "Operacao invalida! Impossivel dividir por zero";
							else {
								result = calc.divisao(n1, n2);
								resposta = result.toString();
							}
							break;
						default:
							//resposta = new String(buffer);
							resposta = "ERRO!OPERACAO INVALIDA.";
							break;
					}
				}


    			DatagramPacket reply = new DatagramPacket(resposta.getBytes(), resposta.length(),
    				request.getAddress(), request.getPort()); // resposta do servidor
    			aSocket.send( reply); // envia a resposta do servido ao cliente
    		}
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e) {System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
    }
}
