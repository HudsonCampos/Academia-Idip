package br.com.idip.academia.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "t_treino")
public class Treino implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_treino", sequenceName = "seq_treino", allocationSize = 1)
	@GeneratedValue(generator = "seq_treino", strategy = GenerationType.SEQUENCE)
	private Integer id_treino;
	
	@Column(name = "data_treino")
	private LocalDate dataTreino;
	
	@ManyToOne
	@JoinColumn(name = "id_ficha_pk")
	private Ficha ficha;

}
