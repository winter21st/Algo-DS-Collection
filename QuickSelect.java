import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuickSelect {
    public static int select(int arr[], int k) {
        KnuthShuffle.shuffle(arr);
        int low = 0;
        int high = arr.length - 1;
        while (high > low) {
            int j = partition(arr, low, high);
            if (k < j)
                high = j - 1;
            else if (k > j)
                low = j + 1;
            else
                return arr[k];
        }
        return arr[k];
    }

    static int partition(int arr[], int low, int high) {

        int i = low;
        int j = high + 1;

        while (true) {
            while (arr[low] > arr[++i]) {
                if (i == high)
                    break;
            }
            while (arr[low] < arr[--j]) {
                if (j == low)
                    break;
            }
            if (i >= j)
                break;
            swap(arr, i, j);
        }

        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a;
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("./" + args[0]))) {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] ss = line.split(",");
        a = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            a[i] = Integer.parseInt(ss[i]);
        }
        Stopwatch w = new Stopwatch();
        int k = QuickSelect.select(a, 500);
        System.out.println(w.elapsedTime());
    }
}