package fr.umlv.careAtHome.persistence.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import fr.umlv.careAtHome.persistence.dao.IEvaluationDAO;

public class EvaluationService {

	@Autowired
	IEvaluationDAO evaluationDAO;

	/**
	 * 
	 * @param uuidEvaluator uuid de l'�valuateur
	 * @param uuidActor uuid de la personne �valu�e
	 * @param evaluation texte d'�valuation
	 * @param date date de l'�valuation
	 * @return vrai si l'�valuation s'est bien pass�, faux sinon
	 */
	public boolean setEvaluation(int uuidEvaluator, int uuidActor,
			String evaluation, Date date){
		return false;
	}

}
