package com.upschool.senamatrac.homework5.service;

import com.upschool.senamatrac.homework5.exception.InvalidAmountException;
import com.upschool.senamatrac.homework5.exception.InvalidCCVException;
import com.upschool.senamatrac.homework5.exception.InvalidCartNumberException;
import com.upschool.senamatrac.homework5.exception.InvalidDateException;

public class CartValidationService {

    public static void isValidateCartNumber(String cartNumber) throws InvalidCartNumberException {
        boolean isValid = cartNumber.length() == 16 && isDigitInt(cartNumber);
        if (!isValid){
            throw new InvalidCartNumberException("Hatalı cart numarası girdiniz. 16 karakter olmalı ve yalnızca rakam içermeli.");
        }
    }
    public static void isValidateDate(String date) throws InvalidDateException {
        String[] dateSplit = date.split("/");
        boolean isValid = true;
        if (dateSplit.length != 2) {
            isValid = false;
        } else {
            String stringMonth = dateSplit[0];
            String stringYear = dateSplit[1];
            if (!isDigitInt(stringYear) || stringYear.length() != 4 || Integer.parseInt(stringYear)<2013){
                isValid = false;
            }
            if (isDigitInt(stringMonth)){
                int month = Integer.parseInt(stringMonth);
                if (month > 12 || month < 1) {
                    isValid = false;
                }
            }
        }
        if (!isValid) {
            throw new InvalidDateException("Geçersiz tarih girdiniz.AY/YIL şeklinde giriniz.");
        }
    }

    public static void isValidateCCV(String ccv) throws InvalidCCVException {
        boolean isValid = ccv.length() == 3 && isDigitInt(ccv);
        if (!isValid){
            throw new InvalidCCVException("Hatalı ccv girdiniz.3 haneli ve rakamlardan oluşmalı.");
        }
    }

    private static boolean isDigitInt(String input){
        for (int i = 0; i < input.length() ;i++){
            if (!Character.isDigit(input.charAt(i)))
                return false;
        }
        return true;
    }
}
