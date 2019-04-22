package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.Random;
import java.util.logging.Logger;

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
        PhoneNumber[] newPhoneNumbers = new PhoneNumber[phoneNumberCount];
        for (int i =0; i <phoneNumberCount;i++){
            createRandomPhoneNumber();
        }
        return newPhoneNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
       // return createPhoneNumberSafely(-1, -1, -1);
        int newCodeNumber = RandomNumberFactory.createInteger(200,555);
        int newCentralNum = RandomNumberFactory.createInteger(200,555);
        int newLine = RandomNumberFactory.createInteger(2000,5555);
        return createPhoneNumberSafely(newCodeNumber,newCentralNum,newLine);


    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String newNumber = "("+ areaCode +")-" + centralOfficeCode + "-" + phoneLineCode;
        try {
            System.out.println(newNumber);
            return createPhoneNumber(newNumber);
        } catch(InvalidPhoneNumberFormatException){
            return createPhoneNumber(null);
        }

    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) {
        return new PhoneNumber(phoneNumberString);
    }
}
