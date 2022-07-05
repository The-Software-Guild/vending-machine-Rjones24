package DAO;

import DTO.VendingMachine;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingDaoFileImplTest {

    VendingDao testDao;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception{
        String TestFile = "TextDao.txt";
        new FileWriter(TestFile);
        PrintWriter out =new PrintWriter( new FileWriter(TestFile),true);
        out.printf("Water::1.99::0%n" +
                "Waffles::3.00::5%n" +
                "Sprite::1.59::3%n" +
                "Monster Munch::1.25::10%n" +
                "Cola::1.99::4");
        testDao = new VendingDaoFileImpl(TestFile);

    }

    @Test
    public void testGetInventory() throws Exception{
        List<VendingMachine> INVENTORY = testDao.getInventory();

        assertNotNull(INVENTORY, "The Inventory must not null");
        assertEquals(5, INVENTORY.size(), "The inventory should contain 5 items");
        assertTrue(testDao.getInventory().containsAll(INVENTORY));
    }
    @Test
    public void testSelect() throws Exception{
        List<VendingMachine> INVENTORY = testDao.getInventory();
        VendingMachine Item = testDao.SelectItem("Cola");
        assertTrue(INVENTORY.contains(Item), "item was in inventory");

        assertEquals(Item.getItemName(), "Cola", "item was in inventory");
        assertEquals(Item.getPrice(), new BigDecimal("1.99"), "item was in inventory");
        assertEquals(Item.getQuantity(), 4, "item was in inventory");
    }
    @Test
    public void testInventoryUpdate() throws Exception{

        List<VendingMachine> INVENTORY = testDao.getInventory();
        VendingMachine Item = testDao.SelectItem("Cola");
        assertTrue(INVENTORY.contains(Item), "item was in inventory");

        assertEquals(Item.getItemName(), "Cola", "item was in inventory");
        assertEquals(Item.getPrice(), new BigDecimal("1.99"), "item was in inventory");
        assertEquals(Item.getQuantity(), 4, "item was in inventory");

        Item.setQuantity(Item.getQuantity()-1);
        testDao.UpdateInventory("Cola",Item);

        VendingMachine ItemUp = testDao.SelectItem("Cola");
        assertFalse(INVENTORY.contains(Item), "item was in inventory");

        assertEquals(ItemUp.getItemName(), "Cola", "item was in inventory");
        assertEquals(ItemUp.getPrice(), new BigDecimal("1.99"), "item was in inventory");
        assertEquals(ItemUp.getQuantity(), 3, "item was in inventory");
    }
}