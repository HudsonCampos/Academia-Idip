package br.com.idip.academia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.idip.academia.model.vo.PerfilVO;
import br.com.idip.academia.service.CadastroPerfilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api-academia/perfis")
@Api(tags = "Cadastrar perfil de usuario.")
public class CadastroPerfilController {

	@Autowired
	CadastroPerfilService cadastroPerfilService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Metodo que Cadastra a perfil.")
	public PerfilVO criarPerfil(@RequestBody @Valid PerfilVO perfilvo) {
		return cadastroPerfilService.criarPerfil(perfilvo);
	}
}
