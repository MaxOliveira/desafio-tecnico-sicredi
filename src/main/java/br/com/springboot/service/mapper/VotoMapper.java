package br.com.springboot.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.springboot.domain.Voto;
import br.com.springboot.service.dto.VotoDTO;

@Component
public class VotoMapper implements AbstractMapper<Voto, VotoDTO>{

	@Override
	public VotoDTO entidadeParaDTO(Voto entidade) {
		return VotoDTO.builder()
				.idAssociado(entidade.getAssociado().getId())
				.idPauta(entidade.getPauta().getId())
				.descVoto(entidade.getDescVoto())
				.build();
	}
	
	@Override
	public List<VotoDTO> entidadesParaDTOs(List<Voto> pautas) {
		List<VotoDTO> pautaDTO = new ArrayList<VotoDTO>();
		
		pautas.forEach(voto -> pautaDTO.add(
				VotoDTO.builder()
				.idAssociado(voto.getAssociado().getId())
				.idPauta(voto.getPauta().getId())
				.descVoto(voto.getDescVoto())
				.build()));
		
		return pautaDTO;
	}

}
