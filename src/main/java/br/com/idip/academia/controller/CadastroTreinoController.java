package br.com.idip.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.idip.academia.model.vo.TreinoVO;
import br.com.idip.academia.service.CadastroTreinoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api-academia/treinos")
@Api(tags = "Cadastrar treino de acordo com o id do usuario.")
public class CadastroTreinoController {

	@Autowired
	CadastroTreinoService cadastroTreinoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Metodo que Cadastra o treino passando o id do usuario.")
	public TreinoVO cadastro(@RequestBody TreinoVO treinovo) {
		return cadastroTreinoService.cadastro(treinovo);
	}
	
}
