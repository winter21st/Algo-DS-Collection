import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MergeSort {

    private static int[] aux;
    
    public static void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] aux, int low, int high) {
        if(high <= low) return;

        int mid = low + (high - low) /2;
        sort(arr, aux, low, mid);
        sort(arr, aux, mid + 1, high);
        merge(arr, aux, low, mid, high);
    }

    private static void merge(int[] arr, int[] aux, int low, int mid, int high) {
        for (int x = low; x < high; x++) {
            aux[x] = arr[x];
        }

        int i = low;
        int j = mid+ 1;
        for (int k = low; k <= high; k++) {
            if(i > mid) arr[k] = aux[j++];
            else if(j > mid) arr[k] = aux[i++];
            else if(aux[j] < aux[i]) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        int[] a;
        String line = "";
        try (BufferedReader br = new BufferedReader(
                new FileReader("/home/winter/Newfolder/Algo-DS-Collection/" + args[0]))) {
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
        MergeSort.sort(a);
        System.out.println(w.elapsedTime());
    }
}