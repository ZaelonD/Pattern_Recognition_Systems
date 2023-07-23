package Lab4;

import java.util.*;

// Класс для поиска точек
public class Candidates {

    // Метод для поиска точек, находящихся в радиусе R от центра текущего кластера
    public static List<Integer> getCandidates(List<List<Double>> data, List<Double> center, List<Integer> nonClustered, int R) {
        List<Integer> candidates = new ArrayList<>();

        for (int i = 0; i < nonClustered.size(); i++) {
            List<Double> vector = new ArrayList<>();
            for (int j = 0; j < data.get(i).size(); j++) {
                vector.add(data.get(i).get(j) - center.get(j));
            }
            if (Calculate.norm(vector) <= R) {
                candidates.add(nonClustered.get(i));
            }
        }
        return candidates;
    }
}