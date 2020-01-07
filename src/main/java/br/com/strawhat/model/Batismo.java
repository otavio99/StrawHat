package br.com.strawhat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import br.com.strawhat.model.enums.TipoEvento;

@Entity(name = "batismo")
//@PrimaryKeyJoinColumn(name="id")
public class Batismo extends PadrinhosEvento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	@JoinTable(name = "ENTIDADE_BATISMO",
		joinColumns = @JoinColumn(name = "entidade_id"), 
		inverseJoinColumns = @JoinColumn(name = "batismo_id")
	)
	private List<Entidade> padrinhos = new ArrayList<Entidade>();
	
	public Batismo() {}
	
	public Batismo(Integer id, String data, TipoEvento tipo, String padrinho, String madrinha, ArrayList<Entidade> padrinhos) {
		super(id, data, tipo, padrinho, madrinha);
		this.padrinhos = padrinhos;
	}

	public List<Entidade> getPadrinhosEspirituais() {
		return padrinhos;
	}

	public void setPadrinhosEspirituais(List<Entidade> padrinhos) {
		this.padrinhos = padrinhos;
	}

}
