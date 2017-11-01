package com.maintacloud.service.exception;

import java.util.Map;

/**
 * Created by issam on 13/01/2016.
 */
public interface VendorDbExceptionHandler {

    String handleException(Exception e);

    String getTypeException(Throwable e, Map<String, String> mapErrors);

}
