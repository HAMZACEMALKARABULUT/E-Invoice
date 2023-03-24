package com.edonusum.test.deneme;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.ValidationUtil;


public class ValidationTest {
    @Test
    @DisplayName("email hatalı validasyon geçersiz olması")
    public void invalidEmailTest(){
        String email="dasdwfq";

        boolean result = ValidationUtil.isMail(email);
        Assertions.assertFalse(result,email+" adresi geçersiz olması gerekirken geçerli oldu");


    }
}
