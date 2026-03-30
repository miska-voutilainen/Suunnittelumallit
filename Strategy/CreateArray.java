import java.util.Random;

public class CreateArray extends ArraySort {
    public int[] createArray(int size) {
        this.array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(31); // Generate random integers between 0 and 30
            this.array[i] = random.nextInt(1000001); // Generate random integers between 0 and 1000000
        }
        return this.array;
    }
}
