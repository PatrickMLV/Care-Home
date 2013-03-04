package fr.umlv.careAtHome.persistence.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.umlv.careAtHome.persistence.beans.Evaluation;
import fr.umlv.careAtHome.persistence.dao.IEvaluationDAO;

@Transactional
@Service("EvaluationService")
public class EvaluationService {

	@Autowired
	IEvaluationDAO evaluationDAO;

	/**
	 * 
	 * @param uuidEvaluator
	 *            uuid de l'évaluateur
	 * @param uuidActor
	 *            uuid de la personne évaluée
	 * @param evaluation
	 *            texte d'évaluation
	 * @param date
	 *            date de l'évaluation
	 * @return vrai si l'évaluation s'est bien passé, faux sinon
	 */
	@Transactional()
	public Evaluation setEvaluation(int uuidEvaluator, int uuidActor,
			String evaluation, Date date) {
		Evaluation evaluation2 = new Evaluation();
		evaluation2.setDate(date);
		evaluation2.setUuidEvaluator(uuidEvaluator);
		evaluation2.setUuidActor(uuidActor);
		evaluation2.setEvaluation(evaluation);
		evaluationDAO.persist(evaluation2);
		return evaluation2;
	}

}
