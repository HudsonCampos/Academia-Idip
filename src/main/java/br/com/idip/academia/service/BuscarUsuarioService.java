package br.com.idip.academia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.idip.academia.conversoes.DozerConverter;
import br.com.idip.academia.model.Usuario;
import br.com.idip.academia.model.vo.UsuarioVO;
import br.com.idip.academia.repository.UsuarioRepository;

@Service
public class BuscarUsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Page<UsuarioVO> buscarPaginaTodosUsuarios(Pageable pageable) {
		var pageUsuarios = usuarioRepository.findAll(pageable);
		return pageUsuarios.map(this::parsePageObject);		 
	}
	
	public UsuarioVO parsePageObject(Usuario entity) {
		return DozerConverter.parseObjetct(entity, UsuarioVO.class);
	}

	public UsuarioVO buscarUsuarioId(Integer id) {
		var entity = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não localizado!"));
		return DozerConverter.parseObjetct(entity, UsuarioVO.class);
	}
}
