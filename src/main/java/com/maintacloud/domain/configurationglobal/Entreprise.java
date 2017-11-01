package com.maintacloud.domain.configurationglobal;

import com.fasterxml.jackson.annotation.JsonView;
import com.maintacloud.domain.BaseEntity;
import com.maintacloud.domain.Views;
import com.maintacloud.socle.annotation.ActeurActionLibelle;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Dahech on 13/12/2016.
 */
@Entity
@Table(name = "ENTREPRISE")
public class Entreprise extends BaseEntity implements Serializable {

    //private static Logger logger = Logger.getLogger(Entreprise.class.getName());
    private static final long serialVersionUID = 1L;

    @ActeurActionLibelle(fieldLibelle = "code entreprise")
    @JsonView(value = {Views.EntrepriseForTable.class, Views.UserContextData.class, Views.EntrepriseForEdition.class, Views.AppUserView.class, Views.AppFullUserView.class})
    @Column(name = "CODE")
    public String code;

    @JsonView(value = {Views.EntrepriseForTable.class, Views.UserContextData.class, Views.EntrepriseForEdition.class,
            Views.AppUserView.class, Views.AppFullUserView.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENTREPRISE_ID")
    private Long entrepriseId;

    @ActeurActionLibelle(fieldLibelle = "code exploitation")
    @JsonView(value = {Views.EntrepriseForEdition.class})
    @Column(name = "CODE_EXPLOITATION")
    private String codeExploitation = "0000";

    @ActeurActionLibelle(fieldLibelle = "raison sociale")
    @JsonView(value = {Views.EntrepriseForTable.class, Views.UserContextData.class, Views.EntrepriseForEdition.class, Views.AppUserView.class, Views.AppFullUserView.class})
    @Column(name = "RAISON_SOCIALE")
    private String raisonSociale;


    @ActeurActionLibelle(fieldLibelle = "numéro CNSS gérant")
    @JsonView(value = {Views.EntrepriseForEdition.class})
    @Column(name = "NUM_CNSS_GERANT")
    private String numCNSSGerant;

    @JsonView(value = {Views.EntrepriseForEdition.class})
    @Column(name = "REGIME_HORAIRE")
    private String regimehoraire;

    @JsonView(value = {Views.EntrepriseForEdition.class})
    @Column(name = "SUPPRIME", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean supprime = Boolean.FALSE;


    @JsonView(value = {Views.EntrepriseForEdition.class})
    @Column(name = "NUM_CNSS")
    private String numCNSS;


    @ActeurActionLibelle(fieldLibelle = "Adresse entreprise")
    @JsonView(value = {Views.EntrepriseForTable.class, Views.EntrepriseForEdition.class})
    @Column(name = "ADRESSE")
    private String adresse;

    @JsonView(value = {Views.EntrepriseForEdition.class})
    @Column(name = "ARRONDI")
    private Boolean arrondi;


    // TODO AMINE ou ISSAM : colonne a creer en BDD
    @Transient
    private String nationalite;


    @ActeurActionLibelle(fieldLibelle = "Activité entreprise")
    @JsonView(value = {Views.EntrepriseForEdition.class, Views.EntrepriseForTable.class})
    @Column(name = "ACTIVITE")
    private String activite;


    @ActeurActionLibelle(fieldLibelle = "Matricule fiscale")
    @JsonView(value = {Views.EntrepriseForEdition.class, Views.EntrepriseForTable.class})
    @Column(name = "MAT_FISCALE")
    private String matFiscal;

    @ActeurActionLibelle(fieldLibelle = "Code Douane")
    @JsonView(value = {Views.EntrepriseForEdition.class})
    @Column(name = "CODE_DOUANE")
    private String codeDouane;


    @ActeurActionLibelle(fieldLibelle = "Date création entreprise")
    @JsonView(value = {Views.EntrepriseForEdition.class})
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;


    @ActeurActionLibelle(fieldLibelle = "Forme juridique  entreprise")
    @JsonView(value = {Views.EntrepriseForEdition.class})
    @Column(name = "FORME_JURIDIQUE")
    private String formeJuridique;

    @ActeurActionLibelle(fieldLibelle = "Numéro registre commerciale")
    @JsonView(value = {Views.EntrepriseForTable.class, Views.EntrepriseForEdition.class})
    @Column(name = "NUMERO_REGISTRE_COMMERCIALE")
    private String numeroRegistreCommerciale;


    @JsonView(value = {Views.EntrepriseForEdition.class})
    @Column(name = "DATE_ARRETE")
    private String dateArrete;

    public Long getEntrepriseId() {
        return entrepriseId;
    }

    public void setEntrepriseId(Long entrepriseId) {
        this.entrepriseId = entrepriseId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeExploitation() {
        return codeExploitation;
    }

    public void setCodeExploitation(String codeExploitation) {
        this.codeExploitation = codeExploitation;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getNumCNSSGerant() {
        return numCNSSGerant;
    }

    public void setNumCNSSGerant(String numCNSSGerant) {
        this.numCNSSGerant = numCNSSGerant;
    }

    public String getRegimehoraire() {
        return regimehoraire;
    }

    public void setRegimehoraire(String regimehoraire) {
        this.regimehoraire = regimehoraire;
    }

    public Boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(Boolean supprime) {
        this.supprime = supprime;
    }

    public String getNumCNSS() {
        return numCNSS;
    }

    public void setNumCNSS(String numCNSS) {
        this.numCNSS = numCNSS;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Boolean getArrondi() {
        return arrondi;
    }

    public void setArrondi(Boolean arrondi) {
        this.arrondi = arrondi;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getMatFiscal() {
        return matFiscal;
    }

    public void setMatFiscal(String matFiscal) {
        this.matFiscal = matFiscal;
    }

    public String getCodeDouane() {
        return codeDouane;
    }

    public void setCodeDouane(String codeDouane) {
        this.codeDouane = codeDouane;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getFormeJuridique() {
        return formeJuridique;
    }

    public void setFormeJuridique(String formeJuridique) {
        this.formeJuridique = formeJuridique;
    }

    public String getNumeroRegistreCommerciale() {
        return numeroRegistreCommerciale;
    }

    public void setNumeroRegistreCommerciale(String numeroRegistreCommerciale) {
        this.numeroRegistreCommerciale = numeroRegistreCommerciale;
    }

    public String getDateArrete() {
        return dateArrete;
    }

    public void setDateArrete(String dateArrete) {
        this.dateArrete = dateArrete;
    }

    @Override
    public boolean equals(final Object rhs) {
        if (rhs instanceof Entreprise) {
            return ((Entreprise) rhs).getEntrepriseId() == getEntrepriseId();
        }

        return false;
    }


    @Override
    protected Long getId() {
        return entrepriseId;
    }

    @Override
    public BaseEntity builEntityToTrack() {
        return null;
    }
}
