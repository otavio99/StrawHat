package br.com.strawhat.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.strawhat.model.Mensalidade;

public class MensalidadeDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	private Double valor;
	
	public MensalidadeDTO() {}
	
	public MensalidadeDTO(Mensalidade obj) {
		id = obj.getId();
		data = obj.getData();
		valor = obj.getValor();
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
