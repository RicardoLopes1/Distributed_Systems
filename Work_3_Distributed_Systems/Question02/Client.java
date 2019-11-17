

import java.rmi.Naming;

public class Client {
	public static void main(String[] args) {
		if(System.getSecurityManager() == null){
			System.setSecurityManager(new SecurityManager());
		} else System.out.println("Already has a security manager, so cant set RMI SM");
		ServerFile serverFile = null;
		try {
			serverFile  = (ServerFile) Naming.lookup("ServerFile");
			System.out.println("Found server");
			if(args[0].equals("list")) {
				if(args.length > 1) System.out.println(serverFile.list(args[1]));
				else System.out.println(serverFile.list());
			}else if(args[0].equals("remove")) {
				if(args.length == 3)System.out.println(serverFile.remove(args[1]+" "+args[2]));
				else System.out.println(serverFile.remove(args[1]));
			}else System.out.println("opção Inválida");
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}
