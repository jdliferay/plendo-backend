package com.maintacloud.service.dataaccess.impl.plendo;

import com.maintacloud.MaintaCloudApp;
import com.maintacloud.domain.configurationglobal.Entreprise;
import com.maintacloud.service.dataaccess.api.plendo.IPlendoDataAccessService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by nxuser on 04/12/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MaintaCloudApp.class)
@Transactional
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PlendoDataAccessServiceImplTest {
    @Inject
    private IPlendoDataAccessService plendoDataAccessService;


    @Test
    public void test_saveEntreprise() {
        Entreprise entreprise = new Entreprise();
        entreprise.setActivite("Céramique");
        entreprise.setAdresse("1 Avenue de l'Europe 75001 PARIS");
        entreprise.setArrondi(true);
        plendoDataAccessService.saveEntreprise(entreprise);
        plendoDataAccessService.findEntrepriseById(Long.valueOf(1));

        Assert.assertTrue(plendoDataAccessService.findEntrepriseById(Long.valueOf(1)) != null);
        Assert.assertTrue(plendoDataAccessService.findEntrepriseById(Long.valueOf(1)).getEntrepriseId().intValue() == 1);
        Assert.assertEquals("Céramique", plendoDataAccessService.findEntrepriseById(Long.valueOf(1)).getActivite());
        Assert.assertEquals("1 Avenue de l'Europe 75001 PARIS", plendoDataAccessService.findEntrepriseById(Long.valueOf(1)).getAdresse());
        Assert.assertNotEquals("1Avenue de l'Europe 75001 PARIS", plendoDataAccessService.findEntrepriseById(Long.valueOf(1)).getAdresse());
    }

}
