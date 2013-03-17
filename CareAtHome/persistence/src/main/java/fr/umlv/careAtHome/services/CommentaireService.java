package fr.umlv.careAtHome.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.umlv.careAtHome.persistence.beans.Commentaire;
import fr.umlv.careAtHome.persistence.dao.ICommentaireDAO;

@Transactional
@Service("CommentaireService")
public class CommentaireService {

	@Autowired
	ICommentaireDAO commentaireDAO;

	public CommentaireService(ICommentaireDAO commentaireDAO) {
		this.commentaireDAO = commentaireDAO;
	}

	@Transactional()
	public Commentaire findCommentaireByUuid(int uuid) {
		return commentaireDAO.findCommentaireByUuid(uuid);
	}

}
