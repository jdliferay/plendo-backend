package com.maintacloud.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;


public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected ApplicationEventPublisher publisher;



}