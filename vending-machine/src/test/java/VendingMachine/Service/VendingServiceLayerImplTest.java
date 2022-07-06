package VendingMachine.Service;

import VendingMachine.dao.AuditDao;
import VendingMachine.dao.VendingDao;
import VendingMachine.dao.VendingDaoStubImpl;
import VendingMachine.DTO.VendingMachine;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VendingServiceLayerImplTest {

    private final VendingServiceLayer service;

    public VendingServiceLayerImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceLayer", VendingServiceLayer.class);
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