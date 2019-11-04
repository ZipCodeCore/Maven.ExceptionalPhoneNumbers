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

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount)
    {
        PhoneNumber[] numbers = new PhoneNumber[phoneNumberCount];

        for (int i = 0; i < phoneNumberCount; i++) {

            numbers[i] = createRandomPhoneNumber();

        }
        return numbers;
    }
    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {

        Random randomNum = new Random();

        int areaCode = 100 + randomNum.nextInt(900);
        int centOfficeCode = 100 + randomNum.nextInt(900);
        int phoneLineCode = 1000 + randomNum.nextInt(9000);

        return createPhoneNumberSafely(areaCode, centOfficeCode, phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        // string representation of the phone#
        StringBuilder phoneNumberString = new StringBuilder (String.format("(%s)-%s-%s",areaCode, centralOfficeCode, phoneLineCode));
        try {

            return createPhoneNumber(phoneNumberString.toString());
        }
        catch (InvalidPhoneNumberFormatException i )
        {
            logger.log(Level.WARNING, phoneNumberString + " is not a valid phone number. ");
            return null;
        }

    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException
    {
        logger.log(Level.INFO, "Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);

        return new PhoneNumber(phoneNumberString);
    }

}
