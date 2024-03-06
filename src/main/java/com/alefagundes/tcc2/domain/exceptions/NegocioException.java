package com.alefagundes.tcc2.domain.exceptions;

public class NegocioException extends RuntimeException {

    public NegocioException(String msg) {
        super(msg);
    }

    public NegocioException(String msg, Throwable causa){
        super(msg, causa);
    }
    
}
