package entites.bank;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Conta{
	
	private int accountNumber;
	private Client cliente = new Client(null, 0);
	private double saldo;
	public Conta conta;
	private int qtdSaques;
	private int qtdDepositos;
	private int qtdTransferencias;
	private double limitSaque;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	

	public Conta getConta() {
		return conta;
	}

	public int getQtdSaques() {
		return qtdSaques;
	}

	public int getQtdDepositos() {
		return qtdDepositos;
	}

	public int getQtdTransferencias() {
		return qtdTransferencias;
	}

	public double getLimitSaque() {
		return limitSaque;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public Date getDate(int year, int month) {
		return date;
	}
	public Conta(int numeroDaConta, Client cliente, double saldo, double limitSaque) {
		this.accountNumber = numeroDaConta;
		this.cliente = cliente;
		this.saldo = saldo;
		this.limitSaque = limitSaque;
		}

	public int getAccountNumber() {
		return accountNumber;
	}

	public Client getCliente() {
		return cliente;
	}

	public double getSaldo() {
		return saldo;
	}
	/**SAQUE*/
	public void saque(double x) {
		if(x >= saldo && x < (saldo + limitSaque) && qtdSaques<4) {
			qtdSaques++;
			System.out.println("você negativou sua conta em " + (saldo - x));
			this.saldo -= x;
		}
		else if(x >= saldo && x < (saldo + limitSaque) && qtdSaques> 3) {
			qtdSaques++;
			System.out.println("você sacou: " + (x) + " reais");
			this.saldo -= (x + 5);
			}
		else if (x == 0) {
			System.out.println("Não houve saque na sua conta");
		}
		else if(x > (saldo+limitSaque)) {
			System.out.println("você não pode sacar o valor: " + x);
		}
		else if(x <= saldo && qtdSaques <= 3) {
			qtdSaques++;
			System.out.println("você sacou: " + (x) + " reais");
			this.saldo -= (x);
			}
		else if(x < saldo && qtdSaques >= 4) {
			qtdSaques++;
			System.out.println("você sacou: " + (x) + " reais");
			this.saldo -= (x + 5);
			}
		else {
			qtdSaques++;
			this.saldo -= (x + 5);
		}
	}
	
	/**SAQUE*/
	public void saqueT(double x) {
		if(x >= saldo && x < (saldo + limitSaque) && qtdTransferencias<4) {
			qtdTransferencias++;
			System.out.println("você negativou sua conta em " + (saldo - x));
			this.saldo -= x;
		}
		else if(x >= saldo && x < (saldo + limitSaque) && qtdTransferencias> 3) {
			qtdTransferencias++;
			System.out.println("você transferiu: " + (x) + " reais");
			this.saldo -= (x + 5);
			}
		else if (x == 0) {
			System.out.println("Não houve saldo transferido: ");
		}
		else if(x > (saldo+limitSaque)) {
			System.out.println("você não pode transferir o valor: " + x);
		}
		else if(x <= saldo && qtdTransferencias <= 3) {
			qtdTransferencias++;
			System.out.println("você transferiu: " + (x) + " reais");
			this.saldo -= (x);
			}
		else if(x < saldo && qtdTransferencias >= 4) {
			qtdTransferencias++;
			System.out.println("você transferiu: " + (x) + " reais");
			this.saldo -= (x + 5);
			}
		else {
			qtdTransferencias++;
			this.saldo -= (x + 5);
		}
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
		this.saqueT(valor);
		receptora.deposito(valor);
	
	}
		
		public String csvPrinter() {
			return  ""+
					cliente.getHolderName() +"; " +
					cliente.getCpf()+ "; " +
					date+"; " +
					accountNumber + "; "+
					saldo + "; " +
					qtdSaques +"; " +
					qtdDepositos +"; " +
					qtdTransferencias
					;
		}

	public String toString() {
		return 	"Cliente: "+ cliente.getHolderName() +"\n" +
				"CPF: "+cliente.getCpf()+ "\n" +
				"Data & Hora da trasação: "+date+"\n" +
				"Número da conta: " + accountNumber + "\n"+
				"O saldo atual da conta é: " + saldo + "\n\n" +
				
				"Quantidade de saques: " + qtdSaques +"\n" +
				"Quantidade de depósitos: " + qtdDepositos +"\n" +
				"Quantidade de transferências: " + qtdTransferencias +"\n"+
				"--------------------"
				;
	}
}
