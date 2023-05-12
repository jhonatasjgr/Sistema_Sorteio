package utils;

public class Rifa {

	private int id;
	Pessoa comprador;
	
	public Rifa(int id, Pessoa pessoa) {
		this.setId(id);
		this.setComprador(pessoa);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pessoa getComprador() {
		return comprador;
	}
	public void setComprador(Pessoa comprador) {
		this.comprador = comprador;
	}
	
	
}
