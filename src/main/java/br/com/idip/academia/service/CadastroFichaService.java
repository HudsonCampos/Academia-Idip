package br.com.idip.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.idip.academia.conversoes.DozerConverter;
import br.com.idip.academia.model.Exercicio;
import br.com.idip.academia.model.Ficha;
import br.com.idip.academia.model.Usuario;
import br.com.idip.academia.model.vo.FichaRequestVO;
import br.com.idip.academia.model.vo.FichaResponseVO;
import br.com.idip.academia.repository.ExercicioRepository;
import br.com.idip.academia.repository.FichaRepository;
import br.com.idip.academia.repository.UsuarioRepository;

@Service
public class CadastroFichaService {

	private static final Integer PERFIL_ADMIN = 1;

	@Autowired
	private FichaRepository fichaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ExercicioRepository exercicioRepository;
	
	public FichaResponseVO cadastrarFicha(FichaRequestVO fichaVO) {
		
		Usuario usuario = usuarioRepository.findById(fichaVO.getIdUsuarioVO())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id usuario não localizado!"));
		
		List<Exercicio> exercicios = exercicioRepository.findAllById(fichaVO.getIdExercicioVO());
		
		Ficha ficha = Ficha
				.builder()
				.usuario(usuario)
				.exercicios(exercicios)
				.descricao(fichaVO.getDescricao())
				.build();
		
		if(!PERFIL_ADMIN.equals(usuario.getPerfil().getIdPerfil())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario não permitido!");
		}
		
		ficha = fichaRepository.save(ficha);
		
		return DozerConverter.parseObjetct(ficha, FichaResponseVO.class);
		
	}
}
