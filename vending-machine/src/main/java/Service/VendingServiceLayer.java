package Service;

import DAO.VendingPersistenceException;
import DTO.VendingMachine;

import java.math.BigDecimal;
import java.util.List;

public interface VendingServiceLayer {
    VendingMachine AddMoney(BigDecimal money);

    List<VendingMachine> getInventory() throws VendingPersistenceException;

    VendingMachine SelectItem(String ItemName) throws VendingNoItemInventoryException;

    VendingMachine BuyItem(String ItemName, BigDecimal money) throws VendingInsufficientFundsException;

    VendingMachine UpdateInventory(String ItemName);
}