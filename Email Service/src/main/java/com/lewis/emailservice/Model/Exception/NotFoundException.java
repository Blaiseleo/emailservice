package com.lewis.emailservice.Model.Exception;

/**
 * Created by Lewis.Aguh on 10/08/2019
 */

public class NotFoundException extends AbstractException {
    private static final long serialVersionUID = 1L;
    public NotFoundException(String code, String message) {
        super(code, message);
    }
}

