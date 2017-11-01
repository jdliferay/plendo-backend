package com.maintacloud.web.controller;



import com.maintacloud.domain.enumeration.support.EnumAppModules;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by issam on 16/11/2016.
 */
@RestController
@RequestMapping(value = "/service/enums")
public class EnumsController {

    @RequestMapping(value = "/enumAppModules", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<EnumAppModules> getEnumAppModules()  {
        return EnumUtils.getEnumList(EnumAppModules.class);
    }

}
