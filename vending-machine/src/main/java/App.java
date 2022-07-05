import Controller.VendingController;
import DAO.AuditDao;
import DAO.AuditDaoImpl;
import DAO.VendingDao;
import DAO.VendingDaoFileImpl;
import Service.VendingServiceLayer;
import Service.VendingServiceLayerImpl;
import UI.UserIO;
import UI.UserIOConsoleImpl;
import UI.VendingView;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        VendingView myView = new VendingView(myIo);
        VendingDao myDao = new VendingDaoFileImpl();
        AuditDao myAuditDao = new AuditDaoImpl();
        VendingServiceLayer myService = new VendingServiceLayerImpl(myDao, myAuditDao);
        VendingController controller = new VendingController(myService, myView);
        controller.Run();
    }
}