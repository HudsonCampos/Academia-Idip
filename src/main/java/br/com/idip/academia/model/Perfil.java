package br.com.idip.academia.model;

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
@Table(name = "t_perfil")
public class Perfil{


	@Id
	@SequenceGenerator(name = "seq_perfil", sequenceName = "seq_perfil", allocationSize = 1)
	@GeneratedValue(generator = "seq_perfil", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_perfil")
	private Integer idPerfil;

	@Column(name = "descricao", nullable = false)
	private String descricao;
}
