package com.maintacloud.service.exception;

import com.google.common.collect.Maps;
import com.maintacloud.socle.annotation.PostgreSqlVendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by issam on 30/08/2016.
 */
@Service
public class DataBaseExeptionHandlerService {

    private static final String UNIQUE_PIECE_BY_EXERCICE = "unique_piece_by_exercice";
    private static final String UNIQUE_MVT_BY_EXERCICE = "unique_mvt_by_exercice";
    private static final String UNIQUE_PIECE_BY_EXERCICE_IN_PIECE_COMPTABLE = "unique_piece_by_exercice_in_pc";
    private static final String ECRITURE_MOUVEMENT_MUST_NOT_BE_ZERO = "mouvement_must_not_be_zero";
    private static final String UNIQUE_CONSTRAINT_CODE_EXERCICE_ENTREPRISE = "unique_code_exercice_by_entreprise";
    private static final String UNIQUE_CONSTRAINT_NOM_PRENOM = "unique_nom_prenom_for_acteur";
    private static final String UNIQUE_CONSTRAINT_EMAIL = "unique_e_mail_for_acteur";

    private final Map<String, String> mapErrors = Maps.newHashMap();

    @PostgreSqlVendor
    @Autowired
    protected VendorDbExceptionHandler vendorDbExceptionHandler;

    @PostConstruct
    public void init() {
        mapErrors.put(UNIQUE_PIECE_BY_EXERCICE, "Vous avez déjà une écriture avec la même piece");
        mapErrors.put(UNIQUE_MVT_BY_EXERCICE, "Il y a déjà une écriture avec même mouvement, merci de contacter l'administrateur");
        mapErrors.put(UNIQUE_PIECE_BY_EXERCICE_IN_PIECE_COMPTABLE, "Vous avez déjà une pièce avec même identifiant");
        mapErrors.put(ECRITURE_MOUVEMENT_MUST_NOT_BE_ZERO, "Mouvement écriture doit être supérieur au zéro");
        mapErrors.put(UNIQUE_CONSTRAINT_CODE_EXERCICE_ENTREPRISE, "Vous avez déjà un exercice avec le mode code");
        mapErrors.put(UNIQUE_CONSTRAINT_NOM_PRENOM, "Il y a déjà un utilisateur avec les mêmes nom et prenom");
        mapErrors.put(UNIQUE_CONSTRAINT_EMAIL, "Il y a déjà un utilisateur qui a le même E-MAIL");
    }

    public String buildFunctionalDataBaseExeption(Throwable ex) {
        String error = vendorDbExceptionHandler.getTypeException(ex, mapErrors);
        return (error != null ? mapErrors.get(error) : null);
    }

}
