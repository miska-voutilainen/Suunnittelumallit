import java.util.Arrays;

public class ArraySort extends Main {
    public int[] array;
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortWithStrategy() {
        if (strategy != null && array != null) {
            strategy.sort(array);
        }
    }
}
