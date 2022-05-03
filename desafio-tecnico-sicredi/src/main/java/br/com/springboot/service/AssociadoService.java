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
		String CpfSemMascara = associadoDTO.getCpfAssociado().replaceAll("[^0-9]", "");
		isCpfValido(CpfSemMascara);
		
		Associado associado = Associado.builder().cpfAssociado(associadoDTO.getCpfAssociado()).build();
		associadoRepository.save(associado);
		
	}
	
	boolean isCpfValido(String cpfAssociado) throws NoPermissionException {
		String uri = "https://user-info.herokuapp.com/users/" + cpfAssociado;
		RestTemplate restTemplate = new RestTemplate();
		String status = restTemplate.getForObject(uri, CpfValidoDTO.class).getStatus();
		
		if(status.equals(UNABLE_TO_VOTE)) {
			throw new NoPermissionException("Associado sem permissão para votar!!");
		}
		return true;
	}

}
