package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();
    //private static final ConsoleHandler consoleHandler = new ConsoleHandler();

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
//        PhoneNumber phoneNumberArray[] = new PhoneNumber[phoneNumberCount];
//        for (int i = 0; i < phoneNumberCount; i++) {
//            PhoneNumber phoneNumber = createRandomPhoneNumber();
//            phoneNumberArray[i] = phoneNumber;
//        }
//        return phoneNumberArray;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    private static PhoneNumber createRandomPhoneNumber() {
        Integer areaCode = RandomNumberFactory.createInteger(100, 999);
        Integer centralOfficeCode = RandomNumberFactory.createInteger(100, 999);
        Integer phoneLineCode = RandomNumberFactory.createInteger(1000, 9999);
        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String phoneNumber = "(" + areaCode + ")" + "-" + centralOfficeCode + "-" + phoneLineCode;

        PhoneNumber phoneNumberSafe = null;
        try {
            phoneNumberSafe = createPhoneNumber(phoneNumber);
        } catch (InvalidPhoneNumberFormatException e) {
            logger.info(phoneNumber + " is not a valid phone number.");
            // don't have to do anything because it is already null.
        }
        return phoneNumberSafe;
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException{
        logger.info("Attempting to create a new PhoneNumber object wih a value of " + phoneNumberString);
        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberString);
        return phoneNumber;
    }
}
