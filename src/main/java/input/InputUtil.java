package input;

import controller.MainMenuController;
import enums.Colors;

import java.util.Scanner;

public class InputUtil {
    static MainMenuController main = new MainMenuController();
    static Scanner scanner = new Scanner(System.in);

    public static String getInput(String outputText) {

        System.out.println(outputText);


        String input = scanner.nextLine();
        if (input.toLowerCase().equals("iptal")) {

            System.out.println(Colors.RED.getCode()+"İŞLEM İPTAL EDİLDİ ANA MENÜYE YÖNLENDİRİLİYOR..."+Colors.RED.getLastCode());
            main.printOperationsMenu();
        }

            return input;

    }


}
