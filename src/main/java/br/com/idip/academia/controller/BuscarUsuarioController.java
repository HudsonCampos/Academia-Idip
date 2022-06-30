package br.com.idip.academia.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.idip.academia.model.vo.UsuarioVO;
import br.com.idip.academia.service.BuscarUsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api-academia/usuarios")
@Api(tags = "Buscar usuario por pagina passando pagina, e o limite.")
public class BuscarUsuarioController {

	@Autowired
	BuscarUsuarioService buscarUsuarioService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(tags = "Metodo que retorna a pagina de Usuario.", value = "pagina de usuarios.")
	public ResponseEntity<Page<UsuarioVO>> buscarPaginaTodosUsuarios(@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "limite", defaultValue = "3") Integer limite,
			@RequestParam(value = "direcao", defaultValue = "asc") String direcao){
		
		
		var sortDirecao = "DESC".equalsIgnoreCase(direcao)?Direction.DESC:Direction.ASC;
		
		Pageable pageable = PageRequest.of(pagina, limite, Sort.by(sortDirecao ,"nome"));
		
		Page<UsuarioVO> pageUsuarios = buscarUsuarioService.buscarPaginaTodosUsuarios(pageable);
		
		pageUsuarios
		.stream()
			.forEach(user -> user
					.add(linkTo(methodOn(BuscarUsuarioController.class).buscarUsuarioId(user.getIdUsuario())).withSelfRel()));
	
	
		return ResponseEntity.ok(pageUsuarios);		
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioVO buscarUsuarioId(@PathVariable("id") Integer id) {
		var entity = buscarUsuarioService.buscarUsuarioId(id);
		return entity.add(linkTo(methodOn(BuscarUsuarioController.class).buscarUsuarioId(id)).withSelfRel());
	}
	
	
}

