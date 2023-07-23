package Lab4;

import java.io.*;
import java.util.*;
import java.util.stream.*;

// Класс для чтения данных из файла
public class ReadFile {

    private final List<List<Double>> data; // Список списков (800 строк по 8 столбцов)

    // Конструктор (На входе ссылка на файл)
    public ReadFile(String url) {
        String row; // Переменная для строки
        data = new ArrayList<>(); // Инициализируем data
        try {
            /*Читаем текст из потока ввода символов, буферизуя прочитанные символы,
                чтобы обеспечить эффективное считывание символов, массивов и строк.*/
            BufferedReader txt = new BufferedReader(new FileReader(url));
            // Считываем построчно
            while ((row = txt.readLine()) != null) {
                List<String> elem = new ArrayList<>(); // Создаем пустой список
                Collections.addAll(elem, row.split(" ")); // Добавляем элементы из строки в пустой список
                List<Double> data1 = elem.stream().map(Double::parseDouble).collect(Collectors.toList()); // Конвертируем список строк в вещественные числа
                Collections.addAll(data, data1); // Добавляем список в основной список
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Геттер для получения data
    public List<List<Double>> getData() {
        return data;
    }
}