package users;

import java.time.LocalDate;

public class User {

	private int id;
	private String nome;
	private String senha;
	//INTERN
	private LocalDate dataDaVotacao;

	public User(int id, String nome, String senha, LocalDate dataDaVotacao) {
		// TODO Auto-generated constructor stub
		this.id =id;
		this.nome = nome;
		this.senha = senha;
		this.dataDaVotacao = dataDaVotacao;
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

	public LocalDate getDataDaVotacao() {
		return dataDaVotacao;
	}

	public void setDataDaVotacao(LocalDate dataDaVotacao) {
		this.dataDaVotacao = dataDaVotacao;
	}

	public boolean isVotingToday(LocalDate data)
	{	
		if(dataDaVotacao == null){
			return false;
		}
		return data.isEqual(dataDaVotacao);		
	}
	
}
