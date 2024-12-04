package com.walking.intensive.chapter2.task8;

/**
 * Добираясь в школу на трамвае Вова проверяет, является ли купленный билет счастливым.
 * Если является, то нужно загадать желание и съесть билетик.
 *
 * <p>Билет содержит 6 цифр, комбинации подбираются случайным образом от 000000 до 999999.
 *
 * <p>Билет считается счастливым, если сумма первых трех цифр равна сумме последних трех цифр.
 *
 * <p>Пример: 123411 – счастливый (1 + 2 + 3 == 4 + 1 + 1).
 *
 * <p>Реализуйте метод getHappyTicketChance(), который будет возвращать вероятность
 * выпадения счастливого билета.
 *
 * <p>P.S. Вероятность – это отношение благоприятных исходов к числу всех исходов.
 * Вероятность не может принимать значение больше 1.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task8 {
    public static void main(String[] args) {
        System.out.println(getHappyTicketChance());
    }

    static double getHappyTicketChance() {

        int countHappySum = 0;
        int countTimes = 0;
        int sumLeftPart;
        int sumRightPart;
        for (int j = 0; j <= 9; j++) {
            for (int i = 0; i <= 9; i++) {
                for (int k = 0; k <= 9; k++) {
                    for (int n = 0; n <= 9; n++) {
                        for (int t = 0; t <= 9; t++) {
                            for (int m = 0; m <= 9; m++) {

                                sumLeftPart = j + i + k;
                                sumRightPart = n + t + m;

                                if (sumLeftPart == sumRightPart) {
                                    countHappySum += 1;
                                }

                                countTimes += 1;
                            }
                        }
                    }
                }
            }
        }

        return (double) countHappySum / countTimes;
    }
}
