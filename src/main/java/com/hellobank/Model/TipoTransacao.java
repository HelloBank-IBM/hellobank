package com.hellobank.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoTransacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_transacao")
	private Integer id_tipo_transacao;
	
	@Column(name = "nome_tipo_transacao", length = 50, nullable = false)
	private String nome_tipo_transacao;

	public Integer getId_tipo_transacao() {
		return id_tipo_transacao;
	}

	public void setId_tipo_transacao(Integer id_tipo_transacao) {
		this.id_tipo_transacao = id_tipo_transacao;
	}

	public String getNome_tipo_transacao() {
		return nome_tipo_transacao;
	}

	public void setNome_tipo_transacao(String nome_tipo_transacao) {
		this.nome_tipo_transacao = nome_tipo_transacao;
	}
}
