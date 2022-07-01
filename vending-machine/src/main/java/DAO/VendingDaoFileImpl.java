package DAO;

import DTO.VendingMachine;
import Service.VendingInsufficientFundsException;
import Service.VendingNoItemInventoryException;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingDaoFileImpl implements  VendingDao {
    private final String File;
    public static final String DELIMITER = "::";
    private Map<String, VendingMachine> vending = new HashMap<>();

    public VendingDaoFileImpl(String file) {
        File = file;
    }

    public VendingDaoFileImpl() {
        File = "Inventory.txt";
    }

    private void loader()throws VendingPersistenceException{
        Scanner scanner;
        try{
            scanner=new Scanner(new BufferedReader(new FileReader(File)));

        }catch (FileNotFoundException e){
            throw new VendingPersistenceException("-_- Could not load Inventory data into memory.", e);
        }
        String currentLine;
        VendingMachine currentItem;
        while (scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentItem = unmarshall(currentLine);
            vending.put(currentItem.getItemName(), currentItem);
        }
        scanner.close();
    }

    private VendingMachine unmarshall(String ItemAsText){

        String[] ItemTokens = ItemAsText.split(DELIMITER);
        String itemName = ItemTokens[0];
        VendingMachine VendingFromFile = new VendingMachine(itemName);
        VendingFromFile.setPrice(new BigDecimal(ItemTokens[1]));
        VendingFromFile.setQuantity(Integer.parseInt(ItemTokens[2]));

        return VendingFromFile;
    }

    private void Writer() throws VendingPersistenceException{
        PrintWriter out;

        try{
            out = new PrintWriter((new FileWriter(File)));
        }catch(IOException e){
            throw new VendingPersistenceException("Could Not Save the Inventory Data." ,e);
        }

        String InventoryAsText;
        List<VendingMachine> Inventory = this.getInventory();
        for(VendingMachine currentItem : Inventory){
            InventoryAsText = marshall(currentItem);
            out.println(InventoryAsText);
            out.flush();
        }
        out.close();
    }

    private String marshall(VendingMachine item){
        String inventoryAsText = item.getItemName() + DELIMITER;
        inventoryAsText+=item.getPrice()+DELIMITER;
        inventoryAsText+=item.getQuantity();
        return inventoryAsText;
    }

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
