package VendingMachine.DTO;

import java.math.BigDecimal;
import java.util.Objects;

public class VendingMachine {
    private final String itemName;
    private BigDecimal Price;
    private int quantity;

    public VendingMachine(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VendingMachine)) return false;
        VendingMachine that = (VendingMachine) o;
        return getQuantity() == that.getQuantity() && Objects.equals(getItemName(), that.getItemName()) && Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemName(), getPrice(), getQuantity());
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
                "itemName='" + itemName + '\'' +
                ", Price=" + Price +
                ", quantity=" + quantity +
                '}';
    }
}
