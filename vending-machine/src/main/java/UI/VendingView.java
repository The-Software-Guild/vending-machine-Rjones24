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
        io.print("#######Vending Machine#####");
        io.print("Hey you look like you could do with some food and drink");
        io.print("here is what i have to offer :)");

        for(VendingMachine currentInventory: inventory){
            String vendingInfo = String.format("#%s: %.2f", currentInventory.getItemName(), currentInventory.getPrice());
            io.print(vendingInfo);
        }

        io.print("Options");
        io.print("0. Add Money to machine");
        io.print("1. Walk Away");
        return io.readInt("Would you like to add money to the machine or walk away", 0,1);
    }

    public void displayChange(BigDecimal Quarter , BigDecimal Dime,BigDecimal Nickle, BigDecimal Penny){
        io.print("Here is your change :");
        io.print("Quarters  " + Quarter );
        io.print("Dimes :" + Dime);
        io.print("Nickles :" + Nickle);
        io.print("Penny's :" + Penny);
    }

    public String itemSelect(){
        return io.readString("Please Select an item");
    }

    public void notEnoughMoney(){
        io.print("sorry you do not have enough money for this item");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void vend(VendingMachine vending){
        io.print("Here is your " + vending.getItemName());
        io.print("that cost you £" + vending.getPrice());
    }

    public void displayCurrentMoney(BigDecimal money){
        io.print("Current money is at £");
    }
}
