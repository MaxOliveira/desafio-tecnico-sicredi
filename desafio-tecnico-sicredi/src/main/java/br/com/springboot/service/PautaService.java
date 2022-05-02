package br.com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.Repository.PautaRepository;
import br.com.springboot.domain.Pauta;
import br.com.springboot.service.dto.PautaDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PautaService {

	@Autowired
	private PautaRepository pautaRepository;
	
	public List<Pauta> buscarPautas( ) {
		return pautaRepository.findAll();		
	}
	
	public Pauta criarPauta(PautaDTO pautaDTO) {
		Pauta pauta = Pauta.builder()
		.descricao(pautaDTO.getDescricao())
		.build();
		
		pautaRepository.save(pauta);
		
		return pauta;
	}
	
	
}
