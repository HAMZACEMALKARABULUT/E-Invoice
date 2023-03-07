package input;

import java.util.Scanner;

public class InputUtil {

    public static String getInput(String outputText) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(outputText);
        return scanner.nextLine();

    }

}
