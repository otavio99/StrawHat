package br.com.strawhat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import br.com.strawhat.model.enums.TipoEvento;

@Entity(name = "batismo")
public class Batismo extends PadrinhosEvento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(mappedBy = "padrinhos")
	private List<Entidade> padrinhos = new ArrayList<Entidade>();
	
	public Batismo() {}
	
	public Batismo(long id, String data, TipoEvento idEvento, String padrinho, String madrinha, String padrinhoEspiritual, String madrinhaEspiritual) {
		super(id, data, idEvento, padrinho, madrinha);
	}

	public List<Entidade> getPadrinhosEspirituais() {
		return padrinhos;
	}

	public void setPadrinhosEspirituais(List<Entidade> padrinhos) {
		this.padrinhos = padrinhos;
	}

}
