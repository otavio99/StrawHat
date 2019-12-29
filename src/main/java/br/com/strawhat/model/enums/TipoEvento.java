package br.com.strawhat.model.enums;

public enum TipoEvento {
	TIPO1(1, "Batismo"),
	TIPO2(2, "aaa"),
	TIPO3(3, "aaa");
	
	private long id;
	private String descricao;
	
	private TipoEvento(long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoEvento toEnum(Long id) {
		if(id==null) {
			return null;
		}
		for(TipoEvento x : TipoEvento.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("ID inválido: " + id);
	}
}
