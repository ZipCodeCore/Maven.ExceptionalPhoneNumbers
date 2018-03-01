package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory extends IOException {
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
    PhoneNumber[] phoneNumbers = new PhoneNumber[phoneNumberCount];
    for (int i = 0; i < phoneNumberCount; i++){
        phoneNumbers[i] = createRandomPhoneNumber();
    } // populate phone number [] with for loop and then insert random numbers into the array
        return phoneNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        int ac = RandomNumberFactory.createInteger(100, 999);
        int coc = RandomNumberFactory.createInteger(100, 999);
        int plc = RandomNumberFactory.createInteger(1000, 9999);
        return createPhoneNumberSafely(ac, coc, plc);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String newNum = "(" + Integer.toString(areaCode) + ")" + "-" + Integer.toString(centralOfficeCode) + "-" + Integer.toString(phoneLineCode);
        try {
            return createPhoneNumber(newNum);
        } catch (InvalidPhoneNumberFormatException e) {
            String str = (newNum + " is not a valid phone number");
            logger.log(Level.ALL, str);
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
       String str = ("Attempting to create a new PhoneNumber object with the value of" + phoneNumberString);
        logger.log(Level.ALL, str);
        return new PhoneNumber(phoneNumberString);
    }
}
