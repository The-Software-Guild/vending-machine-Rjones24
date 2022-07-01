package Service;

import DAO.VendingPersistenceException;
import DTO.VendingMachine;

import java.math.BigDecimal;
import java.util.List;

public class VendingServiceLayerImpl implements VendingServiceLayer{
    @Override
    public VendingMachine AddMoney(BigDecimal money) {
        return null;
    }

    @Override
    public List<VendingMachine> getInventory() throws VendingPersistenceException {
        return null;
    }

    @Override
    public VendingMachine SelectItem(String ItemName) throws VendingNoItemInventoryException {
        return null;
    }

    @Override
    public VendingMachine BuyItem(String ItemName, BigDecimal money) throws VendingInsufficientFundsException {
        return null;
    }

    @Override
    public VendingMachine UpdateInventory(String ItemName) {
        return null;
    }
}
