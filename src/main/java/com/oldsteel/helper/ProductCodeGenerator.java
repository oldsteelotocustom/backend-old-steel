package com.oldsteel.helper;

public class ProductCodeGenerator {

    public static String generateCode(){
        String productCode ="0123456789";
        int x = 8;
        StringBuilder stringBuilder = new StringBuilder(x);

        for (int i = 0; i < 8; i++) {
            int index = (int)(productCode.length() * Math.random());
            stringBuilder.append(productCode.charAt(index));
        }
        return stringBuilder.toString();
    }
}
