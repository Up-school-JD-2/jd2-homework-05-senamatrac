package com.upschool.senamatrac.homework5.data;

public class CreditCart{
    private final String cartNumber;

    private String lastValidDate;

    private String ccvCode;

    private final User owner;
    public CreditCart(String cartNumber, String lastValidDate, String ccvCode, User owner) {
        this.cartNumber = cartNumber;
        this.lastValidDate = lastValidDate;
        this.ccvCode = ccvCode;
        this.owner = owner;
    }

    //region GETTER_SETTER
    public String getCartNumber() {
        return cartNumber;
    }

    public String getLastValidDate() {
        return lastValidDate;
    }

    public void setLastValidDate(String lastValidDate) {
        this.lastValidDate = lastValidDate;
    }

    public String getCcvCode() {
        return ccvCode;
    }

    public void setCcvCode(String ccvCode) {
        this.ccvCode = ccvCode;
    }

    public User getOwner() {
        return owner;
    }
    //endregion
}
