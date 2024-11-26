import java.util.Comparator;

/**
 * Класс для сортировки объекта типа Car.
 */
public class CarsYearComparator implements Comparator<Car> {
    /**
     * Метод сортирует объект Car по году выпуска, начиная со старшего.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return возвращает int результат сравнения.
     */
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o2.getYear(), o1.getYear());
    }
}
