package com.alefagundes.tcc2.domain.exceptions;

public class UserExistsException extends NegocioException{

    public UserExistsException(String msg){
        super(msg);
    }
    
}
