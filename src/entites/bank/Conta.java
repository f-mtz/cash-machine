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
	private double limitSaque;
	SimpleDateFormat date;
	

	public Conta(int accountNumber, Client cliente, double saldo, double limitSaque) {
		this.accountNumber = accountNumber;
		this.cliente = cliente;
		this.saldo = saldo;
		this.limitSaque = limitSaque;
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
	public void saque(double x) {
		
		if(x >= saldo && x < (saldo + limitSaque) && qtdSaques<4) {
			qtdSaques++;
			System.out.println("voc� negativou sua conta em " + (saldo - x));
			this.saldo -= x;
		}
		else if(x >= saldo && x < (saldo + limitSaque) && qtdSaques> 3) {
			qtdSaques++;
			System.out.println("voc� sacou: " + (x) + " reais");
			this.saldo -= (x + 5);
			}
		else if (x == 0) {
			System.out.println("N�o houve saque na sua conta");
		}
		else if(x > (saldo+limitSaque)) {
			System.out.println("voc� n�o pode sacar o valor: " + x);
		}
		else if(x <= saldo && qtdSaques <= 3) {
			qtdSaques++;
			System.out.println("voc� sacou: " + (x) + " reais");
			this.saldo -= (x);
			}
		else if(x < saldo && qtdSaques >= 4) {
			qtdSaques++;
			System.out.println("voc� sacou: " + (x) + " reais");
			this.saldo -= (x + 5);
			}
		else {
			qtdSaques++;
			this.saldo -= (x + 5);
		}
	}
	
	
	/**DEPOSITO*/
	public double deposito(double y) {
		if(y > 1000) {
			System.out.println("voc� n�o pode depositar mais que 1000 reais por dia !!!");
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
		return "N�mero da conta: " + accountNumber + "\n"+
				"O saldo atual da conta �: " + saldo + "\n" +
				"Quantidade de saques: " + qtdSaques +"\n" +
				"Quantidade de dep�sitos: " + qtdDepositos +"\n" +
				"Quantidade de transfer�ncias: " + qtdTransferencias +"\n"
			;
	}
}
