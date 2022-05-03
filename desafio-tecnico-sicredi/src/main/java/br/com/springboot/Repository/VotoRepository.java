package br.com.springboot.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.domain.Associado;
import br.com.springboot.domain.Pauta;
import br.com.springboot.domain.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long>{

	Optional<Voto> findByAssociadoAndPauta(Associado associado, Pauta pauta);
}
