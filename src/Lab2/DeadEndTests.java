package Lab2;

import Lab2.interfaces.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeadEndTests implements Print {

    private List<int[]> tests;

    public void calculating(String[][] data, List<int[]> combinations) {
        tests = new ArrayList<>();
        for (int[] pair : combinations) {
            boolean check = true;
            for (String[] datum : data) {
                if (datum[pair[0]].equals(String.valueOf(0)) && datum[pair[1]].equals(String.valueOf(0))) {
                    check = false;
                    break;
                }
            }
            if (check) {
                pair[0]++;
                pair[1]++;
                tests.add(pair);
            }
        }
    }

    public List<int[]> getTests() {
        return tests;
    }

    @Override
    public void print() {
        if (tests.isEmpty()) {
            System.out.println("Тупиковых тестов не найдено!");
        } else {
            System.out.print("Тупиковые тесты: ");
            for (int[] test : tests) {
                System.out.print(Arrays.toString(test) + " ");
            }
        }
    }
}
