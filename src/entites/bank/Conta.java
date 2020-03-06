package entites.bank;

import java.text.SimpleDateFormat;

public class Conta {
	
	private int accountNumber;
	private Client cliente;
	private double saldo;
	public Conta conta;
	private int qtdSaques;
	private int qtdDepositos;
	private int qtdTransferencias;
	SimpleDateFormat date;
	

	public Conta(int accountNumber, Client cliente, double saldo) {
		this.accountNumber = accountNumber;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}


	public double getSaldo() {
		return saldo;
	}
	/**SAQUE*/
	public double saque(double x) {
		if(x > saldo) {
			System.out.println("você negativou sua conta !");}
		else if (x == 0) {
			deposito(5);
		}
		qtdSaques++;
		return this.saldo -= (x + 5);
	}
	/**DEPOSITO*/
	public double deposito(double y) {
		if(y > 1000) {
			System.out.println("você não pode depositar mais que 1000 reais por dia !!!");
		}
		qtdDepositos++;
		return this.saldo += y;
	}
	/**TRANSAFERNCIAS*/
	public void transferir(Conta receptora, double valor) {
		this.saque(valor);
		receptora.deposito(valor);
		qtdTransferencias++;
	}

	public String toString() {
		return "Número da conta: " + accountNumber + "\n"+
				"O saldo atual da conta é: " + saldo + "\n" +
				"Quantidade de saques: " + qtdSaques +"\n" +
				"Quantidade de depósitos: " + qtdDepositos +"\n" +
				"Quantidade de transferências: " + qtdTransferencias +"\n"
			;
	}
}
