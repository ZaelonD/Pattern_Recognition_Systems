package Lab2;

import Lab2.interfaces.Fill;

import java.util.Random;

public class TrainingSampleTable implements Fill {

    private String[][] training_sample;

    @Override
    public void fill(String[][] factors, String[] y, int numOfPatients) {
        training_sample = new String[numOfPatients + 1][factors.length + 2];
        for (int i = 0; i <= numOfPatients; i++) {
            for (int j = 0; j < factors.length + 2; j++) {
                TestTable.fillHeader(i, j, training_sample);
                if (i != 0 && j == 0) {
                    training_sample[i][j] = String.valueOf(i);
                } else if (i != 0 && j == 1) {
                    training_sample[i][j] = y[new Random().nextInt(y.length)];
                    ObjectClass.count(training_sample[i][j]);
                }
                if (i > 0 && j > 1) {
                    training_sample[i][j] = factors[j - 2][new Random().nextInt(factors[j - 2].length)];
                }
            }
        }
    }

    public String[][] getTrainingSample() {
        return training_sample;
    }
}
