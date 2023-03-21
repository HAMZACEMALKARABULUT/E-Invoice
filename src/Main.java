import controller.MainMenuController;
import dao.BegginingOperations;
import enums.Colors;

public class Main {
    public static  void main(String[] args) {
BegginingOperations begginingOperations=new BegginingOperations();
        begginingOperations.InsertSampleCustomers();

        System.out.println(Colors.BLUE.getCode()+
      " <<<<<<<<<<<<<<<<<<<<<<HOŞGELDİNİZ>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+Colors.BLUE.getLastCode());
        MainMenuController mainMenuController =new MainMenuController();
        while (true) {

     mainMenuController.printOperationsMenu();
            }


    }
}