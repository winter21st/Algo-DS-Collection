import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MergeSortBottomUp {

    private static int[] aux;

    private static void sort(int[] arr) {
        int n = arr.length;
        aux = new int[n];

        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int low = 0; low < n - sz; low += sz + sz) {
                merge(arr, low, low + sz - 1, Math.min(low + sz + sz - 1, n - 1));
            }
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        for (int x = low; x <= high; x++) {
            aux[x] = arr[x];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid)
                arr[k] = aux[j++];
            else if (j > high)
                arr[k] = aux[i++];
            else if (aux[j] < aux[i])
                arr[k] = aux[j++];
            else
                arr[k] = aux[i++];
        }
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
        MergeSortBottomUp.sort(a);
        System.out.println(w.elapsedTime());
    }
}