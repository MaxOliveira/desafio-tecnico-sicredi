package br.com.springboot.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.domain.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long>{
	

}
