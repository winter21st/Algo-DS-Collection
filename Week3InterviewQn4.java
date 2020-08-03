
/**
 * Nuts and bolts - A disorganized carpenter has a mixed pile of n nuts and n bolts.
 * The goal is to find the corresponding pairs of nuts and bolts. Each nut fits exactly
 * one bolt and each bolt fits exactly one nut. By fitting a nut and a bolt together,
 * the carpenter can see which one is bigger (but the carpenter cannot compare two nuts
 * or two bolts directly). Design an algorithm for the problem that uses at most
 * proportional to nlog⁡n compares (probabilistically).
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Week3InterviewQn4 {
    public static void sort(int[] a, int[] b) {
        KnuthShuffle.shuffle(a);
        KnuthShuffle.shuffle(b);
        int previ = Integer.MIN_VALUE;
        previ = sort(a[0], b, 0, a.length - 1);
        for (int i = 1; i < a.length; i++) {
            if (a[i] < previ)
                previ = sort(a[i], b, 0, previ - 1);
            else
                previ = sort(a[i], b, previ + 1, a.length - 1);
        }
    }

    private static int sort(int ai, int[] b, int low, int high) {
        int i = low, gt = high;

        while (i < gt) {
            if (b[i] < ai)
                i++;
            else if (b[i] > ai)
                swap(b, i, gt--);
            else {
                if (b[gt] < ai)
                    swap(b, i++, gt);
                else
                    gt--;
            }
        }

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a, b;
        String line1 = "", line2 = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader("./" + args[0]));
            BufferedReader br2 = new BufferedReader(new FileReader("./" + args[1]));
            line1 = br1.readLine();
            line2 = br2.readLine();
            br1.close();
            br2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] ss1 = line1.split(",");
        String[] ss2 = line2.split(",");
        a = new int[ss1.length];
        b = new int[ss2.length];
        for (int i = 0; i < ss1.length; i++) {
            a[i] = Integer.parseInt(ss1[i]);
            b[i] = Integer.parseInt(ss2[i]);
        }
        Stopwatch w = new Stopwatch();
        Week3InterviewQn4.sort(a, b);
        System.out.println(w.elapsedTime());
    }

}