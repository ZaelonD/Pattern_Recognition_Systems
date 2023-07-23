package Lab2;

// Класс факторов
public class Factors {
    private static final String[] AGE =
            {"Пожилой", "Средний", "Молодой"}; // Возраст
    private static final String[] SEX =
            {"Мужской", "Женский"}; // Пол
    private static final String[] DISEASE_STAGE =
            {"Поздняя", "Начальная", "Средняя"}; // Стадия болезни
    private static final String[] SORE_SPOT =
            {"Голова", "Спина", "Живот", "Руки", "Ноги", "Отсутствует"}; // Больное место
    private static final String[] TEMPERATURE =
            {"Пониженная", "Нормальная", "Незначительно повышенная", "Значительно повышенная"}; // Температура
    private static final String[] OTHER_SENSATIONS =
            {"Озноб", "Отсутствие аппетита", "Тошнота", "Отсутствуют"}; // Прочие ощущения
    private static final String[][] FACTORS =
            {AGE, SEX, DISEASE_STAGE, SORE_SPOT, TEMPERATURE, OTHER_SENSATIONS}; // Массив факторов

    // Получение массива факторов
    public static String[][] getFactors() {
        return FACTORS;
    }
}
