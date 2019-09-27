package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;

/**
 * Created by leon on 5/10/17.
 */
public final class PhoneNumber {
    private final String phoneNumberString;

    // default constructor is uncallable
    private PhoneNumber() throws InvalidPhoneNumberFormatException {
        this(null);
    }

    // non-default constructor is package-protected
    protected PhoneNumber(String phoneNumber) throws InvalidPhoneNumberFormatException {
        //validate phone number with format `(###)-###-####`
        if (!phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            throw new InvalidPhoneNumberFormatException();
        }
        this.phoneNumberString = phoneNumber;
    }

    public String getAreaCode() {
        try {
            return toString().substring(1, 4);
        } catch (NullPointerException npe) {
            return null;
        }
    }

    public String getCentralOfficeCode() {
        try {
            return toString().substring(6, 9);
        } catch (NullPointerException npe) {
            return null;
        }
    }

    public String getPhoneLineCode() {
        try {
            return toString().substring(10, 14);
        } catch (NullPointerException npe) {
            return null;
        }
}

    @Override
    public String toString() {
        return phoneNumberString;
    }
}
