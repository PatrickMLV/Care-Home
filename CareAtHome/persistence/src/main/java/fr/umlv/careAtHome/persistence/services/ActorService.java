package fr.umlv.careAtHome.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;

import fr.umlv.careAtHome.persistence.dao.IActorDAO;

public class ActorService {
	
	@Autowired
	IActorDAO actorDAO;
	
	public boolean login(String login, String password){
		return false;
	}

}
