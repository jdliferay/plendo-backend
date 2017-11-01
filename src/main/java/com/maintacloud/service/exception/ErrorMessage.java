package com.maintacloud.service.exception;

public enum ErrorMessage {

	ERROR_DELETE_ENTREPRISE ( "Erreur de suppression de l'entreprise, id== ","ERR000001"),
	ERROR_GET_ENTREPRISE_BY_CODE ( "Erreur de recherche de l'entreprise, code== ","ERR000002"),
	ERROR_GET_ENTREPRISES ( "Erreur de recherche des entreprises","ERR000003"),
	ERROR_GET_EEMPLOYEES ( "Erreur de recherche des Collaborateur","ERR000004"),
	ERROR_GET_SERVICES ( "Erreur de recherche des services.","ERR000005"),
	ERROR_COUNT_EMPLOYEE_BY_MATRICULE("Erreur de comptage des employee par matricule","ERR000006"),
	ERROR_GET_ENTREPRISE_BY_EXER_ID ( "Erreur de recherche de l'entreprise par l'exercice id, code== ","ERR000007");



	private String erreur = "";

	private String code;

	ErrorMessage(String erreur, String code){
		this.erreur = erreur;
		this.code = code;
	}


	public String toString(){
		return erreur;
	}


	public String getErreur() {
		return erreur;
	}


	public void setErreur(String erreur) {
		this.erreur = erreur;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
	
	
}
