package br.com.strawhat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "entidade")
public class Entidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String data;
	private String nome;
	
	@ManyToMany(mappedBy = "entidades")
	private List<Associado> afilhados = new ArrayList<Associado>();
	
	@ManyToMany
	@JoinTable(name = "ENTIDADE_BATISMO",
		joinColumns = @JoinColumn(name = "entidade_id"), 
		inverseJoinColumns = @JoinColumn(name = "batismo_id")
	)
	private List<Batismo> batismos = new ArrayList<Batismo>();
	
	public Entidade(){}
	
	public Entidade(long id, String data, String nome) {
		super();
		this.id = id;
		this.data = data;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Associado> getAfilhados() {
		return afilhados;
	}

	public void setAfilhados(List<Associado> afilhados) {
		this.afilhados = afilhados;
	}
	
}
