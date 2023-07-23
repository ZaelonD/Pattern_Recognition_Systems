package Lab2;

import java.util.List;

public class Accuracy {

    public void accuracyCount(String[][] training_sample, String[][] test_sample, List<int[]> tests) {
        double accuracy = 0;
        String[][] dataTrain = Data.dataArray(training_sample, 1);
        String[][] dataTest = Data.dataArray(test_sample, 1);
        int y1_count = ObjectClass.getY1_count();
        int y2_count = ObjectClass.getY2_count();
        int i = 1;
        for (String[] trainPat : dataTrain) {
            int sum_y1 = 0;
            int sum_y2 = 0;

            for (int[] test : tests) {
                for (String[] patient : dataTest) {
                    if (trainPat[test[0]].equals(patient[test[0]]) && trainPat[test[1]].equals(patient[test[1]])) {
                        if (trainPat[0].equals("y1")) {
                            sum_y1 += 1;
                        } else {
                            sum_y2 += 1;
                        }
                        // break;
                    }
                }
            }
            double probability_y1 = (double) sum_y1 / y1_count;
            double probability_y2 = (double) sum_y2 / y2_count;

            if (probability_y1 > probability_y2 && trainPat[0].equals("y1")) {
                accuracy += 1;
            } else if (probability_y1 < probability_y2 && trainPat[0].equals("y2")) {
                accuracy += 1;
            }
            System.out.println("Шаг " + i + ". Вероятность y1: " + probability_y1 + ". Вероятность y2: " + probability_y2);
            i++;
        }
        String acc = String.format("%.0f", accuracy / dataTrain.length * 100);
        System.out.print("Тосность распознавания: " + acc + "%");
    }
}
