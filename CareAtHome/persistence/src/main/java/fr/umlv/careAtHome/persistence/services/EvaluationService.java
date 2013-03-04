package fr.umlv.careAtHome.persistence.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import fr.umlv.careAtHome.persistence.dao.IEvaluationDAO;

public class EvaluationService {

	@Autowired
	IEvaluationDAO evaluationDAO;

	/**
	 * 
	 * @param uuidEvaluator uuid de l'évaluateur
	 * @param uuidActor uuid de la personne évaluée
	 * @param evaluation texte d'évaluation
	 * @param date date de l'évaluation
	 * @return vrai si l'évaluation s'est bien passé, faux sinon
	 */
	public boolean setEvaluation(int uuidEvaluator, int uuidActor,
			String evaluation, Date date){
		return false;
	}

}
