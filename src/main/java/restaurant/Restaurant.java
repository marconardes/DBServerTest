package restaurant;

import java.time.LocalDate;

public class Restaurant {
	private int id;
	private String nome;
	private LocalDate liberado;
	
	
	public Restaurant(int id, String nome) {

		this.id = id;
		this.nome = nome;
		this.liberado = null;
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
	
	public boolean verificaBloqueio(LocalDate ld)
	{
	
		if(liberado==null)
		{
			return true;
		}
		return ld.isAfter(liberado)||ld.isEqual(liberado);
	}
	
	

}
