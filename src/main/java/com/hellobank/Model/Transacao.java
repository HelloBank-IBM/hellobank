package com.hellobank.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_transacao")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="conta_origem")
	private Conta contaOrigem;
	
	@ManyToOne
	@JoinColumn(name="conta_destino")
	private Conta contaDestino;
	
	@Column(name="data")
	private LocalDate data;
	
	@Column(name="valor")
	private float valor;

	@ManyToOne
	@JoinColumn(name="tipo_transacao")
	private TipoTransacao tipoTransacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
