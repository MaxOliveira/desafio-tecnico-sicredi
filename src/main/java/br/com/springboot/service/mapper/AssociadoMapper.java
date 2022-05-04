package br.com.springboot.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.springboot.domain.Associado;
import br.com.springboot.service.dto.AssociadoDTO;

@Component
public class AssociadoMapper implements AbstractMapper<Associado, AssociadoDTO>{
	
	@Override
	public List<AssociadoDTO> entidadesParaDTOs(List<Associado> associados) {
		List<AssociadoDTO> pautaDTO = new ArrayList<AssociadoDTO>();
		
		associados.forEach(associado -> pautaDTO.add(
				AssociadoDTO.builder()
				.idAssociado(associado.getId())
				.cpfAssociado(associado.getCpfAssociado())
				.build()));
		
		return pautaDTO;
	}

	@Override
	public AssociadoDTO entidadeParaDTO(Associado entidade) {
		return AssociadoDTO.builder()
				.idAssociado(entidade.getId())
				.cpfAssociado(entidade.getCpfAssociado())
				.build();
	}

}
