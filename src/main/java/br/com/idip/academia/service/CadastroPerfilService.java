package br.com.idip.academia.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.idip.academia.conversoes.DozerConverter;
import br.com.idip.academia.model.Perfil;
import br.com.idip.academia.model.vo.PerfilVO;
import br.com.idip.academia.repository.PerfilRepository;

@Service
public class CadastroPerfilService {

	@Autowired
	PerfilRepository perfilRepository;
	
	public PerfilVO criarPerfil(@Valid PerfilVO perfilvo) {		
		var entity = DozerConverter.parseObjetct(perfilvo, Perfil.class);
		return DozerConverter.parseObjetct(perfilRepository.save(entity), PerfilVO.class);
		
	}

}
