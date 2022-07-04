package Service;

import DAO.VendingPersistenceException;
import DTO.VendingMachine;

import java.math.BigDecimal;
import java.util.List;

public interface VendingServiceLayer {

    List<VendingMachine> getInventory() throws VendingPersistenceException;

    VendingMachine getItem(String Item) throws VendingPersistenceException, VendingNoItemInventoryException;

    boolean CheckSelectItem(String ItemName, VendingMachine vending) throws VendingNoItemInventoryException;

    void BuyItem(VendingMachine ItemToBuy, BigDecimal money) throws VendingInsufficientFundsException, VendingPersistenceException, VendingNoItemInventoryException;

    String GetMoney(BigDecimal itemPrice, BigDecimal money) throws VendingInsufficientFundsException;
}