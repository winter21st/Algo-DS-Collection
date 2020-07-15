import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Week3InterviewQn1 {

    private static int[] aux;

    public static void sort(int[] arr) {
        aux = new int[arr.length / 2 + 1];
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (high <= low)
            return;

        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        // if(arr[mid] < arr[mid + 1]) return;
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        if (high == low + 1) {
            if (arr[low + 1] < arr[low]) {
                int temp = arr[low + 1];
                arr[low + 1] = arr[low];
                arr[low] = temp;
            }
        } else {
            for (int x = low; x <= mid; x++) {
                aux[x % aux.length] = arr[x];
            }

            int i = low;
            int j = mid + 1;
            for (int k = low; k <= high; k++) {
                if (i > mid)
                    arr[k] = arr[j++];
                else if (j > high) {
                    arr[k] = aux[i % aux.length];
                    i++;
                } else if (arr[j] < aux[i % aux.length])
                    arr[k] = arr[j++];
                else {
                    arr[k] = aux[i % aux.length];
                    i++;
                }
            }
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
        Week3InterviewQn1.sort(a);
        System.out.println(w.elapsedTime());
    }
}