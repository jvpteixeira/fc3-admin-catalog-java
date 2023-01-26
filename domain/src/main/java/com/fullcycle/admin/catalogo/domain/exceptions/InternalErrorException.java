package com.fullcycle.admin.catalogo.domain.exceptions;

import com.fullcycle.admin.catalogo.domain.validation.Error;

import java.util.List;

public class InternalErrorException extends NoStacktraceException {

    protected InternalErrorException(final String aMessage, final Throwable t) {
        super(aMessage,t);
    }

    public static InternalErrorException with(final String aMessage, final Throwable t) {
        return new InternalErrorException(aMessage, t);
    }

}
