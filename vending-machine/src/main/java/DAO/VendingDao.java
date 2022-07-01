package DAO;

import DTO.VendingMachine;
import Service.VendingInsufficientFundsException;
import Service.VendingNoItemInventoryException;

import java.math.BigDecimal;
import java.util.List;

public interface VendingDao {
    VendingMachine AddMoney(BigDecimal money);

    List<VendingMachine> getInventory() throws VendingPersistenceException;

    VendingMachine SelectItem(String ItemName) throws VendingNoItemInventoryException;

    VendingMachine BuyItem(String ItemName, BigDecimal money) throws VendingInsufficientFundsException;

    VendingMachine UpdateInventory(String ItemName);
}
