package com.maintacloud.service.dataaccess.api.plendo;

import com.maintacloud.domain.configurationglobal.Entreprise;

import java.util.List;

/**
 * Created by nxuser on 04/12/2016.
 */
public interface IPlendoDataAccessService {

    void saveEntreprise(Entreprise entreprise);
    Entreprise findEntrepriseById(Long entrepriseId);
    //List<Entreprise> findAllEntreprises();

  
}