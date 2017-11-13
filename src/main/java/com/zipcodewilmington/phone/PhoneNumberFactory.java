package com.zipcodewilmington.phone;

import com.sun.javafx.binding.StringFormatter;
import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.text.Format;
import java.util.Formatter;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory extends RandomNumberFactory{
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
        for(int i = 0; i < phoneNumbers.length; i++)
            phoneNumbers[i] = createRandomPhoneNumber();
        return phoneNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    private static PhoneNumber createRandomPhoneNumber() {

        int threeNums = RandomNumberFactory.createInteger(100, 999);
        int fourNums = RandomNumberFactory.createInteger(1000, 9999);

        return createPhoneNumberSafely(threeNums, threeNums, fourNums);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        PhoneNumber phoneNumber;
        String formattedNumberString = "(" + areaCode + ")-" +centralOfficeCode + "-" + phoneLineCode;
        try {
            phoneNumber = createPhoneNumber(formattedNumberString);
        }
        catch(InvalidPhoneNumberFormatException e) {
            logger.log(Level.INFO, formattedNumberString + "is not a valid phone number");
            phoneNumber = null;
            e.printStackTrace();
        }
        return phoneNumber;
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber (String phoneNumberString) throws InvalidPhoneNumberFormatException {
        PhoneNumber phoneNumber = null;
        Logger logger = Logger.getLogger("com.zipcodewilmington.phone");
        try {
            phoneNumber = new PhoneNumber(phoneNumberString);
            logger.log(Level.INFO, "Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);
        }
        catch(InvalidPhoneNumberFormatException e) {
            e.printStackTrace();
        }
        return phoneNumber;
    }

    public String generateRandomInts(int n) {
        IntSupplier numbers = () -> RandomNumberFactory.createInteger(0, 9);
        return IntStream.generate(numbers).limit(n).toString();
    }

}
