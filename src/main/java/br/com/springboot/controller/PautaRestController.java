package br.com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.service.PautaService;
import br.com.springboot.service.dto.PautaDTO;

@RestController
@RequestMapping("/pauta")
public class PautaRestController {
	@Autowired
	private PautaService pautaService;

	@GetMapping("/buscarTodas")
	public ResponseEntity<List<PautaDTO>> buscarTodasPautas() {
		return ResponseEntity.ok(pautaService.buscarTodas());
	}
	
	@PostMapping("/criar")
	public ResponseEntity<PautaDTO> criarPauta(@RequestBody PautaDTO pautaDTO) {
		return ResponseEntity.ok(pautaService.criarPauta(pautaDTO));
	}
}
