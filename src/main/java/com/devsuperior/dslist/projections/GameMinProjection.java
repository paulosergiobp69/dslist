package com.devsuperior.dslist.projections;

public interface GameMinProjection {

	// sempre depois do get -> Primeira letra MAIUSCULA
	// para referenciar a consulta customizada 
	// repositorio --> GameRepository
	// chamada no postman: https://localhpostsot:8080/lists/1/games
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
