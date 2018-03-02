package com.zipcodewilmington.exceptions;

/**
 * Created by leon on 5/10/17.
 */ // Checked Exception
public final class InvalidPhoneNumberFormatException extends Exception {
    public InvalidPhoneNumberFormatException(){
        super();
    }

    public InvalidPhoneNumberFormatException(String message){
        super(message);
    }
}
