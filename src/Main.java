import controller.MainMenuController;
import dao.BegginingOperations;

public class Main {
    public static void main(String[] args) {

        BegginingOperations.InstertSampleCustomers();

        System.out.println(" Hoşgeldiniz...");


     MainMenuController mainMenuController =new MainMenuController();
     while(true){
     mainMenuController.printOperationsMenu();}
    }
}