package com.maintacloud.web.controller.plendo;


import com.maintacloud.service.dataaccess.api.plendo.IPlendoDataAccessService;
import com.maintacloud.web.controller.BaseController;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nxuser on 04/12/2016.
 */
@RestController
@RequestMapping(value = "/service/plendo")
public class PlendoController extends BaseController
{
    @Inject
    private IPlendoDataAccessService plendoDataAccessService;




}
