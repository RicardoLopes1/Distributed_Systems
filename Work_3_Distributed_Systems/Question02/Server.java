
import java.rmi.*;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
		try {
			int port = 8512;
			//Registry registry = LocateRegistry.createRegistry(port);	
			ServerFile serverFile = new ServantFile();
			@SuppressWarnings("unused")
			ServerFile stub = (ServerFile) UnicastRemoteObject.exportObject(serverFile,0);
			Naming.rebind("ServerFile",serverFile);
			System.out.println("Server run!");
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}
