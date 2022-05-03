package br.com.springboot.service;

import javax.naming.NoPermissionException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.springboot.Repository.AssociadoRepository;
import br.com.springboot.domain.Associado;
import br.com.springboot.service.dto.AssociadoDTO;
import br.com.springboot.service.dto.CpfValidoDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AssociadoService {
	private static String UNABLE_TO_VOTE = "UNABLE_TO_VOTE";
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	public void cadastrarNovoAssociado(AssociadoDTO associadoDTO) throws NoPermissionException {
		isCpfValido(associadoDTO.getCpfAssociado());
		
		Associado associado = Associado.builder().cpfAssociado(associadoDTO.getCpfAssociado()).build();
		associadoRepository.save(associado);
		
	}
	
	boolean isCpfValido(String cpfAssociado) throws NoPermissionException {
		String uri = "https://user-info.herokuapp.com/users/" + cpfAssociado;
		RestTemplate restTemplate = new RestTemplate();
		CpfValidoDTO result = restTemplate.getForObject(uri, CpfValidoDTO.class);
		
		if(result.getStatus().equals(UNABLE_TO_VOTE)) {
			throw new NoPermissionException("Associado sem permissão para votar!!");
		}
		return true;
	}

}
