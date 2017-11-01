package com.maintacloud.service.exception;

import com.maintacloud.service.dataaccess.impl.plendo.AbstractComptaException;

/**
 * Created by issam on 01/12/2016.
 */
public class ComptaException  extends AbstractComptaException {

    public ComptaException(String code, String message) {
        super(code, message);
    }

}
