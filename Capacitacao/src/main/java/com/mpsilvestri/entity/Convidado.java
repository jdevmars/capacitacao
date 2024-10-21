package com.mpsilvestri.entity;

public class Convidado {
	
	private String email;
	private String nome;
	private String observacao;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@Override
	public String toString() {
		return "Convidado [email=" + email + ", nome=" + nome + ", observacao=" + observacao + "]";
	}
	
}
