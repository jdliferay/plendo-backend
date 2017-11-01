package com.maintacloud.service.dataaccess.impl;


import com.maintacloud.service.exception.DataBaseExeptionHandlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractDataAccessBean {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DataBaseExeptionHandlerService dataBaseExeptionHandlerService;

}
