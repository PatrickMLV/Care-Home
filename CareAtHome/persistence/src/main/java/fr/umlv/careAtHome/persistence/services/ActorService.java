package fr.umlv.careAtHome.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.umlv.careAtHome.persistence.beans.Actor;
import fr.umlv.careAtHome.persistence.dao.IActorDAO;

@Transactional
@Service("ActorService")
public class ActorService {

	@Autowired
	IActorDAO actorDAO;

	public ActorService(IActorDAO actorDAO) {
		this.actorDAO = actorDAO;
	}

	@Transactional()
	public Actor login(String login, String password) {
		Actor actor = actorDAO.login(login, password);
		if (actor == null) {
			return null;
		}
		return actor;
	}

	@Transactional()
	public Actor getActorByUuid(int uuid) {
		return actorDAO.findActorByUuid(uuid);
	}

}
