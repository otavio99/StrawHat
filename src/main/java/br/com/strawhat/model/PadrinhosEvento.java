package br.com.strawhat.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name = "padrinhos_evento")
public class PadrinhosEvento extends Evento implements Serializable{
	private static final long serialVersionUID = 1L;

	private String padrinho;
	private String madrinha;
	
	public PadrinhosEvento() {}
	
	public PadrinhosEvento(long id, String data, long idEvento, String padrinho, String madrinha) {
		super(id, data, idEvento);
		this.padrinho = padrinho;
		this.madrinha = madrinha;
	}
	
	public PadrinhosEvento(String padrinho, String madrinha) {
		super();
		this.padrinho = padrinho;
		this.madrinha = madrinha;
	}

	public String getPadrinho() {
		return padrinho;
	}

	public void setPadrinho(String padrinho) {
		this.padrinho = padrinho;
	}

	public String getMadrinha() {
		return madrinha;
	}

	public void setMadrinha(String madrinha) {
		this.madrinha = madrinha;
	}
	
}
