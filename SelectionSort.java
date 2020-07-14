import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.princeton.cs.algs4.Stopwatch;

public class SelectionSort {

    public static void sort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < size; ++j) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a;
        String line = "";
        try (BufferedReader br = new BufferedReader(
                new FileReader("./" + args[0]))) {
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
        SelectionSort.sort(a);
        System.out.println(w.elapsedTime());
    }
}