package com.upschool.senamatrac.homework5.exception;

public class SystemNotWorkingException extends Exception{

    private int randomCause;
    public SystemNotWorkingException(String message, int randomCause) {
        super(message);
        this.randomCause = randomCause;
    }

    public int getRandomCause() {
        return randomCause;
    }
}
