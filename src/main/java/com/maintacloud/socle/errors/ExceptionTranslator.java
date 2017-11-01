package com.maintacloud.socle.errors;

import com.maintacloud.service.dataaccess.impl.plendo.AbstractComptaException;
import com.maintacloud.service.exception.ComptaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Controller advice to translate the server side exceptions to client-friendly json structures.
 */
@ControllerAdvice
public class ExceptionTranslator extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ResponseEntity<Object> processAccessDeniedException(AccessDeniedException e, WebRequest request) {
       // TODO send mail CRITIQUE
        return null;
    }

    @ExceptionHandler({ComptaException.class, Exception.class})
    protected ResponseEntity<Object> handleInvalidRequest(Exception exception, WebRequest request) {
        AbstractComptaException abstractComptaException;
        if (exception instanceof AbstractComptaException) { // already catched and treated
            abstractComptaException = (AbstractComptaException) exception;
        } else {
            logger.fatal("not catched error", exception);
            if (exception instanceof org.springframework.transaction.UnexpectedRollbackException) { // catch rollback only global exception od Data Access// todo delete after using afterThrowing
                abstractComptaException = new ComptaException("code", "Erreur de traitement");
            } else {
                abstractComptaException = new ComptaException("code", "Erreur de traitement");
            }
        }
        return sendErrors(request, abstractComptaException);
    }

    private ResponseEntity<Object> sendErrors(WebRequest request, AbstractComptaException abstractComptaException) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ErrorMapper error = new ErrorMapper(abstractComptaException.getCode(), abstractComptaException.getMessage());
        return handleExceptionInternal(abstractComptaException, error, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
