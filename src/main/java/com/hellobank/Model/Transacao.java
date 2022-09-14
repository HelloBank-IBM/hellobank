package com.hellobank.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id_transacao;
	
	@Column
	private Integer conta_origem;
	
	@Column
	private Integer conta_destino;
	
	@Column
	private Date data;
	
	@Column
	private float valor;

	public Integer getId_transacao() {
		return id_transacao;
	}

	public void setId_transacao(Integer id_transacao) {
		this.id_transacao = id_transacao;
	}

	public Integer getConta_origem() {
		return conta_origem;
	}

	public void setConta_origem(Integer conta_origem) {
		this.conta_origem = conta_origem;
	}

	public Integer getConta_destino() {
		return conta_destino;
	}

	public void setConta_destino(Integer conta_destino) {
		this.conta_destino = conta_destino;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
