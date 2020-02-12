package br.com.strawhat.dto;

import java.io.Serializable;

import br.com.strawhat.model.Evento;

public class EventoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String data;
	
	public EventoDTO() {}

	public EventoDTO(Evento obj) {
		id = obj.getId();
		data = obj.getData();
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
}
