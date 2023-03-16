import controller.MainMenuController;
import dao.BegginingOperations;
import enums.Colors;

public class Main {
    public static void main(String[] args) {

        BegginingOperations.InstertSampleCustomers();

        System.out.println(Colors.BLUE.getCode()+" <<<<<<<<<<<<<<<<<<<<<<HOŞGELDİNİZ>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+Colors.BLUE.getLastCode());

        while (true) {
     MainMenuController mainMenuController =new MainMenuController();

     mainMenuController.printOperationsMenu();
            }


    }
}