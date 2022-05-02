package br.com.springboot.service.mapper;

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
		return null;
	}

	@Override
	public PautaDTO entidadeParaDTO(Pauta entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
