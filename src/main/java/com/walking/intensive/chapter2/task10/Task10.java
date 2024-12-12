package com.walking.intensive.chapter2.task10;

import java.util.Locale;
import java.util.Objects;

/**
 * Реализуйте метод isPalindrome(), который проверяет, является ли строка палиндромом.
 *
 * <p>Метод должен игнорировать пунктуацию, пробелы и регистр.
 *
 * <p>P.S. Мой любимый палиндром: Муза! Ранясь шилом опыта, ты помолишься на разум.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task10 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(""));

    }

    static boolean isPalindrome(String inputString) {

        if (isValid(inputString)) {
            return false;
        }

        String s = inputString.toLowerCase();
        String sTest = "";
        String sForward = "";

        for (int i = 0; i < s.length(); i++) {
            if (!isPunctuation(s.charAt(i))) {
                sTest = sTest + s.charAt(i);
            }
        }

        for (int j = s.length() - 1; j >= 0; j--) {
            if (!isPunctuation(s.charAt(j))) {
                sForward = sForward + s.charAt(j);
            }
        }

        return sTest.equals(sForward);
    }

    static boolean isPunctuation(char c) {
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        for (int i = 0; i < abc.length(); i++) {
            char testS = abc.charAt(i);

            if (c == testS) {
                return false;
            }

        }
        return true;
    }

    static boolean isValid(String s) {
        return s == null || s.length() <= 1;
    }

}


