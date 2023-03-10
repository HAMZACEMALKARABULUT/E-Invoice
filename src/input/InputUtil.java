package input;

import controller.MainMenuController;

import java.util.Scanner;

public class InputUtil {
    static MainMenuController main=new MainMenuController();
  static   Scanner scanner = new Scanner(System.in);
    public static String getInput(String outputText) {

        System.out.println(outputText);
        return scanner.nextLine();

    }




}
