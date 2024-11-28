package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {

        double a = 3;
        double b = 4;
        double c = 5;

        System.out.println(getAreaByHeron(a, b, c));
        System.out.println(Arrays.toString(getHeights(a, b, c)));
        System.out.println(Arrays.toString(getMedians(a, b, c)));
        System.out.println(Arrays.toString(getBisectors(a, b, c)));
        System.out.println(Arrays.toString(getAngles(a, b, c)));
        System.out.println(getInscribedCircleRadius(a, b, c));
        System.out.println(getCircumradius(a, b, c));
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {

        if (isParametersValid(a, b, c)) {
            return -1;
        }

        double halfPerimeter = getHalfPerimeter(a, b, c);

        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (isParametersValid(a, b, c)) {
            return new double[0];
        }

        double heightA = 2 * getAreaByHeron(a, b, c) / a;
        double heightB = 2 * getAreaByHeron(a, b, c) / b;
        double heightC = 2 * getAreaByHeron(a, b, c) / c;
        double[] heightArray = new double[3];
        heightArray[0] = heightA;
        heightArray[1] = heightB;
        heightArray[2] = heightC;
        Arrays.sort(heightArray);

        return heightArray;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (isParametersValid(a, b, c)) {
            return new double[0];
        }

        double medianA = Math.sqrt((2 * b * b) + (2 * c * c) - (a * a)) / 2;
        double medianB = Math.sqrt((2 * a * a) + (2 * c * c) - (b * b)) / 2;
        double medianC = Math.sqrt((2 * a * a) + (2 * b * b) - (c * c)) / 2;
        double[] medianArray = new double[3];
        medianArray[0] = medianA;
        medianArray[1] = medianB;
        medianArray[2] = medianC;
        Arrays.sort(medianArray);

        return medianArray;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (isParametersValid(a, b, c)) {
            return new double[0];
        }

        double semiperimetr;
        semiperimetr = (a + b + c) / 2;

        double bisectorA = 2 * Math.sqrt(semiperimetr * (semiperimetr - a) * b * c) / (b + c);
        double bisectorB = 2 * Math.sqrt(semiperimetr * (semiperimetr - b) * a * c) / (a + c);
        double bisectorC = 2 * Math.sqrt(semiperimetr * (semiperimetr - c) * a * b) / (a + b);
        double[] bisectorArray = new double[3];
        bisectorArray[0] = bisectorA;
        bisectorArray[1] = bisectorB;
        bisectorArray[2] = bisectorC;
        Arrays.sort(bisectorArray);

        return bisectorArray;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (isParametersValid(a, b, c)) {
            return new double[0];
        }

        double anglesA = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c)));
        double anglesB = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));
        double anglesC = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * c * b)));
        double[] anglesArray = new double[3];
        anglesArray[0] = anglesA;
        anglesArray[1] = anglesB;
        anglesArray[2] = anglesC;
        Arrays.sort(anglesArray);

        return anglesArray;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {

        if (isParametersValid(a, b, c)) {
            return -1;
        }

        return getAreaByHeron(a, b, c) / getHalfPerimeter(a, b, c);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {

        if (isParametersValid(a, b, c)) {
            return -1;
        }

        return (a * b * c) / (4 * getAreaByHeron(a, b, c));
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        //        Место для вашего кода

        return 0; // Заглушка. При реализации - удалить
    }

    static boolean isParametersValid (double a, double b, double c){
        double halfPerimeter = getHalfPerimeter(a, b, c);

        if (halfPerimeter <= a || halfPerimeter <= b || halfPerimeter <= c) {
            return false;
        }

        return true;
    }

    static double getHalfPerimeter (double a, double b, double c) {
        return  (a + b + c) / 2;
    }
}
