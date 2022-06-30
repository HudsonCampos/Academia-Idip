package br.com.idip.academia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_ficha")
public class Ficha {

	@Id
	@GeneratedValue(generator = "seq_ficha", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_ficha", allocationSize = 1, sequenceName = "seq_ficha")
	@Column(name = "id_ficha")
	private Integer idFicha;
	
	@Column(name = "descricao", length = 255, nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_pk")
	private Usuario usuario;
	
	@Builder.Default
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "t_ficha_t_exercicio",
			joinColumns = @JoinColumn(name = "id_ficha"),
			inverseJoinColumns = @JoinColumn(name = "id_exercicio"))
	private List<Exercicio> exercicios = new ArrayList();
	
}
