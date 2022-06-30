package br.com.idip.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.idip.academia.model.vo.ExercicioRequestVO;
import br.com.idip.academia.model.vo.ExercicioResponseVO;
import br.com.idip.academia.service.CadastroExercicioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api-academia/exercicios")
@Api(tags = "Cadastrar exercicio fisico.")
public class CadastroExercicioController {

	@Autowired
	CadastroExercicioService cadastroExercicioService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Metodo que Cadastra exercicio fisico.")
	public ExercicioResponseVO cadastrarExercicio(@RequestBody ExercicioRequestVO exercicioVO) {
		return cadastroExercicioService.cadastrarExercicio(exercicioVO);
	}
	
	
}
