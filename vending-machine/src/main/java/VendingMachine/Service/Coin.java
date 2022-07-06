package VendingMachine.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Coin {
    FiftyP(new BigDecimal("0.50")), TwentyFiveP(new BigDecimal("0.25")), TenP(new BigDecimal("0.10")), pennies(new BigDecimal("0.01"));

    private final BigDecimal current;

    Coin(BigDecimal Current) {
        this.current = Current;
    }

    public static String change(BigDecimal Money, BigDecimal ItemPrice) throws VendingInsufficientFundsException {
        StringBuilder Change;
        BigDecimal changeValue = Money.subtract(ItemPrice);
        if (changeValue.doubleValue() < 0) {
            throw new VendingInsufficientFundsException("You have not entered enough money you have £" + Money + " But this item costs £" + ItemPrice + " so have your money back");
        } else if (changeValue.equals(BigDecimal.valueOf(0.0))) {
            return ("There is no change to be given");
        }
        Change = new StringBuilder("Here is your change :");
        for (Coin coin : Coin.values()) {
            if (changeValue.compareTo(coin.current) >= 0) {
                int amount = changeValue.divide(coin.current, RoundingMode.HALF_UP).intValue();
                Change.append(" " + amount + " :" + coin.current + "p");
                changeValue = changeValue.subtract(coin.current.multiply(new BigDecimal(amount)));
            }
        }
        return Change.toString();
    }
}