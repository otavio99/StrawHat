package br.com.strawhat.model.enums;

public enum TipoEvento {
	BATISMO(1, "Batismo"),
	ABERTURADEGIRA(2, "Abertura de Gira"),
	CORTE(3, "Corte"),
	SANTO(4, "Santo"),
	TOALHADEOXALA(5, "Toalha de Oxalá");
	
	private Integer id;
	private String descricao;
	
	private TipoEvento(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoEvento toEnum(Integer id) {
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
