package br.com.idip.academia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.idip.academia.conversoes.DozerConverter;
import br.com.idip.academia.model.Exercicio;
import br.com.idip.academia.model.vo.ExercicioRequestVO;
import br.com.idip.academia.model.vo.ExercicioResponseVO;
import br.com.idip.academia.repository.ExercicioRepository;

@Service
public class CadastroExercicioService{

	@Autowired
	ExercicioRepository exercicioRepository;
	
	public ExercicioResponseVO cadastrarExercicio(ExercicioRequestVO exercicioVO) {
		var entity = DozerConverter.parseObjetct(exercicioVO, Exercicio.class);
		return DozerConverter.parseObjetct(exercicioRepository.save(entity), ExercicioResponseVO.class);
	}
}
