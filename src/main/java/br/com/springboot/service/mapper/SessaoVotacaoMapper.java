package br.com.springboot.service.mapper;

import org.springframework.stereotype.Component;

import br.com.springboot.domain.SessaoVotacao;
import br.com.springboot.service.dto.SessaoVotacaoDTO;

@Component
public class SessaoVotacaoMapper  implements AbstractMapper<SessaoVotacao, SessaoVotacaoDTO>{

	@Override
	public SessaoVotacaoDTO entidadeParaDTO(SessaoVotacao entidade) {
		return SessaoVotacaoDTO.builder()
				.id(entidade.getId())
				.idPauta(entidade.getPauta().getId())
				.build();
	}

}
