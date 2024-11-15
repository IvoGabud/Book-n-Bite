package com.booknbite.app.model;

import java.util.Random;

public class CodeGenerator {

    public static String generateGroupCode() {

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        Random random = new Random();
        StringBuilder code = new StringBuilder(6);

        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(letters.length());
            code.append(letters.charAt(index));
        }

        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(numbers.length());
            code.append(numbers.charAt(index));
        }

        return code.toString();
    }
}