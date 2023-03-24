package validation;



import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidationUtil {

    static public String mailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static public String textRegex = "^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]{2,50}$";
    static public String telRegex = "^(05\\d{2}|5\\d{1})\\d{7}$";

    static public String tcIdNoRegex = "^[1-9]{1}[0-9]{9}[0,2,4,6,8]{1}$";

    static public String taxNoRegex = "^[0-9]{10}$";
    static public String numberRegex="^[0-9]+$";

    static public String priceRegex="^[0-9.]+$";

    static public String  moneyTypeRegex="^(?:TL|tl|₺|\\$|USD|usd|€|EUR|eur)$";


    public static boolean isValidText(String inputText, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText.trim());
        return matcher.matches();
    }

    public static boolean isMoneyType(String moneyType){

        return isValidText(moneyType,moneyTypeRegex);
    }

    public static boolean isMail(String mail) {

        String[] textPart = textSplit(mail);
          boolean isTrue=false;

        for (String tempMail : textPart
        ) {

            isTrue=isValidText(tempMail, mailRegex);

        }

          return isTrue;

    }
    public static String[] textSplit(String text) {
        return StringUtils.split(text,",");
        //String[] textParts = text.split(",");

        //return textParts;
    }

    public static boolean isPrice(String price){

        return isValidText(price,priceRegex);
    }


    public static boolean isNumber(String number){

        return isValidText(number,numberRegex);
    }
    public static boolean isText(String text) {


        return isValidText(text, textRegex);


    }

    public static boolean isTelNo(String telNo) {

        return isValidText(telNo, telRegex);
    }

    public static boolean isIdNo(String idNo) {

        return isValidText(idNo, tcIdNoRegex);

    }

    public static boolean isTaxNo(String taxNo) {

        return isValidText(taxNo, taxNoRegex);
    }






}
