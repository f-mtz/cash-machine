package application.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
		System.out.println("B para consultar extrato por predicado Mês e Ano: ");
		
		
		Conta conta12 = new Conta(1001, new Client("Bryan", 123), 1000.0, 200.0);
		Conta conta13 = new Conta(1002, new Client("Sophie", 456), 500.0, 200.0);
		
		List<String> historic = new ArrayList<>();
		
		//System.out.println("Enter file path: ");
		String sourceFileStr = "C:\\in.csv";
		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();

		boolean success = new File(sourceFolderStr + "Archives csv").mkdir();

		String targetFileStr = sourceFolderStr + "\\Archives csv\\ATM.statement.csv";

		try (BufferedReader line = new BufferedReader(new FileReader(sourceFileStr))) {
			
			String itemCsv = line.readLine();
			while (itemCsv != null) {

				String[] fields = itemCsv.split(",");
				int accountNumber = Integer.parseInt(fields[0]);
				double saldo = Double.parseDouble(fields[1]);
				int qtdSaques = Integer.parseInt(fields[2]);
				int qtdDepositos = Integer.parseInt(fields[3]);
				int qtdTransferencias = Integer.parseInt(fields[4]);
				double limitSaque = Double.parseDouble(fields[5]);
				String sdf = fields[6];

				historic.add(conta12.csvPrinter());

				itemCsv = line.readLine();
			}
			try (BufferedWriter escreva = new BufferedWriter(new FileWriter(targetFileStr, true))) {
				for (int i = 0; i < 1; i++) {
//					while (true) {
					
					char n = sc.next().charAt(0);
					if (n == 'S') {
						System.out.println();
						System.out.println("Digite o valor a ser sacado: ");
						double x = sc.nextDouble();
						conta12.saque(x);
						System.out.println();
						System.out.println(conta12);
					}
					
					else if (n == 'D') {
						System.out.println();
						System.out.println("Digite o valor do depósito: ");
						double y = sc.nextDouble();
						conta12.deposito(y);
						System.out.println();
						System.out.println(conta12);
					}

					else if (n == 'T') {
						System.out.println();
						System.out.println("Digite o valor a ser transferido: ");
						double valor = sc.nextDouble();
						conta12.transferir(conta13, valor);
						System.out.println();
						System.out.println(conta12);
						System.out.println();
						System.out.println(conta13);
					}

					else if (n == 'E') {
						System.out.println();
						System.out.println("Extrato resumido: ");
						System.out.println();
						System.out.println(conta12);
						
					
					} else if (n == 'V') {
						System.out.println();
						System.out.println("Extrato Detalhado: ");
						System.out.println();
						System.out.println(
				"Nome | CPF | M.Transações | nº Conta | Saldo | Saques | Depositos | Transderências"
										+ "\n");
						System.out.println();
						System.out.println(historic);
						}
					
					historic.add(conta12.csvPrinter());
				
				line.readLine();
				escreva.write(conta12.csvPrinter());
				escreva.newLine();
		}
			System.out.println(targetFileStr + " CREATED!");

		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		}
	}
	
}

	

