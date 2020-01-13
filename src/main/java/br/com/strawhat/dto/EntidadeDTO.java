package br.com.strawhat.dto;

import br.com.strawhat.model.Entidade;

public class EntidadeDTO {
	private Integer id;
	private String data;
	private String nome;
	
	public EntidadeDTO() {}

	public EntidadeDTO(Entidade obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.data = obj.getData();
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
	
}
