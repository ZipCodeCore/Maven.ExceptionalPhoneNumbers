package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.stream.Stream;

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
        return Stream.generate(PhoneNumberFactory::createRandomPhoneNumber).limit(phoneNumberCount).toArray(PhoneNumber[]::new);
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    private static PhoneNumber createRandomPhoneNumber(){
        int randomAreaCode = RandomNumberFactory.createInteger(100,999);
        int randomCentralOfficeCode = RandomNumberFactory.createInteger(100,999);
        int randomPhoneLineCode = RandomNumberFactory.createInteger(1000,9999);

        return createPhoneNumberSafely(randomAreaCode, randomCentralOfficeCode, randomPhoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode){
        PhoneNumber newPhoneNumber = null;
        try{
            newPhoneNumber = createPhoneNumber(String.format("("+areaCode+")-"+centralOfficeCode+"-"+phoneLineCode));
        } catch (InvalidPhoneNumberFormatException e) {
            logger.info(newPhoneNumber+" is not a valid phone number");
        }
        return newPhoneNumber;
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException{
        logger.info("Attempting to create a new PhoneNumber object with a value of "+phoneNumberString);
        return new PhoneNumber(phoneNumberString);
    }
}
