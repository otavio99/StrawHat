package br.com.strawhat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "entidade")
public class Entidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String data;
	private String nome;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "paisDeCabeca")
	private List<Associado> afilhados = new ArrayList<Associado>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "padrinhos")
	private List<Batismo> batismos = new ArrayList<Batismo>();
	
	public Entidade(){}
	
	public Entidade(Integer id, String data, String nome) {
		super();
		this.id = id;
		this.data = data;
		this.nome = nome;
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

	public List<Batismo> getBatismos() {
		return batismos;
	}

	public void setBatismos(List<Batismo> batismos) {
		this.batismos = batismos;
	}
	
}
