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
	
	private Entidade paiDeCabeca;
	private Entidade maeDeCabeca;
	
	@OneToMany(mappedBy = "associado", cascade = CascadeType.ALL)
	private List<Mensalidade> mensalidades = new ArrayList<>();
	
	public Associado() {}

	public Associado(long id, String name, String cpf, String rg, String endereco, String telefone,
			String dataDeNascimento, Entidade paiDeCabeca, Entidade maeDeCabeca) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataDeNascimento = dataDeNascimento;
		this.paiDeCabeca = paiDeCabeca;
		this.maeDeCabeca = maeDeCabeca;
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

	public Entidade getPaiDeCabeca() {
		return paiDeCabeca;
	}

	public void setPaiDeCabeca(Entidade paiDeCabeca) {
		this.paiDeCabeca = paiDeCabeca;
	}

	public Entidade getMaeDeCabeca() {
		return maeDeCabeca;
	}

	public void setMaeDeCabeca(Entidade maeDeCabeca) {
		this.maeDeCabeca = maeDeCabeca;
	}
	
}
