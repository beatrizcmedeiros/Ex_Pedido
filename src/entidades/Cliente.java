package entidades;

import java.util.Date;

public class Cliente {
	private String nome;
	private String email;
	private Date data_aniversario;
	
	public Cliente() {
	}

	public Cliente(String nome, String email, Date data_aniversario) {
		this.nome = nome;
		this.email = email;
		this.data_aniversario = data_aniversario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData_aniversario() {
		return data_aniversario;
	}

	public void setData_aniversario(Date data_aniversario) {
		this.data_aniversario = data_aniversario;
	}	
}//class Cliente
