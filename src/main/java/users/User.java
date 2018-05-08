package users;

import java.time.LocalDate;

public class User {

	private int id;
	private String nome;
	private String senha;
	private boolean votouHoje;
	//INTERN
	private LocalDate dataDaVotacao;

	public User(int id, String nome, String senha, boolean votouHoje) {
		// TODO Auto-generated constructor stub
		this.id =id;
		this.nome = nome;
		this.senha = senha;
		this.votouHoje = votouHoje;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isVotouHoje() {
		return votouHoje;
	}

	public void setVotouHoje(boolean votouHoje) {
		this.votouHoje = votouHoje;
	}

	public LocalDate getDataDaVotacao() {
		return dataDaVotacao;
	}

	public void setDataDaVotacao(LocalDate dataDaVotacao) {
		this.dataDaVotacao = dataDaVotacao;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", senha=" + senha + ", votouHoje=" + votouHoje
				+ ", dataDaVotacao=" + dataDaVotacao + "]";
	}

	
}
