package br.com.springboot.controller;

import javax.naming.NoPermissionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.service.AssociadoService;
import br.com.springboot.service.dto.AssociadoDTO;

@RestController
@RequestMapping("/associado")
public class AssociadoRestController {
	@Autowired
	private AssociadoService associadoService;
	
	@PostMapping("/criar")
	public ResponseEntity<AssociadoDTO> cadastrarAssociado(@RequestBody AssociadoDTO associadoDTO) throws NoPermissionException {
		associadoService.cadastrarNovoAssociado(associadoDTO);
		return ResponseEntity.ok().build();
	}
	

}
