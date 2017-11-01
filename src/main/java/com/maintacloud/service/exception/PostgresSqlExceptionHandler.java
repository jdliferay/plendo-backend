package com.maintacloud.service.exception;

import com.maintacloud.socle.annotation.PostgreSqlVendor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by issam on 13/01/2016.
 */

@PostgreSqlVendor
public class PostgresSqlExceptionHandler implements VendorDbExceptionHandler {


    public static final String UNIQUE_VIOLATION_CODE = "23505";
    public static final String CHECK_VIOLATION_CODE = "23514";


    @Override
    public String handleException(Exception e) {
        return null;
    }

    @Override
    public String getTypeException(Throwable e, Map<String, String> mapErrors) {
        Throwable rootCause = ExceptionUtils.getRootCause(e);

        if (rootCause instanceof SQLException &&
                (StringUtils.equals(((SQLException) rootCause).getSQLState(), UNIQUE_VIOLATION_CODE)
                || StringUtils.equals(((SQLException) rootCause).getSQLState(), CHECK_VIOLATION_CODE))) {// todo check violations in list
            SQLException sqlException = (SQLException) rootCause;
            for (String error : mapErrors.keySet()) {
                if (sqlException.getMessage().contains(error)) {
                    return error;
                }
            }
        }
        return null;
    }

}
