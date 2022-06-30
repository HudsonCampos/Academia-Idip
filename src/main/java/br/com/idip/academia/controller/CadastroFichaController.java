package br.com.idip.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.idip.academia.model.vo.FichaRequestVO;
import br.com.idip.academia.model.vo.FichaResponseVO;
import br.com.idip.academia.service.CadastroFichaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api-academia/fichas")
@Api(tags = "Cadastrar ficha de atividade fisica para cada usuario e sua atividade.")
public class CadastroFichaController {

	@Autowired
	CadastroFichaService cadastroFichaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Metodo que Cadastra a ficha.")
	public FichaResponseVO cadastrarFicha(@RequestBody FichaRequestVO fichaVO) {
		return cadastroFichaService.cadastrarFicha(fichaVO);
	}
}
