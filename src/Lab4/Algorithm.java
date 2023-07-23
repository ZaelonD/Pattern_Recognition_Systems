package Lab4;

import java.util.*;

// Класс для метода FOREL
public class Algorithm {

    // Переменная random для генерации случайных чисел
    private static final Random random = new Random();

    // Метод FOREL (на входе исходные данные (список списков вещественных чисел) и радиус)
    public static void FOREL(List<List<Double>> data, int R) {
        List<List<Integer>> clusters = new ArrayList<>(); // Список кластеров
        List<Integer> nonClustered = Calculate.listOfNum(data.size()); // Список некластеризованных точек

        // Повторяем действия, пока все точки не будут кластеризованы
        while (!nonClustered.isEmpty()) {
            Integer i = nonClustered.get(random.nextInt(nonClustered.size())); // Генерация случайной точки
            List<Integer> curCluster = new ArrayList<>(); // Создаем уникальный список для текущего кластера
            curCluster.add(i); // Добавляем элемент
            nonClustered.remove(i); // Удаляем из списка кластеров полученную точку

            // Продолжаем добавлять точки в текущий кластер, пока радиусе R от центра текущего кластера не останется точек
            while (true) {
                List<List<Double>> curData = new ArrayList<>(); // Текущий диапазон данных

                // Добавляем исходные данные в текущий список, используя индекс
                for (Integer integer : curCluster) {
                    curData.add(data.get(integer));
                }
                // Считаем центр текущего кластера, как среднее значение точек
                List<Double> center = Calculate.mean(curData, 0);

                // Поиск точек, находящихся в радиусе R от центра текущего кластера
                List<Integer> candidates = Candidates.getCandidates(data, center, nonClustered, R);

                // Если точек не найдено, выходим из цикла
                if (candidates.isEmpty())
                    break;

                // Добавляем подходящие точки в текущий кластер
                curCluster.addAll(candidates);

                // Удаляем их из некластеризованного списка
                for (Integer candidate : candidates) {
                    nonClustered.remove(candidate);
                }
            }
            clusters.add(curCluster); // Добавляем готовый кластер в список кластеров
        }
        Print.printCluster(clusters);
    }
}