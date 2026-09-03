package erpEscolar.enums;

public enum Sexo {
	MASCULINO("masculino"),
	FEMININO("feminino");
	
	private String descricao;
	
	private Sexo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
