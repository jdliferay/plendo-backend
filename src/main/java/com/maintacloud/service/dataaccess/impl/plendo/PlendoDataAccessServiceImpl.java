package com.maintacloud.service.dataaccess.impl.plendo;

import com.maintacloud.domain.configurationglobal.Entreprise;
import com.maintacloud.repository.api.plendo.EntrepriseRepository;
import com.maintacloud.service.dataaccess.api.plendo.IPlendoDataAccessService;
import com.maintacloud.service.dataaccess.impl.AbstractDataAccessBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by nxuser on 04/12/2016.
 */
@Service
@Transactional
public class PlendoDataAccessServiceImpl extends AbstractDataAccessBean implements IPlendoDataAccessService {

    @Inject
    private EntrepriseRepository entrepriseRepository;

    @Override
    public void saveEntreprise(Entreprise entreprise) {
        entrepriseRepository.save(entreprise);
    }

    @Override
    public Entreprise findEntrepriseById(Long entrepriseId) {
        return entrepriseRepository.findOne(entrepriseId);
    }
}