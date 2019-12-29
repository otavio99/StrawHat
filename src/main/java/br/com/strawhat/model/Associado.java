package br.com.strawhat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "associado")
public class Associado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String cpf;
	private String rg;
	private String endereco;
	private String telefone;
	private String dataDeNascimento;
	
	@OneToMany(mappedBy = "associado", cascade = CascadeType.ALL)
	private List<Entidade> paisDeCabeca = new ArrayList<Entidade>();
	
	@OneToMany(mappedBy = "associado", cascade = CascadeType.ALL)
	private List<Mensalidade> mensalidades = new ArrayList<>();
	
	@OneToMany(mappedBy = "associado", cascade = CascadeType.ALL)
	private List<Evento> eventos = new ArrayList<Evento>();
	
	public Associado() {}

	public Associado(long id, String name, String cpf, String rg, String endereco, String telefone,
			String dataDeNascimento) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataDeNascimento = dataDeNascimento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public List<Entidade> getPaisDeCabeca() {
		return paisDeCabeca;
	}

	public void setPaisDeCabeca(List<Entidade> paisDeCabeca) {
		this.paisDeCabeca = paisDeCabeca;
	}

	public List<Mensalidade> getMensalidades() {
		return mensalidades;
	}

	public void setMensalidades(List<Mensalidade> mensalidades) {
		this.mensalidades = mensalidades;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
}
