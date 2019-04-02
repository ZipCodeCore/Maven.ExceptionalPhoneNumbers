package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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
        PhoneNumber[] phoneNumbers = new PhoneNumber[phoneNumberCount];

        for (int i = 0; i < phoneNumberCount; i++) {
            phoneNumbers[i] = createRandomPhoneNumber();
        }

        return phoneNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {

        Integer areaCode = RandomNumberFactory.createInteger(101, 999);
        Integer centralOfficeCode = RandomNumberFactory.createInteger(101, 999);
        Integer phoneLineCode = RandomNumberFactory.createInteger(1001, 9999);

        return createPhoneNumberSafely(areaCode,centralOfficeCode,phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null (DONE)
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {

        PhoneNumber phoneNumber = null;
        try {
            phoneNumber = createPhoneNumber(String.format("(%s)-%s-%s",areaCode,centralOfficeCode,phoneLineCode));
        } catch (InvalidPhoneNumberFormatException e) {
            e.printStackTrace();
        }
        return phoneNumber;
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature (DONE)
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {

        logger.log(Level.INFO,String.format("Attempting to create a new PhoneNumber object with a value of %s",
                phoneNumberString) );
        return new PhoneNumber(phoneNumberString);
    }


    public static void main(String[] args) {

        createRandomPhoneNumber();
        createRandomPhoneNumber();

    }
}
