package application.bank;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.bank.Client;
//import entites.bank.Client;
import entites.bank.Conta;

public class AppCaixaEletronico {

	public static void main(String[] args) {
		
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Bem vindo(a) ao Banco Genérico: ");
			System.out.println("Digite S para saque");
			System.out.println("D para depósito");
	 		System.out.println("T para transferências entre contas: ");
	 		System.out.println("E para Sair: ");
			
	 		
	 		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date d = new Date();
				
			Conta conta12 = new Conta(1001, new Client("Bryan", 123), 1000.0, 200.0);
			Conta conta13 = new Conta(1002, new Client("Sophie", 456), 500.0, 200.0);
			
			while(true) {
				char n = sc.next().charAt(0);
			
				if(n == 'S') {
							System.out.println("Digite o valor a ser sacado: ");
							double x = sc.nextDouble();
							conta12.saque(x);
							System.out.println();
							System.out.println(sdf.format(d));
							System.out.println();
							conta12.getCliente().getCpf();
							System.out.println(conta12);
							System.out.println("Titular: " + conta12.getCliente().getHolderName());
							System.out.println("CPF: " + conta12.getCliente().getCpf());
							System.out.println("----------------");
							}
			
				else if(n == 'D') {
							System.out.println("Digite o valor do depósito: ");
							double y = sc.nextDouble();
							conta12.deposito(y);
							System.out.println();
							System.out.println(sdf.format(d));
							System.out.println();
							conta12.getCliente().getCpf();
							System.out.println(conta12);
							System.out.println("Titular: " + conta12.getCliente().getHolderName());
							System.out.println("CPF: " + conta12.getCliente().getCpf());
							System.out.println("----------------");
							}
			
				else if(n == 'T') {	
							System.out.println("Digite o valor a ser transferido: ");
							double valor = sc.nextDouble();
							conta12.transferir(conta13, valor);
							System.out.println();
							System.out.println(sdf.format(d));
							System.out.println();
							conta12.getCliente().getCpf();
							System.out.println(conta12);
							System.out.println("Titular: " + conta12.getCliente().getHolderName());
							System.out.println("CPF: " + conta12.getCliente().getCpf());
							System.out.println("----------------");
							
							System.out.println();
							System.out.println(sdf.format(d));
							System.out.println();
							conta12.getCliente().getCpf();
							System.out.println(conta13);
							System.out.println("Titular: " + conta13.getCliente().getHolderName());
							System.out.println("CPF: " + conta13.getCliente().getCpf());
							System.out.println("----------------");
							}
				
				else if(n == 'E') {
					System.out.println("Obrigado por utilizar os Caixas Genéricos, volte sempre !!!");
					
				}
			}
		}
	}
		
	

