import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.princeton.cs.algs4.Stopwatch;

public class ShellSort {

    public static void sort(int[] arr) {
        int size = arr.length;
        int h = 1;

        while (h < size / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < size; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    int temp = arr[j];
                    arr[j] = arr[j - h];
                    arr[j - h] = temp;
                }
            }
            h /= 3;
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
        ShellSort.sort(a);
        System.out.println(w.elapsedTime());
    }
}