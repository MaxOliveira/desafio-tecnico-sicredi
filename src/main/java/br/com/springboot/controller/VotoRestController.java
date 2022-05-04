package br.com.springboot.controller;

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
	public ResponseEntity<VotoDTO> votar(@RequestBody VotoDTO votoDTO) {
		votoService.votar(votoDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/contabilizar")
	public Long contabilizarVotos() {
		return votoService.contabilizarVotos();
	}
	
	@GetMapping("/contabilizar/pauta/{idPauta}")
	public Long contabilizarVotosPorPauta(@PathVariable Long idPauta) {
		return votoService.contabilizarVotosPorPauta(idPauta);
	}
	
	

}
