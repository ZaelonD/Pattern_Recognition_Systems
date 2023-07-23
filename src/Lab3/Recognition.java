package Lab3;

import java.util.*;

// Класс распознования
public class Recognition {

    // Метод для распознования
    // На входе HashMap с массивами представления букв в числовом виде и введенный массив
    public static Character recognize(Data map, int[] inputLetter) {
        Set<int[]> keys = map.keySet(); // Получаем все ключи, в нашем случае массивы букв
        char recognizedLetter = ' '; // Создаем переменную для распознанной буквы
        int min = Integer.MAX_VALUE; // Создаем начальный минимум, чтобы могли записать первое значение расстояния
        for (int[] data : keys) { // Проходимся по каждому ключу
            int distance = Levenshtein.levenshteinDistance(inputLetter, data); // Считаем расстояние
            if (distance < min) { // Сравниваем
                min = distance; // Присваиваем минимум
                recognizedLetter = map.get(data); // Получаем букву по ключу
            }
        }
        System.out.println("Расстояние Левенштейна: " + min); // Выводим расстояние
        return recognizedLetter; // Возвращаем распознанную букву
    }
}
