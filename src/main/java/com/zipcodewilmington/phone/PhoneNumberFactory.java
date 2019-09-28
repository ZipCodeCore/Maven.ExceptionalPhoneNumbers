package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

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
        PhoneNumber[] allPhoneNumbers = new PhoneNumber[phoneNumberCount];//create empty array to store my random phone number count
        for (int i = 0; i < phoneNumberCount; i++) {//loop through our array to count how many phone numbers are in the array
            allPhoneNumbers[i] = createRandomPhoneNumber();//set allPhoneNumbers to the ith index for this method
        }

        return allPhoneNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        int areaCode = RandomNumberFactory.createInteger(100,999); //using the given random number generator method and
        int centralOfficeCode = RandomNumberFactory.createInteger(100,999);//setting both COC & PLC with ranges from 100 - 999
        int phoneLineCode = RandomNumberFactory.createInteger(1000,9999);//same as above but higher range
        logger.config("");
        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);//return my variable in desired format using previous method
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String myNumber = "(" + Integer.toString(areaCode) + ")" + "-" + Integer.toString(centralOfficeCode) + "-" + Integer.toString(phoneLineCode); //myNumber string object being casted from integers to strings in order to return the correct format corresponding to the method call
        try {   //try returning myNumber object using the method createPhoneNumber
            return createPhoneNumber(myNumber);
        } catch (InvalidPhoneNumberFormatException e) { //catch the thrown exception if it can't be handled then return null and log that the input on the stack trace is invalid and return null
            //e means "exception"
            //line 41 will generate and throw an exception due to createPhoneNumber method being called and should be surrounded by a 'try' 'catch'
            logger.config("Input is invalid");
        }
        return null;
    }



    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString)throws InvalidPhoneNumberFormatException {
        return new PhoneNumber(phoneNumberString);
    }
}
