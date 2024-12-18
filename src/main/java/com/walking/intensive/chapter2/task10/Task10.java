package com.walking.intensive.chapter2.task10;

import java.util.Locale;
import java.util.Objects;

import static java.lang.Character.isLetter;


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

        int lengthString = inputString.length();
        int j = lengthString - 1;

        for (int i = 0; i < lengthString / 2; i++) {
            if (isPunctuation(inputString.charAt(i))) {
                continue;
            }

            for (; j >= 0; j--) {
                if (isPunctuation(inputString.charAt(j))) {
                    continue;
                }

                if (!Character.toString(inputString.charAt(i)).equalsIgnoreCase(Character.toString(inputString.charAt(j)))) {
                    return false;
                }

                break;
            }
            j--;
        }

        return true;
    }

    static boolean isPunctuation(char c) {
        return !isLetter(c);
    }
    static boolean isValid(String inputString) {
        return inputString == null || inputString.length() <= 1;
    }
}


