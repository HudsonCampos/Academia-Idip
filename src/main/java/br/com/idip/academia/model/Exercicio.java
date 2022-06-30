package br.com.idip.academia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@Table(name = "t_exercicio")
public class Exercicio implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_exercicio", sequenceName = "seq_exercicio", allocationSize = 1)
	@GeneratedValue(generator = "seq_exercicio", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_exercicio")
	private Integer idExercicio;

	@Column(name = "descricao", nullable = false)
	private String descricao;

}
