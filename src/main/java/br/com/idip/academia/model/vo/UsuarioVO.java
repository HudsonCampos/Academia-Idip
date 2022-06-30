package br.com.idip.academia.model.vo;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper=false)
public class UsuarioVO extends RepresentationModel<UsuarioVO> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idUsuario;
	
	@NotEmpty(message = "{campo.nome.vazio}")
	private String nome;
	
	@NotEmpty(message = "{campo.email.vazio}")
	private String email;
	
	private Date dataNascimento;
	
	@NotEmpty(message = "{campo.telefone.vazio}")
	private String telefone;
	
	@NotEmpty(message = "{campo.username.vazio}")
	private String username;
	
	@NotEmpty(message = "{campo.senha.vazio}")
	private String senha;
	
	private Integer idPerfil;
	private PerfilVO perfilVO;
	
}
