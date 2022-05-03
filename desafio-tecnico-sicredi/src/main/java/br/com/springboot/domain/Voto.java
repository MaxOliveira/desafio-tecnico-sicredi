package br.com.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(schema = "heroku_09bec3880e95823", name = "voto")
public class Voto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_VOTO")
	private Long id;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name = "ID_ASSOCIADO")
	private Associado associado;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name = "ID_PAUTA_VOTO")
	private Pauta pauta;
	
	@NonNull
	@Column(name = "DESC_VOTO")
	private String descVoto;

}
