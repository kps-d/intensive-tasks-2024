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
        System.out.println(isPalindrome("Дорог Рим город или дорог Миргород?!"));
    }

    static boolean isPalindrome(String inputString) {

        if (isValid(inputString)) {
            return false;
        }

        String lowerCaseString = inputString.toLowerCase();
        int lengthSting = lowerCaseString.length();
        int j = lengthSting - 1;

        for (int i = 0; i < lengthSting; i++) {
            if (isPunctuation(lowerCaseString.charAt(i))) {
                continue;
            }

            for (; j >= 0; j--) {
                if (isPunctuation(lowerCaseString.charAt(j))) {
                    continue;
                }

                if (lowerCaseString.charAt(i) != lowerCaseString.charAt(j)) {
                    return false;
                }
                break;
            }
            j--;
        }

        return true;
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

    static boolean isValid(String inputString) {
        return inputString == null || inputString.length() <= 1;
    }
}


