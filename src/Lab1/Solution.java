package Lab1;

import java.util.Scanner;

public class Solution {
    private static final int VECTOR_COUNT = 16; // Количество признаков (константа)

    // Заполняем объекты обучающей выборки класса "Б"
    static int[] b1 = {3, 2, 2, 2, 3, 2, 2, 2, 2, 0, 0, 2, 3, 2, 2, 3};
    static int[] b2 = {3, 2, 2, 2, 3, 2, 2, 0, 2, 0, 0, 2, 3, 2, 2, 3};
    static int[] b3 = {3, 2, 2, 3, 3, 2, 2, 2, 2, 0, 0, 2, 3, 2, 2, 3};
    static int[] b4 = {3, 2, 2, 2, 3, 2, 2, 0, 2, 0, 0, 2, 3, 2, 2, 3};
    static int[] b5 = {3, 2, 1, 0, 3, 2, 1, 0, 2, 0, 2, 0, 2, 2, 1, 0};
    static int[] b6 = {1, 2, 2, 2, 2, 1, 2, 1, 3, 1, 0, 2, 1, 2, 2, 2};
    static int[] b7 = {3, 2, 2, 2, 3, 2, 2, 0, 2, 0, 0, 2, 3, 2, 2, 1};
    static int[] b8 = {3, 2, 2, 0, 3, 2, 2, 0, 2, 0, 0, 2, 3, 2, 2, 1};
    static int[] b9 = {0, 2, 2, 1, 0, 2, 0, 0, 0, 3, 2, 2, 0, 3, 2, 2};
    static int[] b10 = {2, 2, 2, 2, 2, 2, 2, 0, 2, 0, 0, 2, 1, 2, 2, 1};

    // Заполняем объекты обучающей выборки класса "З"
    static int[] z1 = {1, 2, 2, 1, 0, 0, 0, 2, 0, 0, 2, 1, 1, 2, 2, 1};
    static int[] z2 = {1, 2, 2, 1, 0, 0, 2, 1, 0, 0, 2, 1, 1, 2, 2, 1};
    static int[] z3 = {1, 2, 2, 2, 0, 0, 2, 1, 0, 0, 2, 1, 1, 2, 2, 2};
    static int[] z4 = {1, 2, 2, 2, 0, 0, 2, 1, 0, 0, 2, 1, 1, 2, 2, 2};
    static int[] z5 = {1, 2, 2, 1, 0, 1, 2, 1, 0, 0, 0, 2, 1, 2, 2, 1};
    static int[] z6 = {1, 2, 3, 0, 1, 2, 3, 1, 0, 0, 0, 2, 2, 2, 2, 2};
    static int[] z7 = {1, 2, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 1, 2, 2, 1};
    static int[] z8 = {2, 2, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 2, 2, 2, 1};
    static int[] z9 = {1, 2, 1, 0, 0, 2, 3, 0, 1, 2, 3, 0, 0, 0, 0, 0};
    static int[] z10 = {1, 2, 2, 2, 0, 0, 2, 1, 0, 1, 2, 1, 1, 2, 2, 2};

    // Записываем все объекты класса "Б" и "З" в два отдельных массива соответственно
    static int[][] b = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10};
    static int[][] z = {z1, z2, z3, z4, z5, z6, z7, z8, z9, z10};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Сканер для передачи данных через консоль
        System.out.print("Введите количесвто экспериментов: ");
        int experiment = scanner.nextInt(); // Записываем число экспериментов
        int k = experiment; // Счетчик для цикла
        double accuracy = 0; // Точность распознования
        while (k != 0) {
            System.out.print("\nВведите тестовую выборку: ");
            int[] test = getVector(scanner.next()); // Получаем тестовую выборку из консоли
            System.out.print("Какой букве соответствует данная выборка? (Б или З): ");
            String trueLetter = scanner.next(); // Настоящая буква
            String predLetter = NaiveBayes1(test, b, z, VECTOR_COUNT); // Предсказанная буква
            System.out.println("Предсказанная буква: " + predLetter);
            boolean check = Check(trueLetter, predLetter); // Проверка на соответствие букв

            System.out.println("Результат: " + check);
            if (check) {
                accuracy++;
            }
            k--;
        }
        String acc = String.format("%.0f", accuracy / experiment * 100);
        System.out.print("\nТочность распознавания: " + acc + "%"); // Выводим точность
    }

    // Проверка на соответствие букв
    private static boolean Check(String trueLetter, String predLetter) {
        return trueLetter.equals(predLetter);
    }

    // Считаем математическое ожидание как среднее арифметическое i-го признака
    private static double[] MeanAxis0(int[][] array, int vector) {
        double[] result = new double[vector];
        for (int i = 0; i < vector; i++) {
            int sum = 0;
            double mean;
            for (int[] ints : array) {
                sum += ints[i];
            }
            mean = (double) sum / array.length;
            result[i] = mean;
        }
        return result;
    }

    // Считаем среднее квадратическое отклонение i-го признака
    private static double[] Rmse(int[][] array, int vector) {
        double[] result = new double[vector];
        double[] mean = MeanAxis0(array, vector);
        for (int i = 0; i < vector; i++) {
            double sum = 0;
            for (int[] ints : array) {
                sum += Math.pow(ints[i] - mean[i], 2);
            }
            result[i] = Math.sqrt(sum / array.length);
        }
        return result;
    }

    // Считаем функцию правдоподобия
    private static double LikelihoodFunction(int[] array, double[] mean, double[] rmse) {
        double p = 1;
        for (int i = 0; i < array.length; i++) {
            p *= (1 / (Math.sqrt(2 * Math.PI) * rmse[i] + 1e-6)) * exponent(array, mean, rmse, i);
        }
        return p;
    }

    // Функция, которая считает экспоненту
    private static double exponent(int[] array, double[] mean, double[] rmse, int i) {
        return Math.exp(-(Math.pow(array[i] - mean[i], 2) / (2 * (Math.pow(rmse[i], 2) + 1e-6))));
    }

    // Преобразуем вектор значений из строки в массив
    private static int[] getVector(String str) {
        int[] array = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int x = Integer.parseInt(String.valueOf(str.charAt(i)));
            array[i] = x;
        }
        return array;
    }

    // Наивный метод Байеса
    public static String NaiveBayes1(int[] array, int[][] class1, int[][] class2, int vector) {

        // Считаем функции правдоподобия для первого и второго класса
        double likelihood1 = LikelihoodFunction(array, MeanAxis0(class1, vector), Rmse(class1, vector));
        double likelihood2 = LikelihoodFunction(array, MeanAxis0(class2, vector), Rmse(class2, vector));

        double apriori1 = (double) class1.length / (class1.length + class2.length); // Априорная вероятность класса
        double apriori2 = (double) class2.length / (class1.length + class2.length); // Априорная вероятность класса

        double aposterior1 = likelihood1 * apriori1; // Апостериорная вероятность
        double aposterior2 = likelihood2 * apriori2; // Апостериорная вероятность

        if (aposterior1 > aposterior2) {
            return "Б";
        } else {
            return "З";
        }
    }
}
