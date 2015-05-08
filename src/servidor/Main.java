package servidor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Main {

	public static void main(String[] args) throws SecurityException, IOException {
			Servidor server = new Servidor();
				    
			Naming.rebind("calc", server);
			
	}

}
