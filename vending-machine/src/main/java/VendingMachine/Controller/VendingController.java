package VendingMachine.Controller;

import VendingMachine.dao.VendingPersistenceException;
import VendingMachine.DTO.VendingMachine;
import VendingMachine.Service.VendingInsufficientFundsException;
import VendingMachine.Service.VendingNoItemInventoryException;
import VendingMachine.Service.VendingServiceLayer;
import VendingMachine.UI.VendingView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
@Component
public class VendingController {
    private final VendingServiceLayer service;
    private final VendingView view;
@Autowired
    public VendingController(VendingServiceLayer service, VendingView view) {
        this.service = service;
        this.view = view;
    }

    public void Run() {
        boolean keepGoing = true;
        try {
            while (keepGoing) {
                int option;
                option = getOption();
                switch (option) {
                    case 0 -> StartVending();
                    case 1 -> keepGoing = false;
                    default -> unknownCommand();
                }
            }
            WalkAway();
        } catch (VendingPersistenceException e) {
            view.blank();
            view.displayErrorMessage(e.getMessage());
            view.blank();
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void WalkAway() {
        view.displayExitBanner();
    }

    private void StartVending() {
        BigDecimal money = view.AddMoney();
        view.displayCurrentMoney(money);
        String item;
        VendingMachine ItemToBuy;
        try {
            do {
                item = view.itemSelect();
                ItemToBuy = service.getItem(item);
            } while (ItemToBuy == null);

            boolean check;
            do {
                check = service.CheckSelectItem(item, ItemToBuy);
            } while (!check);
            service.BuyItem(ItemToBuy, money);
            view.vend(ItemToBuy);
            view.displayChange(service.GetMoney(ItemToBuy.getPrice(), money));
        } catch (VendingNoItemInventoryException | VendingInsufficientFundsException | VendingPersistenceException e) {
            view.blank();
            view.displayErrorMessage(e.getMessage());
        }
        view.blank();
    }

    private int getOption() throws VendingPersistenceException {
        List<VendingMachine> inventory = service.getInventory();
        return view.PrintVendingDisplay(inventory);
    }
}
