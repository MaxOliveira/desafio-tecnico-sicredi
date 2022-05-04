package br.com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.Repository.PautaRepository;
import br.com.springboot.domain.Pauta;
import br.com.springboot.service.dto.PautaDTO;
import br.com.springboot.service.mapper.PautaMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PautaService {

	@Autowired
	private PautaRepository pautaRepository;
	private PautaMapper pautaMapper;
	
	public List<PautaDTO> buscarTodas( ) {
		return pautaMapper.entidadesParaDTOs(pautaRepository.findAll());		
	}
	
	public PautaDTO criarPauta(PautaDTO pautaDTO) {
		Pauta pauta = Pauta.builder()
		.descricao(pautaDTO.getDescricao())
		.build();
		
		pautaRepository.save(pauta);
		
		return pautaMapper.entidadeParaDTO(pauta);
	}
	
	
}
