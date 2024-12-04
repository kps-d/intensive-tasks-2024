package com.walking.intensive.chapter2.task7;

/**
 * Пятиклассник Ваня придумал забаву. Он ввел понятие «дружественной пары» чисел.
 * Два различных натуральных числа N и M он назвал дружественными, если сумма делителей числа N
 * (включая 1, но исключая само N) равна числу M и наоборот.
 *
 * <p>Например, 220 и 284 – дружественные числа:
 *
 * <ul>
 * <li>Список делителей для 220: 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110. Их сумма равна 284;
 * <li>Список делителей для 284: 1, 2, 4, 71, 142. Их сумма равна 220.
 * </ul>
 *
 * <p>Реализуйте метод getFriendlyPair(), который принимает параметром число N,
 * где N - натуральное число не больше 1 000 000.
 *
 * <p>Метод должен вернуть наибольшее число из пары дружественных чисел,
 * сумма дружественных чисел которой максимальна среди всех пар дружественных
 * чисел, большее из которых меньше N.
 *
 * <p> Если входные данные некорректны - метод должен возвращать -1.
 *
 * <p>P.S. Решение не должно использовать массивы и прочие темы, которые пока не были затронуты в курсе.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task7 {
    public static void main(String[] args) {
        int num = 1_000_001;
        System.out.println(getFriendlyPair(num));
    }

    static int getFriendlyPair(int num) {

        if (isValid(num)) {
            return -1;
        }

        for (int i = num; i >= 1; i--) {
            int sumDividerFirst = getSumDivider(i);
            int sumDividerSecond = getSumDivider(sumDividerFirst);

            if (i == sumDividerSecond && sumDividerFirst != sumDividerSecond) {
                return i;
            }

        }
        return 0;
    }

    static boolean isValid(int num) {
        return num <= 0 || num > 1_000_000;
    }

    static int getSumDivider(int num) {
        int sumDivider = 0;
        for (int i = num - 1; i >= 1; i--) {

            if (num % i == 0) {
                sumDivider += i;
            }

        }
        return sumDivider;
    }
}
