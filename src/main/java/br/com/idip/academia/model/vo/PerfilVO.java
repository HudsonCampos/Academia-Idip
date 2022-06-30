package br.com.idip.academia.model.vo;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class PerfilVO {

	private Integer idPerfil;

	@NotEmpty(message = "{campo.descricao.vazio}")
	private String descricao;
}
