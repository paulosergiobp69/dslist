package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
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
	
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
//		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
//		return dto;
		return result.stream().map(x -> new GameMinDTO(x)).toList();

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
