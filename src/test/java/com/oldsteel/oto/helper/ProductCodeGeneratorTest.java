package com.oldsteel.oto.helper;

import com.oldsteel.helper.ProductCodeGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductCodeGeneratorTest {

    @Test
    void generateCodeTest(){
        String result = ProductCodeGenerator.generateCode();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.length(), 8);
        System.out.println(result);
        System.out.println("PR-"+result);
    }
}
