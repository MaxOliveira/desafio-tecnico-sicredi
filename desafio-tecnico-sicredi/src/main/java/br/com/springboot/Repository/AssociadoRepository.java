package br.com.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.domain.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long>{

}
