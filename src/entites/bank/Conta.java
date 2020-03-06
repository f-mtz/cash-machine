package entites.bank;

import java.text.SimpleDateFormat;

public class Conta {
	
	int accountNumber;
	Client cliente;
	double saldo = 1000;
	public Conta() {
	SimpleDateFormat date;
	}

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
			return this.saldo -= (x + 5);
	}
	/**DEPOSITO*/
	public double deposito(double y) {
		if(y > 1000) {
			System.out.println("você não pode depositar mais que 1000 reais por dia !!!");
		}
		return this.saldo += y;
	}
	public void transferir(Conta receptora, double valor) {
		this.saque(valor);
		receptora.deposito(valor);
	}
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
		public static void clearScreen() {
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}	
	
	public String toString() {
		return "Número da conta: " + accountNumber + "\n"+
				"O saldo atual da conta é: " + saldo
			;
	}
}
