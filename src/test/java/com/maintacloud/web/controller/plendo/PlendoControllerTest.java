package com.maintacloud.web.controller.plendo;


import com.maintacloud.MaintaCloudApp;
import com.maintacloud.domain.configurationglobal.Entreprise;
import com.maintacloud.service.dataaccess.api.plendo.IPlendoDataAccessService;
import com.maintacloud.web.controller.plendo.PlendoController;
import com.maintacloud.web.controller.common.AbstractControllerTest;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by nxuser on 05/12/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MaintaCloudApp.class)
@Transactional
public class PlendoControllerTest extends AbstractControllerTest
{
    @Inject
    private IPlendoDataAccessService plendoDataAccessService;

    @Inject
    private PlendoController plendoController;


    @Before
    public void setUp()
    {
        this.mockMvc = MockMvcBuilders.standaloneSetup(plendoController).build();

        Entreprise entreprise = new Entreprise();
        plendoDataAccessService.saveEntreprise(entreprise);
    }


}