import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String s1 = "java is fun and java is powerful";
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (c == ' ') {
                continue;
            }
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        System.out.println(map1);
        System.out.println(checkSymbolUniqueness(map1));
        System.out.println(averageSymbols(map1));
        System.out.println();


        String s2 = "!!! Java is Fun and java IS powerful !!!";
        s2 = removeSymbols(s2);
        String[] splitWords = splitString(s2);
        Map<String, Integer> map2 = new TreeMap<>();
        for (String word : splitWords) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }
        System.out.println(map2);
        System.out.println();


        Map<Integer, Character> map3 = new LinkedHashMap<>();
        map3.put(1, 'C');
        map3.put(2, 'B');
        map3.put(3, 'A');
        System.out.println(map3);
        System.out.println(invertedMap(map3));
        System.out.println();

        Car car1 = new Car("KIA", "Sportage", 2022);
        Car car2 = new Car("KIA", "RIO", 2023);
        Car car3 = new Car("LADA", "Vesta", 2015);
        Car car4 = new Car("LADA", "Granta", 2024);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        System.out.println(cars);
        cars.sort(new CarsBrandModelComparator());
        System.out.println(cars);
        cars.sort(new CarsYearComparator());
        System.out.println(cars);

    }

    /**
     * Метод проверяет коллекцию на уникальные символы (встречающиеся 1 раз).
     *
     * @param map В качестве параметра принимает интерфейс Map<Character, Integer>.
     * @return Возвращает true если есть уникальный символ, в противном случае false.
     */
    public static boolean checkSymbolUniqueness(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> el : map.entrySet()) {
            if (el.getValue() == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод подсчитывает среднее число используемых в строке символов.
     *
     * @param map В качестве параметра принимает интерфейс Map<Character, Integer>.
     * @return Возвращает число типа double приведенное к формату 1 символ после запятой.
     */
    public static double averageSymbols(Map<Character, Integer> map) {
        int sum = 0;
        for (Map.Entry<Character, Integer> el : map.entrySet()) {
            sum = el.getValue() + sum;
        }
        double average = (double) sum / map.size();
        BigDecimal bd = new BigDecimal(Double.toString(average));
        bd = bd.setScale(1, RoundingMode.HALF_UP); // Совсем вылетело из головы как привести число к определенному
        // формату, с гуглом в паре нашёл такой вариант.
        return bd.doubleValue();
    }

    /**
     * Метод удаляет все символ, а так же пробелы в начале и конце строки.
     *
     * @param s В качестве параметра принимает строку.
     */
    public static String removeSymbols(String s) {
        return s.replaceAll("[^a-zA-Z\\s]", "").trim().toLowerCase();
    }

    /**
     * Метод разделяет строку на отдельные слова по пробелу.
     *
     * @param s В качестве параметра принимает строку.
     * @return Возвращает массив строк, разделённых по пробелу.
     */
    public static String[] splitString(String s) {
        return s.split(" ");
    }

    /**
     * Метод меняет местами ключ и значение в Map.
     *
     * @param map В качестве параметра принимает интерфейс Map<Integer, Character>.
     * @return возвращает изменённое значение интерфейса Map<Character, Integer>.
     */
    public static Map<Character, Integer> invertedMap(Map<Integer, Character> map) {
        Map<Character, Integer> invertedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            invertedMap.put(entry.getValue(), entry.getKey());
        }
        return invertedMap;
    }
}