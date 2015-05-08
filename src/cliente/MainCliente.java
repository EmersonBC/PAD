package cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class MainCliente {
	
	public static void main(String[] args) throws NotBoundException, IOException {
		Cliente cliente = (Cliente) Naming.lookup("calc");
		Scanner sc = new Scanner(System.in);
		String nome;
		String op = "0";
		
		System.out.println("Digite o nome do arquivo:");
		nome = sc.nextLine();
		
		FileReader arq = new FileReader(nome); 
		BufferedReader lerArq = new BufferedReader(arq);
		
		while (op != null) { 
			op = lerArq.readLine();
			
			if(op != null)
				System.out.println("\n"+ op +" = "+ cliente.operacao(op));
		}

	}

}
