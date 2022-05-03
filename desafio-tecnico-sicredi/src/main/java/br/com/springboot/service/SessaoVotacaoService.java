package br.com.springboot.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.Repository.PautaRepository;
import br.com.springboot.Repository.SessaoVotacaoRepository;
import br.com.springboot.domain.Pauta;
import br.com.springboot.domain.SessaoVotacao;
import br.com.springboot.domain.enums.IndicadorSessaoAberta;
import br.com.springboot.service.dto.SessaoVotacaoDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SessaoVotacaoService {
	@Autowired
	private PautaRepository pautaRepository;
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	
	public void abrirSessaoVotacao(SessaoVotacaoDTO sessaoVotacaoDTO) {
		Optional<Pauta> pauta = pautaRepository.findById(sessaoVotacaoDTO.getIdPauta());
		
		if(pauta.isEmpty()) {
			throw new EntityNotFoundException("Pauta com id " + sessaoVotacaoDTO.getIdPauta() + " não existe na base de dados!");
		}
		
		SessaoVotacao sessaoAberta = SessaoVotacao.builder()
			.pauta(pauta.get())
			.indicadorSessaoAberta(IndicadorSessaoAberta.S.getValor())
		.build();
		
		sessaoVotacaoRepository.save(sessaoAberta);
	}

}
