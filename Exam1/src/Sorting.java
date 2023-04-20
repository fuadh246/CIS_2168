import java.util.ArrayList;
import java.util.Random;
public class Sorting {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr.add(random.nextInt(100));
        }
        System.out.println("Before sorting: " + arr);
        mergeSort(arr);
        System.out.println("After sorting: " + arr);
    }
    public static void bubbleSort(ArrayList<Integer> arr) {
        int n = arr.size(); // O(n^2)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }
    public static void mergeSort(ArrayList<Integer> arr) {
        if (arr.size() < 2) { //O(n log n)
            return;
        }
        int mid = arr.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(arr.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(arr.subList(mid, arr.size()));
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    private static void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> arr) {
        int leftSize = left.size();
        int rightSize = right.size();
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left.get(i) <= right.get(j)) {
                arr.set(k++, left.get(i++));
            } else {
                arr.set(k++, right.get(j++));
            }
        }
        while (i < leftSize) {
            arr.set(k++, left.get(i++));
        }
        while (j < rightSize) {
            arr.set(k++, right.get(j++));
        }
    }


}
