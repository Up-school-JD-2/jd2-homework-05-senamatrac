package com.upschool.senamatrac.homework5.service;

import com.upschool.senamatrac.homework5.data.CreditCart;
import com.upschool.senamatrac.homework5.exception.InvalidAmountException;
import com.upschool.senamatrac.homework5.exception.SystemNotWorkingException;

public class ShoppingService {

    public static void isValidateAmountFormat(String amount) throws InvalidAmountException {
        boolean isValid = !amount.contains(",") && !amount.contains("-") ;
        if (isValid && amount.contains(".")) {
            String[] amountSplit = amount.split("\\.");
            for (String part : amountSplit) {
                if (!isDigitInt(part)){
                    isValid = false;
                    break;
                }
            }
        }
        if (!isValid)
            throw new InvalidAmountException("Hatalı fiyat girdiniz. Yalnızca . ayıracını kullanınız.");
    }

    public static void pay(double amount, CreditCart cart) throws SystemNotWorkingException {
        int random = (int) (Math.random() * 100);
        if (random > 75) {
            throw new SystemNotWorkingException("Sistem çalışmıyor.", random);
        }
    }

    private static boolean isDigitInt(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)))
                return false;
        }
        return true;
    }
}
