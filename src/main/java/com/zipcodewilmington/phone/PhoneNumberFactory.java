package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.logging.Level;
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
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) throws InvalidPhoneNumberFormatException{
        PhoneNumber[] phoneNumbers = new PhoneNumber[phoneNumberCount];
        for (int i = 0; i < phoneNumberCount; i++) {
            phoneNumbers[i] = createRandomPhoneNumber();
        }
        return phoneNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() throws InvalidPhoneNumberFormatException {
        try {
            int areaCode = RandomNumberFactory.createInteger(100, 999);
            int officeCode = RandomNumberFactory.createInteger(100, 999);
            int phoneLine = RandomNumberFactory.createInteger(1000, 9999);
            return createPhoneNumberSafely(areaCode, officeCode, phoneLine);
        } catch (InvalidPhoneNumberFormatException e) {return null;}
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) throws InvalidPhoneNumberFormatException{
        String tempString = "";
        try {
            // if (3 == String.valueOf(areaCode).length() && 3 == String.valueOf(centralOfficeCode).length() && 4 == String.valueOf(phoneLineCode).length()) {
            tempString = String.valueOf(areaCode) + String.valueOf(centralOfficeCode) + String.valueOf(phoneLineCode);
            return createPhoneNumber(tempString);
            //     return createPhoneNumber(tempString);
            // }
        } catch (InvalidPhoneNumberFormatException inv) {
            logger.log(Level.FINE, (tempString + "is not a valid phone number"));
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber (String phoneNumberString) throws InvalidPhoneNumberFormatException {
        logger.log(Level.FINE, ("Attempting to create a new PhoneNumber object with a value of " + phoneNumberString));
        return new PhoneNumber(phoneNumberString);
    }
}
