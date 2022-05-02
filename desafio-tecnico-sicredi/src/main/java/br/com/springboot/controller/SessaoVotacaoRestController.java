package br.com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.service.SessaoVotacaoService;
import br.com.springboot.service.dto.SessaoVotacaoDTO;

@RestController
@RequestMapping("/sessao-votacao")
public class SessaoVotacaoRestController {
	@Autowired
	SessaoVotacaoService sessaoVotacaoService;
	
	@PostMapping("/abrir/{tempoSessao}/pauta/{idPauta}")
	public ResponseEntity<SessaoVotacaoDTO> abrirSessaoVotacao(@PathVariable Long tempoSessao,
																@PathVariable Long idPauta) {
		sessaoVotacaoService.abrirSessaoVotacao(tempoSessao, idPauta);
		return ResponseEntity.ok().build();
	}
	
}
