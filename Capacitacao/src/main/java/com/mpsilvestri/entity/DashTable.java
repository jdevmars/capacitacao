package com.mpsilvestri.entity;

import java.sql.Date;

public class DashTable {
	
	private String nome;
	private String email;
	private String empresa;
	private String curso;
	private Date data;
	private String status;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "DashTable [nome=" + nome + ", email=" + email + ", empresa=" + empresa + ", curso=" + curso + ", data="
				+ data + ", status=" + status + "]";
	}

}
