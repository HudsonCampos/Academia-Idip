package br.com.idip.academia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.idip.academia.conversoes.DozerConverter;
import br.com.idip.academia.model.Perfil;
import br.com.idip.academia.model.Usuario;
import br.com.idip.academia.model.vo.UsuarioVO;
import br.com.idip.academia.repository.PerfilRepository;
import br.com.idip.academia.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PerfilRepository perfilRepository;
	
	public UsuarioVO created(UsuarioVO usuarioVO) {		
		int idPerfilUsuario = usuarioVO.getIdPerfil();
		Perfil perfil = perfilRepository.findById(idPerfilUsuario)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não localizado!"));
		
		
		
		Usuario usuario = DozerConverter.parseObjetct(usuarioVO, Usuario.class);
		usuario.setPerfil(perfil);
		return DozerConverter.parseObjetct(usuarioRepository.save(usuario), UsuarioVO.class);				
		
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não localizado!"));
		
		return User.builder()
				.username(usuario.getUsername())
				.password(usuario.getSenha())
				.roles("USER")
				.build();
	}
	
	
}
