package Lab2;

import Lab2.interfaces.Fill;

public class ComparisonTable implements Fill {
    private String[][] comparison_table;


    @Override
    public void fill(String[][] training_sample, String[] y, int numOfPatients) {
        int y1_count = ObjectClass.getY1_count();
        int y2_count = ObjectClass.getY2_count();
        comparison_table = new String[y1_count * y2_count + 1][training_sample[0].length + 1];
        // Заполняем шапку таблицы
        for (int j = 0; j < training_sample[0].length + 1; j++) {
            if (j == 0) {
                comparison_table[0][j] = "i";
            } else if (j <= ObjectClass.getY().length) {
                comparison_table[0][j] = "y" + j;
            } else {
                comparison_table[0][j] = "x" + (j - 2);
            }
        }
        int p = 1;
        for (int i = 1; i <= y1_count; i++) {
            String[] rawY1 = training_sample[i];
            for (int j = y1_count + 1; j < training_sample.length; j++) {
                String[] rawY2 = training_sample[j];
                for (int k = 0; k < training_sample[0].length + 1; k++) {
                    if (k == 0) {
                        comparison_table[p][k] = String.valueOf(p);
                    } else if (k == 1) {
                        comparison_table[p][k] = "X" + i;
                    } else if (k == 2) {
                        comparison_table[p][k] = "X" + j;
                    } else if (rawY1[k - 1].equals(rawY2[k - 1])) {
                        comparison_table[p][k] = String.valueOf(0);
                    } else {
                        comparison_table[p][k] = String.valueOf(1);
                    }
                }
                p++;
            }
        }
    }

    public String[][] getComparison_table() {
        return comparison_table;
    }
}

