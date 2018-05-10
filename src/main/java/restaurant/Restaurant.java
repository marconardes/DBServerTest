package restaurant;

import java.time.LocalDate;

public class Restaurant {
	private int id;
	private String nome;
	private LocalDate liberado;
	
	
	public Restaurant(int id, String nome) {

		this.id = id;
		this.nome = nome;
		this.liberado = LocalDate.now();
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
	public LocalDate getLiberado() {
		return liberado;
	}
	public void setLiberado(LocalDate liberado) {
		this.liberado = liberado;
	}
	
	
	
	

}
