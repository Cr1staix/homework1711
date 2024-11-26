import java.util.Comparator;

/**
 * Класс для сортировки объекта типа Car.
 */
public class CarsBrandModelComparator implements Comparator<Car> {
    /**
     * Метод сортирует объект Car по бренду, в случае одинакового бренда по модели.
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return возвращает int результат сравнения.
     */
    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getBrand().compareTo(o2.getBrand()) == 0) {
            return o1.getModel().compareTo(o2.getModel());
        }
        return o1.getBrand().compareTo(o2.getBrand());
    }
}
