package br.com.strawhat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.strawhat.model.enums.TipoEvento;

@Entity(name = "padrinhosEvento")
//@PrimaryKeyJoinColumn(name="id")
@JsonTypeName("padrinhosEvento")
public class PadrinhosEvento extends Evento implements Serializable{
	private static final long serialVersionUID = 1L;

	private String padrinho;
	private String madrinha;
	
	public PadrinhosEvento() {}
	
	public PadrinhosEvento(Integer id, Date data, TipoEvento idEvento, String padrinho, String madrinha) {
		super(id, data, idEvento);
		this.padrinho = padrinho;
		this.madrinha = madrinha;
	}
	
	public PadrinhosEvento(String padrinho, String madrinha) {
		super();
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
