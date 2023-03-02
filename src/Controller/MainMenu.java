package Controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class MainMenu {

    static Scanner scanner=new Scanner(System.in);
    public static final String numRegex="[0-9]+$";
    public static final String taxRegex="^[0-9]{10}$";
    public static final String idRegex="^[1-9]{1}[0-9]{9}[0,2,4,6,8]{1}$";

    public static final String keyRegex="^[a-zA-Z\\s]+$";





    public  void selectTheOperation() {
        System.out.println("--ANA MENÜ-- ");
        System.out.println("1- Musteri oluştur");
        System.out.println("2- Musteri listele");
        System.out.println("3- Çıkış yap");
        // System.out.println("3- Fatura olustur");
        // System.out.println("4- Fatura Listele");


        int operationNumber = 0;
        String input = getInput("Yapacağınız işlemi tuşlayınız...");


        if (isCorrectFormat(input,numRegex,false)){
        operationNumber = Integer.parseInt(input);}
        else {
            selectTheOperation();
        }

        switch (operationNumber) {


            case 1:
                createCustomer();
                break;
            case 2:
                break;
            case 3:
                System.out.println("Çıkış yapılıyor ....");
                System.exit(0);
                break;
            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                selectTheOperation();


        }
    }

                         //VERİ OKUMA İŞLEMİ YAPAN METOD
    public  String getInput(String outputText) {

        System.out.println(outputText);
        String data = scanner.nextLine();
        return data;

    }

    public void  createCustomer(){

        String identifyText="TC Kimlik No veya Vergi Numarası:";
        String input=getInput(identifyText);

        String regex=input.length()==11?idRegex:taxRegex;

                isCorrectFormat(input,regex,false);


    }




    public boolean isCorrectFormat(String text, String regex , boolean isNullable) {
        boolean isCorrect = false;

        while (isCorrect){
            if ( !(text.trim().equals(""))  ||  isNullable) {
                isCorrect = regexControl(text, regex);
            }

            System.out.println("Yanlış veri girişi yapıldı. \n");
            
        }


        return isCorrect;
    }
    public static boolean regexControl(String no, String regex ) {
        Matcher matcher;
        Pattern pattern;

        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(no);

        if (matcher.matches()) {
            return true;
        }

        else {
            return false;
        }


    }
}
