import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.princeton.cs.algs4.Stopwatch;

public class InsertionSort {

    public static void sort(int[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                else j = 0;
            }
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
        InsertionSort.sort(a);
        System.out.println(w.elapsedTime());
    }
}