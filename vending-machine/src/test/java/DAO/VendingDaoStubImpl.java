package DAO;

import DTO.VendingMachine;
import Service.VendingNoItemInventoryException;

import java.util.List;

public class VendingDaoStubImpl implements VendingDao {
    @Override
    public List<VendingMachine> getInventory() throws VendingPersistenceException {
        return null;
    }

    @Override
    public VendingMachine SelectItem(String ItemName) throws VendingNoItemInventoryException, VendingPersistenceException {
        return null;
    }

    @Override
    public void UpdateInventory(String ItemName, VendingMachine vendingMachine) throws VendingPersistenceException {

    }
}
