package VendingMachine;

import VendingMachine.Controller.VendingController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("VendingMachine");
        applicationContext.refresh();

        VendingController controller = applicationContext.getBean("vendingController", VendingController.class);
        controller.Run();
    }
}