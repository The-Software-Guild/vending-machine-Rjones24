package DAO;

import DTO.VendingMachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingDaoStubImpl implements VendingDao {

    public VendingMachine OnlyItem;

    public VendingDaoStubImpl() {
        OnlyItem = new VendingMachine("Ham sandwich");
        OnlyItem.setPrice(new BigDecimal("2.25"));
        OnlyItem.setQuantity(7);
    }

    @Override
    public List<VendingMachine> getInventory() {
        List<VendingMachine> inventory = new ArrayList<>();
        inventory.add(OnlyItem);
        return inventory;
    }

    @Override
    public VendingMachine SelectItem(String ItemName) {
        if (ItemName.equals(OnlyItem.getItemName())) {
            return OnlyItem;
        } else {
            return null;
        }
    }

    @Override
    public void UpdateInventory(String ItemName, VendingMachine vendingMachine) {
        if (ItemName.equals(OnlyItem.getItemName())) {
            OnlyItem.setPrice(vendingMachine.getPrice());
            OnlyItem.setQuantity(vendingMachine.getQuantity());
        }
    }
}
