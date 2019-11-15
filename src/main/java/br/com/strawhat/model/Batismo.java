package br.com.strawhat.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name = "batismo")
public class Batismo extends PadrinhosEvento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String padrinhoEspiritual;
	private String madrinhaEspiritual;
	
	public Batismo() {}
	
	public Batismo(long id, String data, long idEvento, String padrinho, String madrinha, String padrinhoEspiritual, String madrinhaEspiritual) {
		super(id, data, idEvento, padrinho, madrinha);
		this.padrinhoEspiritual = padrinhoEspiritual;
		this.madrinhaEspiritual = madrinhaEspiritual;
	}

	public String getPadrinhoEspiritual() {
		return padrinhoEspiritual;
	}

	public void setPadrinhoEspiritual(String padrinhoEspiritual) {
		this.padrinhoEspiritual = padrinhoEspiritual;
	}

	public String getMadrinhaEspiritual() {
		return madrinhaEspiritual;
	}

	public void setMadrinhaEspiritual(String madrinhaEspiritual) {
		this.madrinhaEspiritual = madrinhaEspiritual;
	}
	
}
