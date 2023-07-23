package Lab3;

import java.util.*;

// Класс ввода
public class Input {

    // Метод для ввода данных и преобразование в массив
    public static int[] input() {
        String input = new Scanner(System.in).nextLine();
        return Arrays.stream(input.split(", ")).mapToInt(Integer::parseInt).toArray();
    }

}
