package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
        int m = 15;
        int n = 25;

        System.out.println(getLcm(m, n));
        System.out.println(getGcd(m, n));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {

        if (m <= 0 || n <= 0) {
            return -1;
        }

        int numLcm = 0;

        while(numLcm >= 0) {
            numLcm = numLcm + 1;

            if (numLcm % m == 0) {

                if (numLcm % n == 0) {
                    break;
                }

            }

        }

        return numLcm;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        int numLcm = getLcm(m, n);

        if (numLcm == -1) {
            return -1;
        }

        return (m * n) / numLcm ;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью рекурсивной версии алгоритма Евклида.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {
        int numLcm = getLcm(m, n);

        if (numLcm == -1) {
            return -1;
        }

        return 0;
    }

    static int getGcdByRecurs(int m, int n) {

        if ((m != 0) && (n != 0)) {
            return m + n;
        }


        return 0;
    }
}
