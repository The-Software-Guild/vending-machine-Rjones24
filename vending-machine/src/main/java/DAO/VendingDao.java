package DAO;

import DTO.VendingMachine;
import Service.VendingNoItemInventoryException;

import java.util.List;

public interface VendingDao {

    List<VendingMachine> getInventory() throws VendingPersistenceException;

    VendingMachine SelectItem(String ItemName) throws VendingNoItemInventoryException, VendingPersistenceException;


    void UpdateInventory(String ItemName, VendingMachine vendingMachine) throws VendingPersistenceException;
}
