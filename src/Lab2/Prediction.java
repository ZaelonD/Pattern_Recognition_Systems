package Lab2;

import java.util.List;

public class Prediction {

    public void predict(String[][] training_sample, String[][] test_sample, List<int[]> tests) {
        String[][] dataTrain = Data.dataArray(training_sample, 1);
        String[][] dataTest = Data.dataArray(test_sample, 1);
        int y1_count = ObjectClass.getY1_count();
        int y2_count = ObjectClass.getY2_count();
        int i = 1;
        for (String[] patient : dataTest) {
            int sum_y1 = 0;
            int sum_y2 = 0;

            for (int[] test : tests) {
                for (String[] trainPat : dataTrain) {
                    if (patient[test[0]].equals(trainPat[test[0]]) && patient[test[1]].equals(trainPat[test[1]])) {
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

            if (probability_y1 > probability_y2) {
                System.out.println("Тестовый пациент № " + i + " относится к первой группе");
            } else if (probability_y1 < probability_y2) {
                System.out.println("Тестовый пациент № " + i + " относится ко второй группе");
            } else {
                System.out.println("Тестовый пациент № " + i + " не принадлежит ни к одной из групп");
            }
            i++;
        }
    }
}
