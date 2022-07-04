package UI;

import DTO.VendingMachine;

import java.math.BigDecimal;
import java.util.List;

public class VendingView {
    private final UserIO io;

    public VendingView(UserIO io) {
        this.io = io;
    }

    public int PrintVendingDisplay(List<VendingMachine> inventory){
        io.print("#######Vending Machine#######");
        io.print("Hey you look like you could do with some food and drink");
        io.print("here is what i have to offer :)");

        for(VendingMachine currentInventory: inventory){
            if(currentInventory.getQuantity()>0) {
                String vendingInfo = String.format("#%s: %.2f", currentInventory.getItemName(), currentInventory.getPrice());
                io.print(vendingInfo);
            }
        }

        io.print("Options");
        io.print("0. Add Money to machine");
        io.print("1. Walk Away");
        return io.readInt("Would you like to add money to the machine or walk away", 0,1);
    }

    public void blank(){
        io.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    public BigDecimal AddMoney(){
        return BigDecimal.valueOf(io.readDouble("please enter the amount of money you have into the machine"));
    }

    public void displayChange(String change){
        io.print(change);
    }

    public String itemSelect(){
        return io.readString("Please Select an item");
    }


    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void vend(VendingMachine vending){
        io.print("your item is " + vending.getItemName());
        io.print("that cost you £" + vending.getPrice());
    }

    public void displayCurrentMoney(BigDecimal money){
        io.print("Current money is at £" + money);
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
}
