package br.com.strawhat.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.strawhat.model.enums.TipoEvento;

@Entity(name = "evento")
@Inheritance(strategy = InheritanceType.JOINED)
public class Evento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String data;
	
	@JsonIgnore
	private Integer tipo;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "associado_id")
	private Associado associado;
	
	public Evento() {}

	public Evento(Integer id, String data,  TipoEvento tipo) {
		this.id = id;
		this.data = data;
		this.tipo = tipo.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public TipoEvento getTipo() {
		return TipoEvento.toEnum(tipo);
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo.getId();
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	
}
