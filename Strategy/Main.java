import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int smallSize = 30;
		int largeSize = 100000;

		// Create original arrays
		CreateArray caSmall = new CreateArray();
		int[] originalSmall = caSmall.createArray(smallSize).clone();
		CreateArray caLarge = new CreateArray();
		int[] originalLarge = caLarge.createArray(largeSize).clone();

		// Define strategies
		SortStrategy[] strategies = {
			new BubbleSort(),
			new InsertionSort(),
			new QuickSort()
		};
		String[] strategyNames = {"BubbleSort", "InsertionSort", "QuickSort"};

		System.out.println("\n--- Small Array Results (" + smallSize + ") ---");
		for (int i = 0; i < strategies.length; i++) {
			ArraySort sorter = new ArraySort();
			sorter.array = originalSmall.clone();
			sorter.setStrategy(strategies[i]);
			long start = System.nanoTime();
			sorter.sortWithStrategy();
			long end = System.nanoTime();
			System.out.println("\n" + strategyNames[i] + " sorted array:");
			for (int num : sorter.array) {
				System.out.print(num + " ");
			}
			System.out.println("\nTime: " + ((end - start) / 1_000_000.0) + " ms");
		}

		System.out.println("\n--- Large Array Results (" + largeSize + ") ---");
		for (int i = 0; i < strategies.length; i++) {
			ArraySort sorter = new ArraySort();
			sorter.array = originalLarge.clone();
			sorter.setStrategy(strategies[i]);
			long start = System.nanoTime();
			sorter.sortWithStrategy();
			long end = System.nanoTime();
			System.out.println(strategyNames[i] + " time: " + ((end - start) / 1_000_000.0) + " ms");
		}
	}
}
