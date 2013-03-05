package mock.services;

import mock.beans.Commentaire;
import mock.dao.ICommentaireDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
