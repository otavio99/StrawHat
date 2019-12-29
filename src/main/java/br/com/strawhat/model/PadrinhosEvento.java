package br.com.strawhat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.strawhat.model.enums.TipoEvento;

@Entity(name = "padrinhos_evento")
public class PadrinhosEvento extends Evento implements Serializable{
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "associado", cascade = CascadeType.ALL)
	private List<Associado> padrinhos = new ArrayList<Associado>();
	
	public PadrinhosEvento() {}
	
	public PadrinhosEvento(long id, String data, TipoEvento idEvento, String padrinho, String madrinha) {
		super(id, data, idEvento);
	}
	
	public PadrinhosEvento(String padrinho, String madrinha) {
		super();
	}

	public List<Associado> getPadrinhos() {
		return padrinhos;
	}

	public void setPadrinhos(List<Associado> padrinhos) {
		this.padrinhos = padrinhos;
	}
	
}
