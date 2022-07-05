package Service;

import DAO.AuditDao;
import DAO.VendingDao;
import DAO.VendingDaoStubImpl;
import DTO.VendingMachine;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VendingServiceLayerImplTest {

    private final VendingServiceLayer service;

    public VendingServiceLayerImplTest() {
        VendingDao dao = new VendingDaoStubImpl();
        AuditDao auditDao = new VendingAuditDaoStubImpl();
        service = new VendingServiceLayerImpl(dao, auditDao);
    }

    @Test
    public void testGetInventory() throws Exception {
        VendingMachine Test = new VendingMachine("Ham sandwich");
        Test.setPrice(new BigDecimal("2.25"));
        Test.setQuantity(7);

        assertEquals(1, service.getInventory().size());
        assertTrue(service.getInventory().contains(Test));
    }

    @Test
    public void testBuyItem() throws Exception {

        VendingMachine itemBefore = service.getItem("Ham sandwich");
        assertEquals(7, itemBefore.getQuantity());
        service.BuyItem(service.getItem("Ham sandwich"), new BigDecimal("2.99"));
        VendingMachine itemAfter = service.getItem("Ham sandwich");
        assertEquals(6, itemAfter.getQuantity());
    }

    @Test
    public void testGetMoney() throws Exception {

        VendingMachine itemBuy = service.getItem("Ham sandwich");
        String change = service.GetMoney(itemBuy.getPrice(), new BigDecimal("2.26"));
        assertEquals("Here is your change : 1 :0.01p", change);
    }

    @Test
    public void testGetItem() throws Exception {
        VendingMachine Test = new VendingMachine("Ham sandwich");
        Test.setPrice(new BigDecimal("2.25"));
        Test.setQuantity(7);

        assertEquals(service.getItem("Ham sandwich"), Test);
    }
}