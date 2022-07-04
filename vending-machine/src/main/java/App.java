import Controller.VendingController;
import DAO.VendingDao;
import DAO.VendingDaoFileImpl;
import DAO.VendingPersistenceException;
import Service.VendingInsufficientFundsException;
import Service.VendingNoItemInventoryException;
import Service.VendingServiceLayer;
import Service.VendingServiceLayerImpl;
import UI.UserIO;
import UI.UserIOConsoleImpl;
import UI.VendingView;

public class App {
    public static void main(String[] args) throws VendingNoItemInventoryException, VendingPersistenceException, VendingInsufficientFundsException {
        UserIO myIo = new UserIOConsoleImpl();
        VendingView myView = new VendingView(myIo);
        VendingDao myDao = new VendingDaoFileImpl();
        VendingServiceLayer myService = new VendingServiceLayerImpl(myDao);
        VendingController controller = new VendingController(myService,myView);
        controller.Run();
    }
}