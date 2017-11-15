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



    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount)
    {
        PhoneNumber[] phoneNumberArray = new PhoneNumber[phoneNumberCount];
        for(int i = 0; i< phoneNumberCount; i++){
           phoneNumberArray[i] = createRandomPhoneNumber();
        }

        return phoneNumberArray;
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

        String number = String.format("(%d)-%d-%d", areaCode, centralOfficeCode, phoneLineCode);
PhoneNumber newNum = null;

        try {
            newNum = PhoneNumberFactory.createPhoneNumber(number);

            } catch(InvalidPhoneNumberFormatException invalidpnfe) {
            logger.log(Level.FINE, number + " is not a valid phone number");
            invalidpnfe.printStackTrace();
        }
        return newNum;

    }




    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature




    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {

        logger.log(Level.INFO, "Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);

        return new PhoneNumber (phoneNumberString);


    }
}
