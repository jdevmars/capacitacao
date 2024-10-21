package com.mpsilvestri.entity;

import java.sql.Date;

public class Treinamento {
	
	private int id;
	private Date data;
	private String status;
	private String observacao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@Override
	public String toString() {
		return "Treinamento [id=" + id + ", data=" + data + ", status=" + status + ", observacao=" + observacao + "]";
	}
	
}
