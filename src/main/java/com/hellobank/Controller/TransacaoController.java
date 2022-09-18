package com.hellobank.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hellobank.Model.Transacao;
import com.hellobank.Service.ITransacaoService;

@RestController
public class TransacaoController {

	@Autowired
	private ITransacaoService service;

	@GetMapping("/transacao/{numero}")
	public ArrayList<Transacao> buscar(@PathVariable Integer numero) {
		ArrayList<Transacao> tr = service.extrato(numero);
		return tr;
	}

	@GetMapping("/transacao")
	public ArrayList<Transacao> listar() {
		return (ArrayList<Transacao>) service.listar();

	}

	@PostMapping("/transacao")
	public ResponseEntity<Transacao> novo(@RequestBody Transacao novo) {
		Transacao tr = service.salvar(novo);
		if (tr != null) {
			return ResponseEntity.ok(tr);
		}

		return ResponseEntity.badRequest().build();
	}
}