package br.com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.service.SessaoVotacaoService;
import br.com.springboot.service.dto.SessaoVotacaoDTO;

@RestController
@RequestMapping("/sessao-votacao")
public class SessaoVotacaoRestController {
	@Autowired
	SessaoVotacaoService sessaoVotacaoService;
	
	@PostMapping("/abrir")
	public ResponseEntity<SessaoVotacaoDTO> abrirSessaoVotacao(@RequestBody SessaoVotacaoDTO sessaoVotacaoDTO) {
		return ResponseEntity.ok(sessaoVotacaoService.abrirSessaoVotacao(sessaoVotacaoDTO));
	}
	
}
