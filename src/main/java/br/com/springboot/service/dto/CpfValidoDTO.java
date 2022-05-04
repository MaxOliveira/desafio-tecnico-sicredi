package br.com.springboot.service.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CpfValidoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String status;

}
