package br.com.springboot.service.mapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import br.com.springboot.domain.Pauta;
import br.com.springboot.service.dto.PautaDTO;

@Component
public class PautaMapper implements AbstractMapper<Pauta, PautaDTO>{

	@Override
	public List<PautaDTO> entidadesParaDTOs(List<Pauta> pautas) {
		List<PautaDTO> pautaDTO = new ArrayList<PautaDTO>();
		
		pautas.forEach(pauta -> pautaDTO.add(
				PautaDTO.builder()
				.id(pauta.getId())
				.descricao(pauta.getDescricao())
				.build()));
		
		return pautaDTO;
	}

	@Override
	public PautaDTO entidadeParaDTO(Pauta entidade) {
		return PautaDTO.builder()
				.id(entidade.getId())
				.descricao(entidade.getDescricao())
				.build();
	}

}
