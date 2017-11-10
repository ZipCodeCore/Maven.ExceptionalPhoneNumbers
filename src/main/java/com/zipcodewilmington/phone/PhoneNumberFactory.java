package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();
    private static final Logger createPhoneNumberLogger = Logger.getLogger("com.zipcodewilmington.phone");
    private static final Logger createPhoneNumberSafelyLogger = Logger.getLogger("com.zipcodewilmington.phone");


    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] phoneNumberArray = new PhoneNumber[phoneNumberCount];

        for (int i=0; i<phoneNumberCount; i++)
        {
            phoneNumberArray[i]=createRandomPhoneNumber();
        }

        return phoneNumberArray;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    private static PhoneNumber createRandomPhoneNumber() {

        Random rng=new Random();
        int areaCode=100;
        int centralOfficeCode=100;
        int phoneLineCode=1000;

        areaCode+=rng.nextInt(900);
        centralOfficeCode+=rng.nextInt(900);
        phoneLineCode+=rng.nextInt(9000);


        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        try {
            String phoneNumberString = "(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode;
            createPhoneNumberSafelyLogger.log(Level.WARNING, phoneNumberString+ " is not a valid number.");
            return createPhoneNumber(phoneNumberString);
        }catch (InvalidPhoneNumberFormatException ipnfe){
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException{
        createPhoneNumberLogger.log(Level.WARNING, "Attempting to create a new PhoneNumber object with a value of "+phoneNumberString);

        PhoneNumber ph = new PhoneNumber(phoneNumberString);
        return (ph);
    }
}
