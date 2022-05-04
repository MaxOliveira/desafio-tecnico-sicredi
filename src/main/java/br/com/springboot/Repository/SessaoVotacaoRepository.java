package br.com.springboot.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.domain.Pauta;
import br.com.springboot.domain.SessaoVotacao;

@Repository
public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Long>{
	
	@Query("SELECT sessao FROM SessaoVotacao sessao WHERE sessao.pauta.id = ?1 AND sessao.indicadorSessaoAberta = 'S'")
	Optional<SessaoVotacao> sessaoVotacaoAberta(Long idPauta);

}
