package Service;

import DAO.AuditDao;
import DAO.VendingDao;
import DAO.VendingPersistenceException;
import DTO.VendingMachine;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class VendingServiceLayerImpl implements VendingServiceLayer {
    private final VendingDao dao;
    private final AuditDao auditDao;

    public VendingServiceLayerImpl(VendingDao dao, AuditDao audit) {
        this.dao = dao;
        this.auditDao = audit;
    }

    @Override
    public List<VendingMachine> getInventory() throws VendingPersistenceException {
        return dao.getInventory().stream().filter(item -> item.getQuantity() > 0).collect(Collectors.toList());
    }

    @Override
    public VendingMachine getItem(String Item) throws VendingPersistenceException, VendingNoItemInventoryException {
        return dao.SelectItem(Item);
    }

    @Override
    public boolean CheckSelectItem(String ItemName, VendingMachine vending) throws VendingNoItemInventoryException, VendingPersistenceException {

        if (vending.getQuantity() == 0) {
            auditDao.writeAuditEntry("there is no " + vending.getItemName() + " left");
            throw new VendingNoItemInventoryException("there is no " + vending.getItemName() + " left");
        } else {
            return true;
        }
    }

    @Override
    public void BuyItem(VendingMachine ItemToBuy, BigDecimal money) throws VendingPersistenceException {

        if (money.compareTo(ItemToBuy.getPrice()) >= 0) {
            ItemToBuy.setQuantity(ItemToBuy.getQuantity() - 1);
        }
        dao.UpdateInventory(ItemToBuy.getItemName(), ItemToBuy);
        auditDao.writeAuditEntry("1  " + ItemToBuy.getItemName() + " was brought " + ItemToBuy.getQuantity() + "left");
    }

    @Override
    public String GetMoney(BigDecimal itemPrice, BigDecimal money) throws VendingInsufficientFundsException, VendingPersistenceException {
        String changeToGive = Coin.change(money, itemPrice);
        auditDao.writeAuditEntry(String.format("the following change was given out %s", changeToGive));
        return changeToGive;
    }
}
