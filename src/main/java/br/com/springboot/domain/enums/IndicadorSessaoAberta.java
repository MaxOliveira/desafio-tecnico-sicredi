package br.com.springboot.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Domínio para os campos do tipo S/N.
 */
@Getter
@RequiredArgsConstructor
public enum IndicadorSessaoAberta {
	
	 S("S"),
     N("N");

	 private final String valor;

	 public static IndicadorSessaoAberta getIndicador(String valor) {
	     for (IndicadorSessaoAberta indicador : IndicadorSessaoAberta.values()) {
	          if (indicador.getValor().equals(valor)) {
	                return indicador;
	          }
	      }
	   return null;
	 }

}
