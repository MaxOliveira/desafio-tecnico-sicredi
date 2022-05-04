package br.com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.service.VotoService;
import br.com.springboot.service.dto.VotoDTO;

@RestController
@RequestMapping("/voto")
public class VotoRestController {
	
	@Autowired
	private VotoService votoService;
	
	@PostMapping("/votar")
	public ResponseEntity<VotoDTO> receberVotos(@RequestBody VotoDTO votoDTO) {
		return ResponseEntity.ok(votoService.votar(votoDTO));
	}
	
	@GetMapping("/contabilizar")
	public Long contabilizarVotos() {
		return votoService.contabilizarVotos();
	}
	
	@GetMapping("/contabilizar/pauta/{idPauta}")
	public Long contabilizarVotosPorPauta(@PathVariable Long idPauta) {
		return votoService.contabilizarVotosPorPauta(idPauta);
	}
	
	@GetMapping("/buscar-todos")
	public ResponseEntity<List<VotoDTO>> buscarTodos() {
		return ResponseEntity.ok(votoService.buscarTodos());
	}
	
	

}
