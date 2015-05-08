package servidor;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import cliente.Cliente;

public class Servidor extends UnicastRemoteObject implements Cliente{
	Logger logger = Logger.getLogger(Servidor.class.getName());
	
	FileHandler fh = new FileHandler("log.txt");  
	
	protected Servidor() throws IOException {
		super();
	}

	private static final long serialVersionUID = 1L;
	
	public int soma(int a, int b){
		return a + b;
	}
	public int sub(int a, int b){
		return a - b;
	}
	public int mult(int a, int b){
		return a * b;
	}
	public int div(int a, int b){
		return a / b;
	}
	
	@Override
	public int operacao (String operacao) throws SecurityException, IOException {
	    fh.setFormatter(new SimpleFormatter());  
		logger.addHandler(fh);  
	    logger.info("Chamada ao objeto remoto...\n");
		
		if(operacao.contains("+")){
			logger.info("Realizando operação de soma.\n");
			return soma(Integer.parseInt(operacao.substring(0, operacao.indexOf("+"))), Integer.parseInt(operacao.substring(operacao.indexOf("+")+1)));
		}
		if(operacao.contains("-")){
			logger.info("Realizando operação de subtração.\n");
			return sub(Integer.parseInt(operacao.substring(0, operacao.indexOf("-"))), Integer.parseInt(operacao.substring(operacao.indexOf("-")+1)));
		}
		if(operacao.contains("*")){
			logger.info("Realizando operação de multiplicação.\n");
			return mult(Integer.parseInt(operacao.substring(0, operacao.indexOf("*"))), Integer.parseInt(operacao.substring(operacao.indexOf("*")+1)));
		}
		if(operacao.contains("/")){
			logger.info("Realizando operação de divisão.\n");
			return div(Integer.parseInt(operacao.substring(0, operacao.indexOf("/"))), Integer.parseInt(operacao.substring(operacao.indexOf("/")+1)));
		}
		logger.warning("Operação invalida!\n");
		return -999;
	}

}
