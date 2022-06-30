package br.com.idip.academia.model;

import java.io.Serializable;
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
@Table(name = "t_usuario")
public class Usuario implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
	@GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@Column(name = "telefone", nullable = false)
	private String telefone;
	
	@Column(unique = true, name = "username", nullable = false, length = 255)
	private String username;
	
	@Column(name = "senha", nullable = false, length = 255)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;
	
}
