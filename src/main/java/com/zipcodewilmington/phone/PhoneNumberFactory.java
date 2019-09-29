package com.zipcodewilmington.phone;

import com.sun.javafx.binding.StringFormatter;
import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

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
        PhoneNumber[] number = new PhoneNumber[phoneNumberCount];
        for (int i = 0; i < number.length; i++) {
            number[i] = createRandomPhoneNumber();
        }
        return number;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {

        int areaCode = RandomNumberFactory.createInteger(100, 999);
        int centralOfficeCode = RandomNumberFactory.createInteger(100, 999);
        int phoneLine = RandomNumberFactory.createInteger(1000, 9999);

        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLine);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        //StringFormatter.format(%2)

        StringBuilder sb = new StringBuilder();
    //        sb.append("(");
    //        sb.append(String.format("%02d", areaCode));
    //        sb.append(")");
    //        sb.append("-");
    //        sb.append(String.format("%02d", centralOfficeCode));
    //        sb.append("-");
    //        sb.append(String.format("%03d", phoneLineCode));

           sb.append("(" + areaCode + ")" + "-" + centralOfficeCode + "-" + phoneLineCode);
        String s = sb.toString();
        try {
            return createPhoneNumber(s);
        } catch (InvalidPhoneNumberFormatException e) {
            logger.info("invalid phoneNumber");

        }

        return null;
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberString);
        return phoneNumber;
    }
}
