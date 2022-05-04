package br.com.springboot.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.stereotype.Service;

import br.com.springboot.Repository.AssociadoRepository;
import br.com.springboot.Repository.PautaRepository;
import br.com.springboot.Repository.SessaoVotacaoRepository;
import br.com.springboot.Repository.VotoRepository;
import br.com.springboot.domain.Associado;
import br.com.springboot.domain.Pauta;
import br.com.springboot.domain.SessaoVotacao;
import br.com.springboot.domain.Voto;
import br.com.springboot.service.dto.VotoDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VotoService {
	@Autowired
	private VotoRepository votoRepository;
	private AssociadoRepository associadoRepository;
	private PautaRepository pautaRepository;
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	
	public void votar(VotoDTO votoDTO) {
		
		Optional<SessaoVotacao> sessaoVotacaoAberta = Optional.ofNullable(sessaoVotacaoRepository.sessaoVotacaoAberta(votoDTO.getIdPauta())
				.orElseThrow(() -> new EntityNotFoundException("Não existe sessão de votação aberta para esta pauta!!")));
				
				
		Optional<Pauta> pauta = Optional.ofNullable(pautaRepository.findById(votoDTO.getIdPauta())
				.orElseThrow(() -> new EntityNotFoundException("Pauta não encontrada!!")));
		
		Optional<Associado> associado = Optional.ofNullable(associadoRepository.findById(votoDTO.getIdAssociado())
				.orElseThrow(() -> new EntityNotFoundException("Associado não encontrado!!")));
		
		Optional<Voto> votoJaExistente = votoRepository.findByAssociadoAndPauta(associado.get(), pauta.get());
		
		if(votoJaExistente.isPresent()) {
			throw new PermissionDeniedDataAccessException("Associado não pode votar mais de uma vez!!!", null);
		}
		
		Voto votoAssociado = Voto.builder()
				.associado(associado.get())
				.pauta(pauta.get())
				.descVoto(votoDTO.getDescVoto())
				.build();
		
		votoRepository.save(votoAssociado);
			
	}
	
	public Long contabilizarVotos() {
		return (long) votoRepository.findAll().size();
	}
	
	public Long contabilizarVotosPorPauta(Long idPauta) {
		return (long) votoRepository.findAllByPautaId(idPauta).get().size();
	}

}
