package com.maintacloud.domain.enumeration.support;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by issam on 15/11/2016.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EnumAppModules {

    COMPTA_GENERALE("COMPTA_GENERALE", "Comptabilité générale"),
    IMMO("IMMO", "Gestion d'immobilisation"),
    DEC_EMPLOYEUR("DEC_EMPLOYEUR", "Déclaration employeur"),
    CONFIG("CONFIG", "Configuration globale"),
    PAIE("PAIE", "Paie");

    private String value;
    private String libelle = "";


    EnumAppModules(String module, String libelle){
        this.value = module;
        this.libelle = libelle;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
