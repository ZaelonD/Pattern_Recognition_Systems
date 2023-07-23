package Lab4;

import java.util.*;

// Класс для вывода
public class Print {

    // Метод для вывода кластеров в консоль
    public static void printCluster(List<List<Integer>> clusters) {
        System.out.println("Число кластеров: " + clusters.size());
        System.out.println("Размеры каждого кластера: ");
        int i = 1;
        for (List<Integer> cluster : clusters) {
            System.out.print("Кластер " + (i++) + ":\t" + cluster.size() + "\t\t");
            if (i % 8 == 0){
                System.out.println();
            }
        }
    }
}