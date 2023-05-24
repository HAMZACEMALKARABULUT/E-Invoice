package test;

import com.izibiz.service.validation.ValidationUtil;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;


public class ValidationTest {
    @Test
    @DisplayName("email hatalı validasyon geçersiz olması")
    public void invalidEmailTest(){
        String email="sdfasdf";
        boolean result = ValidationUtil.isMail(email);
        Assertions.assertFalse(result,email+" adresi geçersiz olması gerekirken geçerli oldu");
    }
    @Test
    @DisplayName("email hatalı validasyonu ,  geçersiz olması")
    public void invalidNumTest(){
        String num="12345677543";
        String notNum="123REFAFSDF";
        boolean numResult=ValidationUtil.isNumber(num);
        boolean notNumResult=ValidationUtil.isNumber(notNum);
        Assertions.assertFalse(notNumResult,notNum +" Text'i geçersiz olması gerekirken geçerli oldu.");
        Assertions.assertTrue(numResult,num +" numarası geçerli olması gerekirken geçersiz oldu.");

    }
    @Test
    @DisplayName(" hatalı validasyon geçersiz olması")
    public void invalidTextTest(){

        String num="12345677543";
        String text="REFAFSDF";

        boolean textResult=ValidationUtil.isText(text);
        boolean numResult=ValidationUtil.isText(num);

        Assertions.assertTrue(textResult,text +" Text'i geçerli olması gerekirken geçersiz oldu.");
        Assertions.assertFalse(numResult,num +" numarası geçersiz olması gerekirken geçerli oldu.");


    }

    @Test
    @DisplayName(" hatalı validasyon geçersiz olması")
    public void invalidTelTest(){

        String tel="05338763726";
        String notTel="5493939923";
        boolean telResult=ValidationUtil.isTelNo(tel);
        boolean notTelResult=ValidationUtil.isTelNo(notTel);
        Assertions.assertTrue(telResult ,tel+" numarası  geçerli olması gerekirken geçersiz oldu.");
        Assertions.assertFalse(notTelResult,notTel +" numarası geçersiz olması gerekirken geçerli oldu.");


    }

    @Test
    @DisplayName(" hatalı validasyon geçersiz olması")
    public void invalidTcIdNoTest(){
        String tcNo="14206281838";
        String notTcNo="5493939923";
        boolean tcNoResult=ValidationUtil.isIdNo(tcNo);
        boolean notTcNoResult=ValidationUtil.isIdNo(notTcNo);
        Assertions.assertTrue(tcNoResult ,tcNo+" numarası  geçerli olması gerekirken geçersiz oldu.");
        Assertions.assertFalse(notTcNoResult,notTcNo +" numarası geçersiz olması gerekirken geçerli oldu.");


    }

    @Test
    @DisplayName(" hatalı validasyon geçersiz olması")
    public void invalidTaxNoTest(){
        String taxNo="0123456789";
        String notTaxNo="35435341";
        boolean taxNoResult=ValidationUtil.isTaxNo(taxNo);
        boolean notTaxNoResult=ValidationUtil.isTaxNo(notTaxNo);
        Assertions.assertTrue(taxNoResult ,taxNo+" numarası  geçerli olması gerekirken geçersiz oldu.");
        Assertions.assertFalse(notTaxNoResult,notTaxNo +" numarası geçersiz olması gerekirken geçerli oldu.");


    }

    @Test
    @DisplayName(" hatalı validasyon geçersiz olması")

    public void invalidPriceTest(){
        String price="9.99";
        String notPrice="7,88";
        boolean priceResult=ValidationUtil.isPrice(price);
        boolean notTelResult=ValidationUtil.isPrice(notPrice);
        Assertions.assertTrue(priceResult ,price+" ücreti   geçerli olması gerekirken geçersiz oldu.");
        Assertions.assertFalse(notTelResult,notPrice +" ücreti geçersiz olması gerekirken geçerli oldu.");



    }

    @Test
    @DisplayName(" hatalı validasyon geçersiz olması")
    public void invalidMoneyTypeTest(){

        String moneyType="€";
        String moneyType1="₺";
        String moneyType2="$";
        String moneyType3="tl";
        String moneyType4="eur";
        String moneyType5="usd";

        String notMoneyType="türk lirası";
        String notMoneyType1="avro";
        String notMoneyType2="dolar";
        String notMoneyType3="2342";
        String notMoneyType4="kayme";
        String notMoneyType5="dirhem";

        boolean moneyTypeResult=ValidationUtil.isMoneyType(moneyType);
        boolean moneyTypeResult1=ValidationUtil.isMoneyType(moneyType1);
        boolean moneyTypeResult2=ValidationUtil.isMoneyType(moneyType2);
        boolean moneyTypeResult3=ValidationUtil.isMoneyType(moneyType3);
        boolean moneyTypeResult4=ValidationUtil.isMoneyType(moneyType4);
        boolean moneyTypeResult5=ValidationUtil.isMoneyType(moneyType5);


        boolean notMoneyTypeResult=ValidationUtil.isMoneyType(notMoneyType);
        boolean notMoneyTypeResult1=ValidationUtil.isMoneyType(notMoneyType1);
        boolean notMoneyTypeResult2=ValidationUtil.isMoneyType(notMoneyType2);
        boolean notMoneyTypeResult3=ValidationUtil.isMoneyType(notMoneyType3);
        boolean notMoneyTypeResult4=ValidationUtil.isMoneyType(notMoneyType4);
        boolean notMoneyTypeResult5=ValidationUtil.isMoneyType(notMoneyType5);

        Assertions.assertTrue(moneyTypeResult ,moneyType+" para birimi  geçerli olması gerekirken geçersiz oldu.");
        Assertions.assertTrue(moneyTypeResult1 ,moneyType1+" para birimi  geçerli olması gerekirken geçersiz oldu.");
        Assertions.assertTrue(moneyTypeResult2,moneyType2+" para birimi  geçerli olması gerekirken geçersiz oldu.");
        Assertions.assertTrue(moneyTypeResult3 ,moneyType3+" para birimi  geçerli olması gerekirken geçersiz oldu.");
        Assertions.assertTrue(moneyTypeResult4 ,moneyType4+" para birimi  geçerli olması gerekirken geçersiz oldu.");
        Assertions.assertTrue(moneyTypeResult5 ,moneyType5+" para birimi  geçerli olması gerekirken geçersiz oldu.");



        Assertions.assertFalse(notMoneyTypeResult,notMoneyType +" geçersiz verisi , geçersiz olması gerekirken geçerli oldu.");
        Assertions.assertFalse(notMoneyTypeResult1,notMoneyType1 +" geçersiz verisi , geçersiz olması gerekirken geçerli oldu.");
        Assertions.assertFalse(notMoneyTypeResult2,notMoneyType2 +" geçersiz verisi , geçersiz olması gerekirken geçerli oldu.");
        Assertions.assertFalse(notMoneyTypeResult3,notMoneyType3 +" geçersiz verisi , geçersiz olması gerekirken geçerli oldu.");
        Assertions.assertFalse(notMoneyTypeResult4,notMoneyType4 +" geçersiz verisi , geçersiz olması gerekirken geçerli oldu.");
        Assertions.assertFalse(notMoneyTypeResult5,notMoneyType5 +" geçersiz verisi , geçersiz olması gerekirken geçerli oldu.");



    }




}
