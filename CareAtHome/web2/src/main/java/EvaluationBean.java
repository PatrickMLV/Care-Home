import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import toPutInPersistence.Evaluation;

@ManagedBean
@SessionScoped
public class EvaluationBean {

	private String candidateFullName;
	private String evaluation;
	private Evaluation selectedEv; 
	private List<Evaluation> evaluations = new ArrayList<Evaluation>();
	
	public EvaluationBean() {
		Evaluation ev = new Evaluation();
		ev.setId(1);
		ev.setCandidateName("Andre Manoukian");
		ev.setJudgeName("toto");
		ev.setDate(new Date());
		ev.setEvaluation("Très inspiré");
		evaluations.add(ev);
		
		ev = new Evaluation();
		ev.setId(2);
		ev.setCandidateName("Sinclair");
		ev.setJudgeName("toto 2");
		ev.setDate(new Date());
		ev.setEvaluation("Méchant");
		evaluations.add(ev);
		
		ev = new Evaluation();
		ev.setId(3);
		ev.setCandidateName("Dove Attia");
		ev.setJudgeName("toto 3");
		ev.setDate(new Date());
		ev.setEvaluation("Cool");
		evaluations.add(ev);
		
		ev = new Evaluation();
		ev.setId(4);
		ev.setCandidateName("Marianne James");
		ev.setJudgeName("toto 4");
		ev.setDate(new Date());
		ev.setEvaluation("Effrayante");
		evaluations.add(ev);
		
	}
	
	public String getCandidateFullName() {
		return candidateFullName;
	}
	public void setCandidateFullName(String candidateFullName) {
		this.candidateFullName = candidateFullName;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public Evaluation getSelectedEv() {
		return selectedEv;
	}
	public void setSelectedEv(Evaluation selectedEv) {
		this.selectedEv = selectedEv;
	}
	
	public void saveEvaluation(String judgeLogin){
		System.out.println("SAVE");
		System.out.println(judgeLogin);
		System.out.println(candidateFullName);
		System.out.println(evaluation);
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	
	
}
