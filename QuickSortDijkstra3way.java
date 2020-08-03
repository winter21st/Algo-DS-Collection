import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuickSortDijkstra3way {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (high <= low)
            return;
        int lt = low, gt = high;
        int i = low;
        int p = arr[low];

        while (i <= gt) {
            if (arr[i] < p)
                swap(arr, i++, lt++);
            else if (arr[i] > p)
                swap(arr, i, gt--);
            else
                i++;
        }

        sort(arr, low, lt - 1);
        sort(arr, gt + 1, high);
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
        QuickSortDijkstra3way.sort(a);
        System.out.println(w.elapsedTime());
    }

}