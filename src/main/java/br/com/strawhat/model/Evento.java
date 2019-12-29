package br.com.strawhat.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.strawhat.model.enums.TipoEvento;

@Entity(name = "evento")
public class Evento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String data;
	private long tipo;
	
	@ManyToOne
	@JoinColumn(name = "associado_id")
	private Associado associado;
	
	public Evento() {}

	public Evento(long id, String data,  TipoEvento idEvento) {
		this.id = id;
		this.data = data;
		this.tipo = idEvento.getId();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public long getIdEvento() {
		return tipo;
	}

	public void setIdEvento(long idEvento) {
		this.tipo = idEvento;
	}
	
}
