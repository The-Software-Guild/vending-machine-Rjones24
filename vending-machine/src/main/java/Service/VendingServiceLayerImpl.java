package Service;

import DAO.VendingDao;
import DAO.VendingPersistenceException;
import DTO.VendingMachine;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class VendingServiceLayerImpl implements VendingServiceLayer{

    VendingDao dao;

    public VendingServiceLayerImpl(VendingDao dao) {
        this.dao = dao;
    }

    @Override
    public List<VendingMachine> getInventory() throws VendingPersistenceException {
        return dao.getInventory().stream().filter(item -> item.getQuantity()>0).collect(Collectors.toList());
    }

    @Override
    public VendingMachine getItem(String Item) throws VendingPersistenceException, VendingNoItemInventoryException {
        return dao.SelectItem(Item);
    }
    @Override
    public boolean CheckSelectItem(String ItemName, VendingMachine vending) throws VendingNoItemInventoryException {

        if (vending.getQuantity() == 0) {
            throw new VendingNoItemInventoryException("there is no " + vending.getItemName() + " left");
        } else {
            return true;
        }
    }

    @Override
    public void BuyItem(VendingMachine ItemToBuy, BigDecimal money) throws  VendingPersistenceException{

        if(money.compareTo(ItemToBuy.getPrice())>=0) {
            ItemToBuy.setQuantity(ItemToBuy.getQuantity() - 1);
        }
        dao.UpdateInventory(ItemToBuy.getItemName(),ItemToBuy);
    }


    @Override
    public String GetMoney(BigDecimal itemPrice, BigDecimal money) throws VendingInsufficientFundsException {
        String changeToGive = Coin.change(money,itemPrice);
        return changeToGive;
    }
}
