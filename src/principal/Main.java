package principal;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

//Server
public class Main {

	public static void main(String[] args) {
				
		try{
			//1� On instancie l'objet "serveur" contenant les m�thodes RMI
			Server_Communicator_Impl server = new Server_Communicator_Impl();
			
			//2� D�marrage du registre sur le port 1099
			LocateRegistry.createRegistry(1099);
			
			//3� On d�clare le serveur dans le registre RMI
			Naming.rebind("server-1", server);
			
			System.out.println("[SERVER ONLINE]");
			
			while(true){
				//4� On garde le server en attente, pas d'autres actions dans le thread principal.
				//L'appel d'une m�thode RMI g�n�re automatiquement un nouveau thread.
			}
		}catch(RemoteException | MalformedURLException e){
			e.printStackTrace();
		}
	}

}
