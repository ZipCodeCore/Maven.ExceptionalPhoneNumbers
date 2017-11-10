package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.logging.*;
import java.util.*;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] phoneNumArray = new PhoneNumber[phoneNumberCount];
        for(int i=0; i<phoneNumberCount;i++){
            phoneNumArray[i]=createRandomPhoneNumber();
        }
        return phoneNumArray;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    private static PhoneNumber createRandomPhoneNumber() {
        int threeDigit = RandomNumberFactory.createInteger(100,999);
        int fourDigit = RandomNumberFactory.createInteger(1000,9999);
        return createPhoneNumberSafely(threeDigit, threeDigit, fourDigit);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode){
        String phoneNum = "(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode;
        try {
            return createPhoneNumber(phoneNum);
        } catch (InvalidPhoneNumberFormatException e) {
            String message = String.format("%s is not a valid phone number", phoneNum);
            logger.log(Level.WARNING,message);
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        PhoneNumber phoneNum = new PhoneNumber(phoneNumberString);
        String message = String.format("Attempting to create a new PhoneNumber object with a value of %s", phoneNum);
        logger.log(Level.WARNING, message);
        return phoneNum;
    }
}
