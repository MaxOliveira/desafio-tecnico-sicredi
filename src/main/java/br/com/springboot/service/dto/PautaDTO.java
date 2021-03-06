package br.com.springboot.service.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PautaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descricao;
	
}
