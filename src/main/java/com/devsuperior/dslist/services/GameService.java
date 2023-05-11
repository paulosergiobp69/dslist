package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
//  1a. versao retornando todos os campos para o controller	
//	public List<Game> findAll(){
//		List<Game> result = gameRepository.findAll();
//		return result;
//	}
	
	@Transactional(readOnly = true)  // anotation do spring 
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
//		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
//		return dto;
		return result.stream().map(x -> new GameMinDTO(x)).toList();

	}

	// 2a. versao
	@Transactional(readOnly = true)  // anotation do spring 
	public GameDTO findById(@PathVariable Long listId) {
		Game result = gameRepository.findById(listId).get();
		return new GameDTO(result);
	}
	

	@Transactional(readOnly = true)
	public List<GameMinDTO> findByGameList(Long listId) {
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		return games.stream().map(GameMinDTO::new).toList();
	}

	
	
////	@Transactional(readOnly = true)
//	public List<GameMinDTO> findAll(){
//		List<Game> result = gameRepository.findAll();
//		return result;
//		
////	public List<GameM> findAll() {
////		List<Game> result = gameRepository.findAll();
////		return result.stream().map(GameMinDTO::new).toList();
//	}
}
