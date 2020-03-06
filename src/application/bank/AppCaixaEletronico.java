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
		
		
		
		
//		Client cliente0;
//		cliente0 = new Client();
//		
//		Client cliente1 = new Client();
//		
//		
//		Client cliente2 = new Client("J", 12345);
////		
////		//-------------------------
//		String holderName;
//		int cpf;
//		
//		holderName = sc.next();
//		cpf = sc.nextInt();
//		Client cliente3 = new Client(holderName, cpf);
////	
////		//--------------------------
////		
//		String holderName4 = sc.next();
//		int cpf4 = sc.nextInt();
//		
//		Client cliente4 = new Client(holderName4, cpf4);
//		
//		//--------------------------
//
//		Client cliente5 = new Client("Lucifer", 54321);
//		cliente5.setHolderName("Sheldon");
//		cliente5.setCpf(12345);
//		
//		System.out.println(cliente5);
//		
//		//---------------------------
//		
//		System.out.println("Digite o nome dos personagens: ");
//		String holderName6 = sc.next();
//		int cpf6 = sc.nextInt();
//		
//		Client cliente6 = new Client(holderName6, cpf6);
//		cliente6.setHolderName(holderName6 = sc.next()); 
//		/**o argumento dentro do set é desnecessário nesse modelo de declaração*/
//		cliente6.setCpf(cpf6 = sc.nextInt());
//		
//		System.out.println(cliente6);
//		sc.close();
//
//		/**ERRO cliente7*/
//		Client cliente7 = new Client();
//		cliente7.setHolderName(holderName7);
//		cliente7.setCpf(cpf7);
//		/**Aqui o erro ocorre por 2 motivos
//		 * primeiro é setar uma String no parâmetro/atributo cpf que é do tipo int
//		 * Obs.: Sim, poderiamos inserir um parâmetro no setCpf chamado cpf7
//		 * porém isso seria uma variável que nesse caso não foi declara e nem inicializada nem em default
//		 * e nem pelo teclado*/
//		
//		Client cliente8 = new Client();
//		cliente7.setHolderName("Homer");
//		cliente7.setCpf(888);
//	
//		Conta conta9 = new Conta();
//		conta9.accountNumber(555);
//		
//		Conta conta10 = new Conta();
//		conta10.setAccountNumber(555);
//		
//		/**ERROR conta11*/
//		Conta conta11 = new Conta().setAccountNumber(555);
//		/**Não podemos fazer isso pois o tipo/Objeto Conta possui 2 atributos
//		 * O atributo Client cliente e o atributo int accountNumber
//		 * e o método setAccountNumber não pode ser aplicado no atributo Client cliente,
//		 * pois esse claramente possui um tipo diferentes dos parâmetros usados no método*/
			
	//		System.out.println("digite o número de transações");
	//		int n = sc.nextInt();
	//		Transacoes [] transacoes = new Transacoes[n];
	//		for(int i=0; i<transacoes.length; i++) {
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Bem vindo(a) ao Santander: ");
			System.out.println("Digite S para saque");
			System.out.println("D para depósito");
	 		System.out.println("T para transferências entre contas Caixa: ");
	 		System.out.println("E para Sair: ");
			
	 		
	 		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date d = new Date();
				
			Conta conta12 = new Conta(1001, new Client("Heliot", 123), 1000);
			Conta conta13 = new Conta(1002, new Client("Obrienn", 456), 500);
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
					System.out.println("Obrigado por utilizar os caixas Santander, volte sempre !!!");
					
				}
			}
		}
	}
		
	

