package com.hellobank.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hellobank.DAO.TipoContaDAO;
import com.hellobank.Model.Cliente;
import com.hellobank.Model.Conta;
import com.hellobank.Model.TipoConta;
import com.hellobank.Model.Transacao;
import com.hellobank.Service.ClienteServicesImpl;
import com.hellobank.Service.ContaServiceImpl;
import com.hellobank.Service.TransacaoServiceImpl;

@Controller
@RequestMapping(path = "/hellobank/view")
public class ViewController {

    @Autowired
    private ClienteServicesImpl clienteService;

    @Autowired
    private ContaServiceImpl contaService;

    @Autowired
    private TipoContaDAO tipoContaDao;

    @Autowired
    private TransacaoServiceImpl transacaoService;

    /* Landing Page */
    @GetMapping("/index")
    public String index() {
        return "landing_page";
    }

    /* Tela inicial da Aplicação */
    @GetMapping("/inicio/{idCliente}")
    public String inicio(@PathVariable Integer idCliente, Model model){
        Cliente cliente = clienteService.buscarPeloId(idCliente);
        model.addAttribute("cliente", cliente);
        return "inicio";
    }

    /* Login no sistema */
    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("login", new Cliente());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String cpfCnpj, @RequestParam String senha, Model model){
        System.out.println("CPF: " + cpfCnpj + "  |  senha: " + senha);
        Cliente cliente = clienteService.buscarPeloCpf(cpfCnpj);
        System.out.println("Registro: \n CPF : " + cpfCnpj + " | Senha: " + senha);
        if ((cliente != null) && (cliente.getSenha().equals(senha))){
            model.addAttribute("cliente", cliente);
            return "inicio";
        } else {
        model.addAttribute("login", new Cliente());
        return "login";
        }
    }

    /* Cadastro de Novo Cliente - Redireciona para o formulário */
    @GetMapping("/cadastro")
    public String formCadastroGet(Model model) {
        Cliente novoCliente = new Cliente();
        model.addAttribute("novoCliente", novoCliente);
        return "form_cadastro";
    }

    /* CRUD - CREATE Cliente */
    @PostMapping("/cadastro")
    public String formCadastroPost(Model model, Cliente novoCliente) {

        // Salvando novo Cliente no banco de dados 
        clienteService.salvar(novoCliente);
        Cliente cliente = clienteService.buscarPeloId(novoCliente.getId());

        //Criando nova conta
        Conta novaConta = new Conta();
        //Setando o cliente
        novaConta.setCliente(cliente);
        //Setando o tipo de conta como conta corrente
        TipoConta tipo = tipoContaDao.encontrarPorId(1);
        novaConta.setTipo(tipo);
        //Setando o número da conta
        Integer numeroConta = contaService.criarNumeroConta(novaConta);
        novaConta.setNumeroConta(numeroConta);
        // Inserindo saldo obrigatorio no registro de conta
        Float saldoInicial = 500f;
        novaConta.setSaldo(saldoInicial);
        // Salvando a conta no banco de dados
        contaService.criarConta(novaConta);
        Conta conta = contaService.buscarPeloId(novaConta.getId());

        if ((cliente != null) && (conta != null)) {
            
            //Caso ambos os registros sejam efetuados, 
            //redireciona para página de login
            return "redirect:/hellobank/view/login";
        } 
        return "form_cadastro";
    }

    /* Funcionalidades da Aplicação */

    /* Saldo */
    @GetMapping("/saldo/{idCliente}")
    public String saldo(@PathVariable Integer idCliente, Model model){
        ArrayList<Conta> contas = contaService.buscarPeloIdCliente(idCliente);
        Cliente cliente = clienteService.buscarPeloId(idCliente);
        model.addAttribute("contas", contas);
        model.addAttribute("cliente", cliente);
        return "saldo";
    }

    /* Extrato - verbo http GET */
    @GetMapping("/extrato/{numeroConta}")
    public String extratoGet(@PathVariable Integer numeroConta, Model model){
        Conta conta = contaService.buscarPeloNumero(numeroConta);
        Cliente cliente = conta.getCliente();
        ArrayList<Transacao> transacoes = transacaoService.extrato(conta.getId());
        ArrayList<Conta> contas = contaService.buscarPeloIdCliente(cliente.getId());
        Conta formConta = new Conta();

        model.addAttribute("transacoes", transacoes);
        model.addAttribute("cliente", cliente);
        model.addAttribute("conta", conta);
        model.addAttribute("contas", contas);
        model.addAttribute("formConta", formConta);
        return "extrato";
    }

    @GetMapping("/extrato/cliente/{idCliente}")
    public String extrato(@PathVariable Integer idCliente, Model model){
        Cliente cliente = clienteService.buscarPeloId(idCliente);
        ArrayList<Conta> contas = contaService.buscarPeloIdCliente(idCliente);
        Integer numeroConta = 0;
        for (Conta c : contas){
            if (c.getTipo().getCodigo() == 1){
                numeroConta = c.getNumeroConta();
            };
        }
        Conta conta = contaService.buscarPeloNumero(numeroConta);

        ArrayList<Transacao> transacoes = transacaoService.extrato(conta.getId());
        Conta formConta = new Conta();

        model.addAttribute("transacoes", transacoes);
        model.addAttribute("cliente", cliente);
        model.addAttribute("conta", conta);
        model.addAttribute("contas", contas);
        model.addAttribute("formConta", formConta);
        return "extrato";
    }



    /* Extrato - verbo http POST */
    @PostMapping("/extrato")
    public String extratoPost(Conta formConta, Model model){
        Conta conta = contaService.buscarPeloNumero(formConta.getNumeroConta());
        Cliente cliente = conta.getCliente();
        ArrayList<Transacao> transacoes = transacaoService.extrato(conta.getId());
        ArrayList<Conta> contas = contaService.buscarPeloIdCliente(cliente.getId());
        formConta = new Conta();
        model.addAttribute("transacoes", transacoes);
        model.addAttribute("cliente", cliente);
        model.addAttribute("conta", conta);
        model.addAttribute("contas", contas);
        model.addAttribute("formConta", formConta);
        return "extrato";
    }

    /* Extrato - POST */
}
