package com.hellobank.Service;

import java.util.ArrayList;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellobank.DAO.ContaDAO;
import com.hellobank.DAO.TipoTransacaoDAO;
import com.hellobank.DAO.TransacaoDAO;
import com.hellobank.Model.Cliente;
import com.hellobank.Model.Conta;
import com.hellobank.Model.TipoConta;

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
    public Conta depositar(Conta conta, float valor) {
        if (conta.getId() != null && conta.getCliente() != null && conta.getNumeroConta() != null
                && conta.getTipo() != null) {
            conta.setSaldo(conta.getSaldo() + valor);

            return dao.save(conta);
        }
        return null;
    }

    @Override
    public Conta transferencia(Conta contaOrigem, float valor, Conta contaDestino) {
        var chequeEspecial = 200f;
        if (contaOrigem.getId() != null && contaOrigem.getCliente() != null && contaOrigem.getNumeroConta() != null
                && contaOrigem.getTipo() != null) {
            if (contaOrigem.getSaldo() >= 0) {
                contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
                contaDestino.setSaldo(contaDestino.getSaldo() + valor);
                dao.save(contaDestino);
                return dao.save(contaOrigem);
            } else if (contaOrigem.getSaldo() + chequeEspecial >= valor && contaOrigem.getTipo().getCodigo() == 1) {
                contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
                contaDestino.setSaldo(contaDestino.getSaldo() + valor);
                dao.save(contaDestino);
                return dao.save(contaOrigem);
            }
        }
        return null;
    }

    @Override
    public boolean contaExiste(Cliente cliente, TipoConta tipoConta) {
        Integer idCliente = cliente.getId();
        Integer idTipoConta = tipoConta.getCodigo();
        Conta contaExiste = dao.encontrarPorClienteETipoConta(idCliente, idTipoConta);

        if (contaExiste != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Conta sacar(Conta conta, Float valor) {
        Float novoSaldo = conta.getSaldo() - valor;
        if (novoSaldo < 0) {
            if (conta.getTipo().getCodigo() != 1) {
                return null;
            } else if (novoSaldo < (-200f)) {
                return null;
            }
        }
        conta.setSaldo(novoSaldo);
        return dao.save(conta);
    }
}
