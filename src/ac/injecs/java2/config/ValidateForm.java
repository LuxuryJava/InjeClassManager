package ac.injecs.java2.config;

import java.util.regex.Pattern;

public  class ValidateForm  {
    // 한국어 검사기
    public static boolean isKorean(String str) {
        return Pattern.matches("[가-힣]*$", str);
    }

    // 이메일 검사기
    public static boolean isEmail(String str) {
        return Pattern.matches("^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$", str);
    }
}
