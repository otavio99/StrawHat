package br.com.strawhat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.strawhat.model.enums.TipoEvento;

@Entity(name = "batismo")
public class Batismo extends PadrinhosEvento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "batismo", cascade = CascadeType.ALL)
	private List<Entidade> padrinhosEspirituais = new ArrayList<Entidade>();
	
	public Batismo() {}
	
	public Batismo(long id, String data, TipoEvento idEvento, String padrinho, String madrinha, String padrinhoEspiritual, String madrinhaEspiritual) {
		super(id, data, idEvento, padrinho, madrinha);
	}

	public List<Entidade> getPadrinhosEspirituais() {
		return padrinhosEspirituais;
	}

	public void setPadrinhosEspirituais(List<Entidade> padrinhosEspirituais) {
		this.padrinhosEspirituais = padrinhosEspirituais;
	}

}
