package com.alefagundes.tcc2.domain.exceptions;

public class UserNotExistsException extends NegocioException{

    public UserNotExistsException(String msg){
        super(msg);
    }
}
