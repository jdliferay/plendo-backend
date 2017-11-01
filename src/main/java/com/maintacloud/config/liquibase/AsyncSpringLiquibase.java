package com.maintacloud.config.liquibase;

import com.maintacloud.config.Constants;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.core.task.TaskExecutor;
import org.springframework.util.StopWatch;

import javax.inject.Inject;

/**
 * Specific liquibase.integration.spring.SpringLiquibase that will update the database asynchronously.
 * <p>
 * By default, this asynchronous version only works when using the "dev" profile.<p>
 * The standard liquibase.integration.spring.SpringLiquibase starts Liquibase in the current thread:
 * <ul>
 * <li>This is needed if you want to do some database requests at startup</li>
 * <li>This ensure that the database is ready when the application starts</li>
 * </ul>
 * But as this is a rather slow process, we use this asynchronous version to speed up our start-up time:
 * <ul>
 * <li>On a recent MacBook Pro, start-up time is down from 14 seconds to 8 seconds</li>
 * <li>In production, this can help your application run on platforms like Heroku, where it must start/restart very quickly</li>
 * </ul>
 */
public class AsyncSpringLiquibase extends SpringLiquibase {

    // named "logger" because there is already a field called "log" in "SpringLiquibase"
    private final Logger logger = LoggerFactory.getLogger(AsyncSpringLiquibase.class);

    @Inject
    @Qualifier("taskExecutor")
    private TaskExecutor taskExecutor;

    @Inject
    private Environment env;

    @Override
    public void afterPropertiesSet() throws LiquibaseException {
        if (!env.acceptsProfiles(Constants.SPRING_PROFILE_NO_LIQUIBASE)) {
            logger.debug("Starting Liquibase synchronously");
            initDb();
        } else {
            logger.debug("Liquibase is disabled");
        }
    }

    protected void initDb() throws LiquibaseException {
        StopWatch watch = new StopWatch();
        watch.start();
        super.afterPropertiesSet();
        watch.stop();
        logger.debug("Started Liquibase in {} ms", watch.getTotalTimeMillis());
    }
}
