package br.com.springboot.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Domínio para os campos do tipo S/N.
 */
@Getter
@RequiredArgsConstructor
public enum IndicadorSessaoAberta {
	
	 S(Boolean.TRUE),
     N(Boolean.FALSE);

	 private final Boolean valor;

	 public static IndicadorSessaoAberta getIndicador(Boolean valor) {
	     for (IndicadorSessaoAberta indicador : IndicadorSessaoAberta.values()) {
	          if (indicador.getValor().equals(valor)) {
	                return indicador;
	          }
	      }
	   return null;
	 }

}
