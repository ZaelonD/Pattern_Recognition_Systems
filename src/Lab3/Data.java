package Lab3;

import java.util.*;

// Класс для хранения данных в структуре HashMap
public final class Data {
    // Объявляем константную переменную тип Map
    private final Map<int[], Character> MAP;

    // Конструктор
    public Data() {
        this.MAP = new HashMap<>(); // Инициализация
    }

    // Метод put для заполнения HashMap
    public void put(int[] key, Character value) {
        this.MAP.put(key, value);
    }

    // Метод для получения всех ключей HashMap
    public Set<int[]> keySet() {
        return MAP.keySet();
    }

    // Получение значения по ключу
    public Character get(int[] key) {
        return MAP.get(key);
    }
}


