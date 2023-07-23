package Lab2;

import Lab2.interfaces.Fill;

import java.util.Random;

public class TestTable implements Fill {
    private String[][] test_sample;
    @Override
    public void fill(String[][] factors, String[] y, int numOfPatients) {
        test_sample = new String[numOfPatients + 1][factors.length + 2];
        for (int i = 0; i <= numOfPatients; i++) {
            for (int j = 0; j < factors.length + 2; j++) {
                fillHeader(i, j, test_sample);
                if (i != 0 && j == 0) {
                    test_sample[i][j] = String.valueOf(i);
                } else if (i != 0 && j == 1) {
                    test_sample[i][j] = "y?";
                }
                if (i > 0 && j > 1) {
                    test_sample[i][j] = factors[j - 2][new Random().nextInt(factors[j - 2].length)];
                }
            }
        }
    }

    static void fillHeader(int i, int j, String[][] testSample) {
        if (i == 0 && j == 0) {
            testSample[i][j] = "i";
        } else if (i == 0 && j == 1) {
            testSample[i][j] = "y";
        } else if (i == 0) {
            testSample[i][j] = "x" + (j - 1);
        }
    }

    public String[][] getTest_sample() {
        return test_sample;
    }
}
