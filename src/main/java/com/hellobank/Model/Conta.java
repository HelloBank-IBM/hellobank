package com.hellobank.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Integer codigo;

   @ManyToOne
   @JoinColumn(name = "tipo_conta")
    private TipoConta tipo;

   @Column(name = "saldo")
    private Float saldo;

   @ManyToOne
   @JoinColumn(name = "cliente")
    private Cliente cliente;
   
}



