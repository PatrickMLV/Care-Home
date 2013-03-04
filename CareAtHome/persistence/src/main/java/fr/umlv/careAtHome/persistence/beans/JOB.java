package fr.umlv.careAtHome.persistence.beans;

public enum JOB {
	CADRE("CADRE"), 
	PATIENT("PATIENT"), 
	PERSONNEL("PERSONNEL"), 
	RESPONSABLE("RESPONSABLE");
	
	private final String value;
	
	private JOB() {
		value = "";
	}

	private JOB(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
