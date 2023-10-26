package com.senai.guilherme.PrjGame.servicies;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.senai.guilherme.PrjGame.entities.Jogo;
import com.senai.guilherme.PrjGame.repository.jogoRepository;

@Service
public class jogoService {
private final jogoRepository JogoRepository;	
	@Autowired
	public jogoService(jogoRepository JogoRepository ) {
		this.JogoRepository = JogoRepository;
	}
	
	public Jogo SaveJogo(Jogo Jogo) {
		return JogoRepository.save(Jogo);
	}
	public List<Jogo> getAllJogo(){
		return JogoRepository.findAll();
	}
	
	public Jogo getJogoByid(Long id) {
		return JogoRepository.findById(id).orElse(null);			
	}
	
	public void deleteJogo(Long id) {
		JogoRepository.deleteById(id);
	}
	
	// fazendo o update do jogo com o optional
		public Jogo updateJogo(Long id, Jogo novoJogo) {
	        Optional<Jogo> jogoOptional = JogoRepository.findById(id);
	        if (jogoOptional.isPresent()) {
	        	Jogo jogoExistente = jogoOptional.get();
	           	jogoExistente.setname(novoJogo.getname());
	        	jogoExistente.setplataform(novoJogo.getplataform());          
	            return JogoRepository.save(jogoExistente); 
	        } else {
	            return null; 
	        }
	    }

	
	
}
