package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;

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
        PhoneNumber[] ret = new PhoneNumber[phoneNumberCount];
        for (int i=0;i<ret.length;i++)
            ret[i] = createRandomPhoneNumber();
        return ret;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        return createPhoneNumberSafely(randAreaOrOfficeCode(), randAreaOrOfficeCode(), randLineCode());
    }

    static int randAreaOrOfficeCode() {
        return genRandomSequence(3);
    }

    static int randLineCode() {
        return genRandomSequence(4);
    }

    static int genRandomSequence(int howManyDigits) {
        Random r = new Random();
        int sum = 0;
        for (int i=0;i<howManyDigits;i++)
            sum += r.nextInt(10) * Math.pow(10, i);
        return sum;
    }

    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String phoneNumberString = String.format("(%03d)-%03d-%04d", areaCode, centralOfficeCode, phoneLineCode);
        try {
            logger.info("Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);
            return createPhoneNumber(phoneNumberString);
        } catch (InvalidPhoneNumberFormatException ipne) {
            logger.info(phoneNumberString + "  is not a valid phone number");
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException{
        return new PhoneNumber(phoneNumberString);
    }
}
