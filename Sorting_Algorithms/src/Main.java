import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Main {
    public static class details {
        public int comparisons;
        public int exchanges;

        public details(int comparisons, int exchanges) {
            this.comparisons = comparisons;
            this.exchanges = exchanges;
        }

    }
    public static Random random = new Random();
    public static void main(String[] args) throws IOException {


        File time = new File("time.csv");
        FileWriter timeWriter = new FileWriter(time);
        timeWriter.append(" ,InsertionSort, Quicksort, Mergesort\n");
        timeWriter.close();
        File comparisons = new File("comparisons.csv");
        FileWriter comparisonsWriter = new FileWriter(comparisons);
        comparisonsWriter.append(" ,InsertionSort, Quicksort, Mergesort\n");
        comparisonsWriter.close();
        File exchanges = new File("exchanges.csv");
        FileWriter exchangesWriter = new FileWriter(exchanges);
        exchangesWriter.append(" ,InsertionSort, Quicksort, Mergesort>\n");
        exchangesWriter.close();

        for (int i = 100; i <= 100000; i*=2) {
            int[] array1, array2, array3;
            array1=random_array(1000);
            array2=array1.clone();
            array3=array1.clone();
        long startTime = System.nanoTime();
        details insertResults = insertionSort(array1);
        long insertTime = System.nanoTime() - startTime;


        startTime = System.nanoTime();
        details quickResults = quickSort(array2, 0, array2.length-1);
        long quickTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        details margeResults = quickSort(array2, 0, array2.length-1);
        long margeTime = System.nanoTime() - startTime;


            timeWriter = new FileWriter(time, true);
            timeWriter.append(i + ", " + insertTime + ", " + quickTime + ", " + margeTime +"\n");
            timeWriter.close();

            comparisonsWriter = new FileWriter(comparisons,true);
            comparisonsWriter.append(i + ", " + insertResults.comparisons + ", " + quickResults.comparisons + ", " + margeResults.comparisons +"\n");
            comparisonsWriter.close();

            exchangesWriter=new FileWriter(exchanges,true);
            exchangesWriter.append(i + ", " + insertResults.exchanges + ", " + quickResults.exchanges + ", " + margeResults.exchanges +"\n");
            exchangesWriter.close();
        }


    }
    public static int[] random_array(int size){
        int []list= new int[size];
        for (int i = 0; i < size; i++) {
            list[i]=random.nextInt(1000);
        }
        return list;
    }
    public static details insertionSort(int[]array){
        details insertion = new details(0,0);
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                insertion.comparisons++;
                insertion.exchanges++;
            }

            array[j + 1] = key;
            insertion.exchanges++;
        }
        return insertion;
        }
        public static details quickSort(int[] array, int low, int high){
            details quick = new details(0,0);
            if (low < high) {
                int pivotIndex = partition(array, low, high, quick);
                quickSort(array, low, pivotIndex - 1);
                quickSort(array, pivotIndex + 1, high);
            }
            return quick;
        }
    private static int partition(int[] arr, int low, int high, details quick) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                quick.exchanges++;
            }
            quick.comparisons++;
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        quick.exchanges += 2;
        return i + 1;
    }
    public static details mergeSort(int[] array, int left, int right){
        details marge = new details(0,0);
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid );
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right, marge);
        }
        return marge;
    }
    public static void merge(int[] arr, int left, int mid, int right, details marge) {
        int[] temp = new int[arr.length];
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            marge.comparisons++;
            marge.exchanges++;
            k++;
        }

        while (i <= mid) {
            arr[k] = temp[i];
            marge.exchanges++;
            i++;
            k++;
        }
    }

}
