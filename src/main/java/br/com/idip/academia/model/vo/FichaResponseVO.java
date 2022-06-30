package br.com.idip.academia.model.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FichaResponseVO {

	private Integer idUsuarioVO;
	private String descricao;
	private List<ExercicioResponseVO> exercicios;

}
