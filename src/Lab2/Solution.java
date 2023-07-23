package Lab2;

import Lab2.print.PrintTable;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Patients patients = new Patients(14);
        TrainingSampleTable trainingSample = new TrainingSampleTable();
        trainingSample.fill(Factors.getFactors(), ObjectClass.getY(), patients.getNumOfPatients());
        String[][] data = trainingSample.getTrainingSample();
        SortTable sortTable = new SortTable();
        String[][] sort = sortTable.tableSort(data);
        System.out.println("Число пациентов первой группы: " + ObjectClass.getY1_count());
        System.out.println("Число пациентов второй группы: " + ObjectClass.getY2_count());
        PrintTable printTable = new PrintTable(sort);
        printTable.print();
        ComparisonTable comparisonTable = new ComparisonTable();
        comparisonTable.fill(sort, ObjectClass.getY(), patients.getNumOfPatients());
        String[][] data1 = comparisonTable.getComparison_table();
        PrintTable printTable1 = new PrintTable(data1);
        printTable1.print();
        List<int[]> pairs = Combinations.comb(Factors.getFactors().length, 2);
        DeadEndTests deadEndTests = new DeadEndTests();
        deadEndTests.calculating(Data.dataArray(data1, 3), pairs);
        deadEndTests.print();
        System.out.print("\nВведите количество тестовых пациентов: ");
        Patients patients2 = new Patients(scanner.nextInt());
        TestTable testTable = new TestTable();
        testTable.fill(Factors.getFactors(), ObjectClass.getY(), patients2.getNumOfPatients());
        String[][] data2 = testTable.getTest_sample();
        PrintTable printTable2 = new PrintTable(data2);
        printTable2.print();
        Prediction prediction = new Prediction();
        prediction.predict(data, data2, deadEndTests.getTests());
        Accuracy accuracy = new Accuracy();
        accuracy.accuracyCount(data, data2, deadEndTests.getTests());
    }
}
