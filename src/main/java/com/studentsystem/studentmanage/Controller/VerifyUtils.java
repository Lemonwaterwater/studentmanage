package com.studentsystem.studentmanage.Controller;

import java.util.Arrays;
import java.util.List;


public class VerifyUtils {

    public static String verifyCode() {
        String code = "";
        int codeLength = 6;
        List<Character> selectChar = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        for (int i = 0; i < codeLength; i++) {
            int charIndex = (int) Math.floor(Math.random() * 9);
            code += selectChar.get(charIndex);
        }
        if (code.length() != codeLength) {
            verifyCode();
        }
        System.out.println("code=="+code);
        return code;

    }

}
