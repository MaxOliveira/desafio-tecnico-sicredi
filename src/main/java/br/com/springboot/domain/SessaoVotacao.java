package br.com.springboot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.springboot.domain.enums.IndicadorSessaoAberta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity
@Table(schema = "heroku_09bec3880e95823", name = "sessao_votacao")
public class SessaoVotacao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_SESSAO_VOTACAO")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_PAUTA")
	private Pauta pauta;

	@NonNull
	@Column(name = "IND_SESSAO_ABERTA")
	private String indicadorSessaoAberta;

}
