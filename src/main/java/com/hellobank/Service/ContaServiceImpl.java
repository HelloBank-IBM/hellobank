package com.hellobank.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellobank.DAO.ContaDAO;
import com.hellobank.DAO.TipoTransacaoDAO;
import com.hellobank.DAO.TransacaoDAO;
import com.hellobank.Model.Conta;
import com.hellobank.Model.TipoTransacao;
import com.hellobank.Model.Transacao;

@Service
public class ContaServiceImpl implements IContaService {

    @Autowired
    private ContaDAO dao;
    @Autowired
    private TransacaoDAO transacaoDao;
    @Autowired
    private TipoTransacaoDAO tipoTransacaoDao;
    @Override
    @Transactional
    public Conta criarConta(Conta conta) {
        if (conta.getCliente() != null && conta.getTipo() != null) {
            dao.save(conta);
        }
        return null;
    }

    @Override
    public ArrayList<Conta> buscarContas() {
        ArrayList<Conta> lista;
        lista = (ArrayList<Conta>) dao.findAll();
        
        return lista;
    }

    @Override
    public Conta buscarPeloNumero(Integer numero) {
        return dao.buscarNum(numero);
    }

    @Override
    public Conta buscarPeloId(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void excluirConta(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public Integer criarNumeroConta(Conta conta) {
        Integer numeroBanco = 71;
        // instância um objeto da classe Random usando o construtor padrão
        Random gerador = new Random();
        int[] num = new int[4];
        for (int i = 0; i < num.length; i++) {
            int numero = gerador.nextInt(9);
            num[i] = numero;
        }
        String numero = "";
        for (int i = 0; i < num.length; i++) {
            numero = numero + String.valueOf(num[i]);
        }
        numero = String.valueOf(numeroBanco) + numero + String.valueOf(conta.getTipo().getCodigo());
        Integer numeroConta = Integer.parseInt(numero);
        return numeroConta;
    }

    @Override
    public Conta depositar(Conta conta, float valor,Transacao transacao)  {
        TipoTransacao tipo= new TipoTransacao();
        tipo=tipoTransacaoDao.buscarNum(1);
        transacao.setTipoTransacao(tipo);
        if(conta.getId()!=null && conta.getCliente()!=null && conta.getNumeroConta()!=null && conta.getTipo()!=null){
            conta.setSaldo(conta.getSaldo()+valor);
            transacao.setContaDestino(null);
            transacao.setContaOrigem(conta);
            transacao.setData(LocalDate.now(ZoneId.of("UTC")));
            transacao.setValor(valor);
            transacao.setSaldoDepoisDaTransacao(conta.getSaldo());
            transacaoDao.save(transacao);
            return dao.save(conta);
        }
        return null;
    }

    @Override
    public Conta transferencia(Conta contaOrigem, float valor,Conta contaDestino,Transacao transacao) {
        TipoTransacao tipo= new TipoTransacao();
        tipo=tipoTransacaoDao.buscarNum(3);
        transacao.setTipoTransacao(tipo);
        var chequeEspecial =200f;
            if(contaOrigem.getId()!=null && contaOrigem.getCliente()!=null && contaOrigem.getNumeroConta()!=null && contaOrigem.getTipo()!=null){
                if(contaOrigem.getSaldo()>=0){
                    contaOrigem.setSaldo(contaOrigem.getSaldo()-valor);
                    contaDestino.setSaldo(contaDestino.getSaldo()+valor);
                    transacao.setContaDestino(contaDestino);
                    transacao.setContaOrigem(contaOrigem);
                    transacao.setData(LocalDate.now(ZoneId.of("UTC")));
                    transacao.setValor(valor);
                    transacao.setSaldoDepoisDaTransacao(contaOrigem.getSaldo());
                    transacaoDao.save(transacao);
                    dao.save(contaDestino);
                    return dao.save(contaOrigem);
                }else if (contaOrigem.getSaldo()+chequeEspecial >= valor && contaOrigem.getTipo().getCodigo()==1){
                        contaOrigem.setSaldo(contaOrigem.getSaldo()-valor);
                        contaDestino.setSaldo(contaDestino.getSaldo()+valor);
                        transacao.setContaDestino(contaDestino);
                        transacao.setContaOrigem(contaOrigem);
                        transacao.setData(LocalDate.now(ZoneId.of("UTC")));
                        transacao.setValor(valor);
                        transacao.setSaldoDepoisDaTransacao(contaOrigem.getSaldo());
                        transacaoDao.save(transacao);
                        dao.save(contaDestino);
                        return dao.save(contaOrigem);
                    }
                }
        return null;       
    }

}
