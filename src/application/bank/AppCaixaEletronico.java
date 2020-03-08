package application.bank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entites.bank.Client;
import entites.bank.Conta;

public class AppCaixaEletronico {

	public static void main(String[] args) throws IOException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Bem vindo(a) ao Banco Genérico: ");
		System.out.println("Digite S para saque");
		System.out.println("D para depósito");
		System.out.println("T para transferências entre contas: ");
		System.out.println("V para visualizar extrato das transações: ");
		System.out.println("E para Sair: ");
		List<String>historic = new ArrayList<>();
		Conta conta12 = new Conta(1001, new Client("Bryan", 123), 1000.0, 200.0);
		Conta conta13 = new Conta(1002, new Client("Sophie", 456), 500.0, 200.0);
		
		for (int i=0; i<=10; i++) {
			char n = sc.next().charAt(0);
				if (n == 'S') {
					
					System.out.println("Digite o valor a ser sacado: ");
					double x = sc.nextDouble();
					conta12.saque(x);
//					System.out.println(conta12);
				}

				else if (n == 'D') {
					System.out.println("Digite o valor do depósito: ");
					double y = sc.nextDouble();
					conta12.deposito(y);
//					System.out.println(conta12);
				}

				else if (n == 'T') {
					System.out.println("Digite o valor a ser transferido: ");
					double valor = sc.nextDouble();
					conta12.transferir(conta13, valor);
//					System.out.println(conta12);
//					System.out.println(conta13);
				}

				else if (n == 'E') {
					System.out.println("Extrato resumido: ");
					System.out.println(conta12);
				}
				else if(n == 'V') {
					System.out.println(historic);
				}
				historic.add(conta12.toString());
			}
		sc.close();
		}

	}

