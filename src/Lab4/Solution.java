package Lab4;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        // Читаем файл с данными
        ReadFile readFile = new ReadFile("resources/data.txt");

        // Создаем сканнер для работы с вводом данных
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите радиус: ");

        // Вводим радиус
        int R = scanner.nextInt();

        // Применяем алгоритм FOREL
        Algorithm.FOREL(readFile.getData(), R);
    }
}