package br.com.idip.academia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.idip.academia.model.vo.UsuarioVO;
import br.com.idip.academia.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api-academia/usuarios")
@Api(tags = "Cadastrar usuario e o id de seu perfil.")
public class CadastroUsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Metodo que Cadastra o usuario passando o id do perfil.")
	public UsuarioVO created(@RequestBody @Valid UsuarioVO usuarioVO) {
		return usuarioService.created(usuarioVO);
	}

}
