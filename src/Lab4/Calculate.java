package Lab4;

import java.util.*;
import java.util.stream.*;

// Класс для рассчетов некоторых величин
public class Calculate {

    // Метод для создания списка чисел по возрастанию
    public static List<Integer> listOfNum(int length) {
        return IntStream.range(0, length).boxed().collect(Collectors.toList());
    }

    // Функция вычисления Евклидова-расстояния
    public static double norm(List<Double> vector) {
        double result;
        double sum = 0.0;
        for (Double coordinate : vector) {
            sum += Math.pow(Math.abs(coordinate), 2);
        }
        result = Math.sqrt(sum);
        return result;
    }

    // Метод вычисления среднего значения
    public static List<Double> mean(List<List<Double>> curData, int axis) {
        List<Double> result = new ArrayList<>();

        double mean;
        if (axis == 0) {
            for (int i = 0; i < curData.get(0).size(); i++) {
                double sum = 0;
                for (List<Double> cur : curData) {
                    sum += cur.get(i);
                }
                mean = sum / curData.size();
                result.add(mean);
            }
        } else {
            for (List<Double> cur : curData) {
                double sum = 0;
                for (double x : cur) {
                    sum += x;
                }
                mean = sum / cur.size();
                result.add(mean);
            }
        }
        return result;
    }
}