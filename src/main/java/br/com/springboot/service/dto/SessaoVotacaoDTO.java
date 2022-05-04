package br.com.springboot.service.dto;

import java.io.Serializable;

import br.com.springboot.domain.Pauta;
import br.com.springboot.domain.enums.IndicadorSessaoAberta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SessaoVotacaoDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Pauta pauta;
	private IndicadorSessaoAberta indicadorSessaoAberta;
	private Long idPauta;
	private Long tempoSessao;

}
