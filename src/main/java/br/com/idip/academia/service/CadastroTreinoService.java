package br.com.idip.academia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.idip.academia.conversoes.DozerConverter;
import br.com.idip.academia.model.Ficha;
import br.com.idip.academia.model.Treino;
import br.com.idip.academia.model.vo.TreinoVO;
import br.com.idip.academia.repository.FichaRepository;
import br.com.idip.academia.repository.TreinoRepository;

@Service
public class CadastroTreinoService {

	@Autowired
	TreinoRepository treinoRepository;
	
	@Autowired 
	FichaRepository fichaRepository;
	
	public TreinoVO cadastro(TreinoVO treinoVO) {
		
		int idFicha = treinoVO.getIdFichaVO();
		Ficha ficha = fichaRepository.findById(idFicha)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não localizado!"));
				
		Treino treino = Treino.builder()
				.ficha(ficha)
				.dataTreino(treinoVO.getDataTreino())
				.build();
		
		return DozerConverter.parseObjetct(treinoRepository.save(treino), TreinoVO.class);
		
	}
}
