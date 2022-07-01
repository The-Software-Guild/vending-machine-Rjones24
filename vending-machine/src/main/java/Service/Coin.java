package Service;

import java.math.BigDecimal;

public enum Coin {
    FiftyP, TwentyFiveP, TenP, pennies;


    public static BigDecimal change(Coin type) {
        return switch (type) {
            case FiftyP -> new BigDecimal(0.5);
            case TwentyFiveP -> new BigDecimal(0.25);
            case TenP -> new BigDecimal(0.1);
            case pennies -> new BigDecimal(0.01);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}