package br.com.strawhat.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.strawhat.model.Entidade;

public class EntidadeDTO {
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
