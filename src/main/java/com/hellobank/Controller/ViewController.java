package com.hellobank.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hellobank.DAO.TipoContaDAO;
import com.hellobank.DAO.TransacaoDAO;
import com.hellobank.Model.Cliente;
import com.hellobank.Model.Conta;
import com.hellobank.Model.TipoConta;
import com.hellobank.Service.ClienteServicesImpl;
import com.hellobank.Service.ContaServiceImpl;

@Controller
@RequestMapping(path = "/hellobank/view")
public class ViewController {

    @Autowired
    private ClienteServicesImpl clienteService;

    @Autowired
    private ContaServiceImpl contaService;

    @Autowired
    private TransacaoDAO transacaoDao;

    @Autowired
    private TipoContaDAO tipoContaDao;

    @GetMapping("/index")
    public String index() {
        return "landing_page";
    }

    @GetMapping("/inicio")
    public String inicio(Cliente cliente, Model model){
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

    @GetMapping("/saldo/{idCliente}")
    public String saldoGet(@PathVariable Integer idCliente, Model model){
        ArrayList<Conta> contas = contaService.buscarPeloIdCliente(idCliente);
        Cliente cliente = clienteService.buscarPeloId(idCliente);
        model.addAttribute("contas", contas);
        model.addAttribute("cliente", cliente);
        return "saldo";
    }

}
