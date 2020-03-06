package entites.bank;

public class Client {
	
	private String holderName;
	private int cpf;
	
	public Client() {
		
	}

	public Client(String holderName, int cpf) {
		super();
		this.holderName = holderName;
		this.cpf = cpf;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String toString() {
		return "titular: " + holderName + "\n" +
				"cpf: " 	+ cpf;
	} 
}
